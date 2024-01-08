package com.example.tecktrove.view.Authentication.LogIn;

import com.example.tecktrove.dao.CustomerDAO;
import com.example.tecktrove.dao.EmployerDAO;
import com.example.tecktrove.domain.User;

public class LogInPresenter {
    LogInView view;
    CustomerDAO customers;
    EmployerDAO employers;
    User employer;
    User customer;

    /**
     * Constructor
     * @param view          login view
     * @param customers     Customer dao
     * @param employers     Employer dao
     */
    public LogInPresenter(LogInView view, CustomerDAO customers, EmployerDAO employers){
        this.view = view;
        this.customers = customers;
        this.employers = employers;
    }

    /**
     * Go to sign up
     */
    void onSignUp(){
        view.signUp();
    }

    /**
     * Checks if the combination username-password-isEmployer is correct
     * and them navigates the app in the correct home screen
     */
    public void startProcess(){
        String username = view.getUsername();
        String password = view.getPassword();
        boolean isEmployer = view.isEmployer();


        if(username.equals("")){
            view.showErrorMessage("Error", "Please fill in the username field");
        }
        else if(password.equals("")){
            view.showErrorMessage("Error", "Please fill in the password field");
        }
        else if(!(password.equals("") || username.equals(""))){
            if(isEmployer){
                employer = employers.findEmployerByUsernameAndPassword(username,password);
                if (employer != null){
                    view.login(employer);
                }else{
                    view.showErrorMessage("Error", "User does not exist with this combo. Try again");
                }
            }else{
                customer = customers.findCustomerByUsernameAndPassword(username,password);
                if (customer != null){
                    view.login(customer);
                }else{
                    view.showErrorMessage("Error", "User does not exist with this combo. Try again");
                }
            }


        }

    }
}
