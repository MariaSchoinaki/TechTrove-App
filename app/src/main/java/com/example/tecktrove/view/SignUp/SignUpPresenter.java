package com.example.tecktrove.view.SignUp;

import com.example.tecktrove.dao.CustomerDAO;
import com.example.tecktrove.dao.EmployerDAO;
import com.example.tecktrove.util.Money;

import java.util.ArrayList;

public class SignUpPresenter {
    SignUpView view;
    CustomerDAO customers;
    EmployerDAO employers;

    public SignUpPresenter(SignUpView view, CustomerDAO customers, EmployerDAO employers){
        this.view = view;
        this.customers = customers;
        this.employers = employers;
    }

    void onLogIn(){ view.logIn(); }

    public void startProcess(ArrayList<String> info){
        boolean allgood = true;

        for(String field: info){
            if(field.equals("")) {
                allgood = false;
            }
        }

        if(!allgood) {
            view.showErrorMessage("Error", "Please fill all the fields.");
        }
    }
}
