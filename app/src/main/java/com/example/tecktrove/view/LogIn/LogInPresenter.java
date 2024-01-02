package com.example.tecktrove.view.LogIn;

import com.example.tecktrove.dao.CustomerDAO;
import com.example.tecktrove.dao.EmployerDAO;
import com.example.tecktrove.domain.User;

public class LogInPresenter {
    LogInView view;
    CustomerDAO customers;
    EmployerDAO employers;
    User employer;
    User customer;

    public LogInPresenter(LogInView view, CustomerDAO customers, EmployerDAO employers){
        this.view = view;
        this.customers = customers;
        this.employers = employers;
    }

    public LogInPresenter(LogInView view){
        this.view = view;
    }

    void onSignUp(){
        view.signUp();
    }

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

    public String getUserName(){
        if(view.isEmployer()){
            if(employer != null){
                return employer.getName();
            }
        }else{
            if(customer != null){
                return customer.getName();
            }
        }
        return "";
    }
}
