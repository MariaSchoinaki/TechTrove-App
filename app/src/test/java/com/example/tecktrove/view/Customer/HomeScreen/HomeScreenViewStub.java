package com.example.tecktrove.view.Customer.HomeScreen;

import com.example.tecktrove.domain.ProductType;

import java.util.ArrayList;

public class HomeScreenViewStub implements HomeScreenView{

    private int timesShownCategory = 0;
    private int timesVisitedHome = 0;
    private int timesVisitedMyAccount = 0;
    private int timesVisitedCart = 0;
    private int numberOfProducts;
    private int timesVisitedDiySynthesis = 0;
    private int goback = 0;

    @Override
    public void displayProducts(ArrayList<ProductType> products) {
        numberOfProducts = products.size();
        timesShownCategory++;
    }

    @Override
    public void Cart() {
        timesVisitedCart++;
    }

    @Override
    public void goToHome() {
        timesVisitedHome++;
    }

    @Override
    public void goToMyAccount() {
        timesVisitedMyAccount++;
    }

    @Override
    public void diySynthesis() {
        timesVisitedDiySynthesis++;
    }

    @Override
    public void goBack() {
        goback++;
    }

    public int getTimesShownCategory() {
        return timesShownCategory;
    }

    public int getTimesVisitedHome() {
        return timesVisitedHome;
    }

    public int getTimesVisitedMyAccount() {
        return timesVisitedMyAccount;
    }

    public int getTimesVisitedCart() {
        return timesVisitedCart;
    }

    public int getNumberOfProducts() {
        return numberOfProducts;
    }

    public int getGoback() {
        return goback;
    }

    public int getTimesVisitedDiySynthesis() {
        return timesVisitedDiySynthesis;
    }
}
