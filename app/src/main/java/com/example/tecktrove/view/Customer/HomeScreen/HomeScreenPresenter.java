package com.example.tecktrove.view.Customer.HomeScreen;

import android.util.Log;

import com.example.tecktrove.dao.ComponentDAO;
import com.example.tecktrove.dao.CustomerDAO;
import com.example.tecktrove.dao.EmployerDAO;
import com.example.tecktrove.dao.SynthesisDAO;
import com.example.tecktrove.domain.Component;
import com.example.tecktrove.domain.ProductType;

import java.util.ArrayList;

public class HomeScreenPresenter {

    private HomeScreenView view;
    CustomerDAO customers;
    EmployerDAO employers;
    ComponentDAO componentDAO;
    SynthesisDAO synthesisDAO;
    ArrayList<ProductType> searchResults;

    public HomeScreenPresenter(HomeScreenView view, CustomerDAO customers, EmployerDAO employers, ComponentDAO componentDAO, SynthesisDAO synthesisDAO){
        this.view = view;
        this.customers = customers;
        this.employers = employers;
        this.componentDAO = componentDAO;
        this.synthesisDAO = synthesisDAO;
    }

    void onDisplayProducts(String filter){
        searchProducts(filter);
        view.displayProducts(searchResults);
    }

    void onCart(){
        view.Cart();}

    void onHome(){view.goToHome();}

    void onMyAccount(){view.goToMyAccount();}

    private void searchProducts(String query) {
        searchResults = new ArrayList<>();
        ArrayList<ProductType> allProducts = new ArrayList<>(componentDAO.findAll());
        allProducts.addAll(new ArrayList<>(synthesisDAO.findAll()));

        if(query.equals("all")){
            searchResults = allProducts;
        }else {
            String[] queries = query.split(" ");


            for (ProductType prod : allProducts) {
                for (String q : queries) {
                    if (prod.getName().toLowerCase().contains(q.toLowerCase()) ||
                            (String.valueOf(prod.getModelNo())).equals(q.toLowerCase())) {
                        searchResults.add(prod);
                    }
                }
            }
        }
    }
}
