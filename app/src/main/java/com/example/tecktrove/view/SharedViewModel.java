package com.example.tecktrove.view;

import androidx.lifecycle.ViewModel;

import com.example.tecktrove.domain.Customer;
import com.example.tecktrove.domain.Employer;

public class SharedViewModel extends ViewModel {
    private static Customer customer;
    private static boolean isEmployer;
    private static Employer employer;

    public Customer getCustomer() {
        return customer;
    }

    public void setSharedCustomer(Customer customer) {
        this.customer = customer;
    }

    public boolean isEmployer(){
        return isEmployer;
    }

    public void setSharedEmployer(Employer employer){ this.employer = employer;}

    public Employer getEmployer(){return this.employer;}
    public void setIsEmployer(boolean isEmployer){this.isEmployer = isEmployer;}
}
