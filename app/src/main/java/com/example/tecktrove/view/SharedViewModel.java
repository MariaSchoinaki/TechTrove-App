package com.example.tecktrove.view;

import androidx.lifecycle.ViewModel;

import com.example.tecktrove.domain.Customer;

public class SharedViewModel extends ViewModel {
    private static Customer customer;

    public Customer getCustomer() {
        return customer;
    }

    public void setSharedCustomer(Customer customer) {
        this.customer = customer;
    }
}
