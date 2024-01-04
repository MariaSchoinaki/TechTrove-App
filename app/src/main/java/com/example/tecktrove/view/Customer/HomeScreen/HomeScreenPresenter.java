package com.example.tecktrove.view.Customer.HomeScreen;

import android.util.Log;

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

    void onAll(){
        view.All();
    }

    void onDisplayProducts(String filter){
        view.displayProducts(filter);
    }

    void onCart(){
        Log.d("HomeScreenPresenter", "onCart");view.Cart();}

    void onHome(){view.goToHome();}

    void onMyAccount(){view.goToMyAccount();}
}
