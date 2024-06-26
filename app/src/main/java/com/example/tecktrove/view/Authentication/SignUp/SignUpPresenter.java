package com.example.tecktrove.view.Authentication.SignUp;

import com.example.tecktrove.contacts.Email;
import com.example.tecktrove.contacts.Telephone;
import com.example.tecktrove.dao.CustomerDAO;
import com.example.tecktrove.dao.EmployerDAO;
import com.example.tecktrove.domain.Customer;
import com.example.tecktrove.domain.Employer;
import com.example.tecktrove.domain.OrderLine;
import com.example.tecktrove.domain.ProductType;
import com.example.tecktrove.domain.Synthesis;
import com.example.tecktrove.util.Pair;

import java.util.ArrayList;

public class SignUpPresenter {
    SignUpView view;
    CustomerDAO customers;
    EmployerDAO employers;

    /**
     * Constructor of the presenter
     * @param view          sign up view
     * @param customers     customer dao
     * @param employers     employer dao
     */
    public SignUpPresenter(SignUpView view, CustomerDAO customers, EmployerDAO employers){
        this.view = view;
        this.customers = customers;
        this.employers = employers;
    }

    /**
     * Go to log in
     */
    void onLogIn(){ view.logIn(); }

    /**
     * Checks if the combination of all of the user's elements
     * are correct and navigates the app to the correct home screen
     */
    public void startProcess(){
        String username = view.getUsername();
        String password = view.getPassword();
        String email = view.getEmail();
        String telephone = view.getTelephone();
        String confPassword = view.getConfPassword();
        String fullname = view.getfullName();
        boolean isEmployer = view.isEmployer();

        if(username.equals("") || password.equals("") || email.equals("") || telephone.equals("") || confPassword.equals("") || fullname.equals("")) {
            view.showErrorMessage("Error", "Please fill all the fields.");
        }
        else if(username.length() < 4 || username.length() > 20){
            view.showErrorMessage("Error", "Please write a username between 4 and 20 letters.");
        }
        else if(username.contains(" ")){
            view.showErrorMessage("Error", "Username must not have spaces");
        }
        else if(telephone.length() != 10){
            view.showErrorMessage("Error", "Please write a valid phone number.");
        }
        else if(password.length()<8 || password.contains(" ")){
            view.showErrorMessage("Error","Password must be at least 8 letters and cannot contain spaces.");
        }
        else if(!(email.contains("@") && (email.contains(".com") || email.contains(".gr")))){
            view.showErrorMessage("Error", "Please write a valid email.");
        }
        else if(!password.equals(confPassword)){
            view.showErrorMessage("Error", "Password and confirmation password must match.");
        }
        else{
            String[] name = fullname.split(" ", 2);
            if(isEmployer){
                if(employers.findEmployerByUsername(username) != null){
                    view.showErrorMessage("Error", "Username already exists.");
                }else {
                    Employer employer = new Employer(employers.nextId(), username, password, name[0], name[1], new Email(email), new Telephone(telephone));
                    employers.save(employer);
                    view.signUp(employer);
                }
            }else{
                if(customers.findCustomerByUsername(username) != null){
                    view.showErrorMessage("Error", "Username already exists.");
                }else{
                    Customer customer = new Customer(customers.nextId(), username, password, name[0], name[1], new Email(email), new Telephone(telephone), new ArrayList<Synthesis>(), new ArrayList<OrderLine>());
                    customers.save(customer);
                    view.signUp(customer);
                }
            }
        }
    }
}
