package com.example.tecktrove.view.Employer.HomeScreen;

import android.util.Log;

import com.example.tecktrove.dao.ComponentDAO;
import com.example.tecktrove.dao.CustomerDAO;
import com.example.tecktrove.dao.EmployerDAO;
import com.example.tecktrove.dao.SynthesisDAO;
import com.example.tecktrove.domain.ProductType;

import java.util.ArrayList;

public class HomeScreenPresenter {
    private HomeScreenView view;
    CustomerDAO customers;
    EmployerDAO employers;
    ComponentDAO componentDAO;
    SynthesisDAO synthesisDAO;
    ArrayList<ProductType> searchResults;

    /**
     * Constructor
     *
     * @param view
     * @param customers
     * @param employers
     * @param componentDAO
     * @param synthesisDAO
     */
    public HomeScreenPresenter(HomeScreenView view, CustomerDAO customers, EmployerDAO employers, ComponentDAO componentDAO, SynthesisDAO synthesisDAO){
        this.view = view;
        this.customers = customers;
        this.employers = employers;
        this.componentDAO = componentDAO;
        this.synthesisDAO = synthesisDAO;
    }

    /**
     * Displays the products coresponding to the filter
     * @param filter    the filter for the products
     */
    public void onDisplayProducts(String filter){
        searchProducts(filter);
        view.displayProducts(searchResults);
    }

    /**
     * Navigates the app to the home screen
     */
    public void onHome(){view.goToHome();}

    /**
     * Navigates the app to my account
     */
    public void onMyAccount(){view.goToMyAccount();}

    /**
     * Navigates the app to the previous screen
     */
    public void onBack(){
        view.goBack();
    }

    /**
     * Searches for products that match the filter
     * @param query the filter
     */
    private void searchProducts(String query) {
        searchResults = new ArrayList<>();
        ArrayList<ProductType> allProducts = new ArrayList<>(componentDAO.findAll());
        allProducts.addAll(new ArrayList<>(synthesisDAO.findAllPublished()));

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

    /**
     * Navigates the app to the add product form
     */
    public void onAddProduct(){
        view.goToAddProduct();
    }
}
