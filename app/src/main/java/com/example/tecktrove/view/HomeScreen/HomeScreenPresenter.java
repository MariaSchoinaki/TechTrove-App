package com.example.tecktrove.view.HomeScreen;

import com.example.tecktrove.dao.CustomerDAO;
import com.example.tecktrove.dao.EmployerDAO;

public class HomeScreenPresenter {

    private HomeScreenView view;
    CustomerDAO customers;
    EmployerDAO employers;

    public HomeScreenPresenter(HomeScreenView view, CustomerDAO customers, EmployerDAO employers){
        this.view = view;
        this.customers = customers;
        this.employers = employers;
    }
}
