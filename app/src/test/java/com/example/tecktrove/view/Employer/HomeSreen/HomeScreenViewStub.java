package com.example.tecktrove.view.Employer.HomeSreen;

import com.example.tecktrove.domain.ProductType;
import com.example.tecktrove.view.Employer.HomeScreen.HomeScreenView;

import java.util.ArrayList;

public class HomeScreenViewStub implements HomeScreenView {

    private int timesShownCategory = 0;
    private int timesVisitedHome = 0;
    private int timesVisitedMyAccount = 0;
    private int numberOfProducts;
    private int timesGoBack =0;
    private int timesAddedProducts = 0;

    @Override
    public void displayProducts(ArrayList<ProductType> products) {
        numberOfProducts = products.size();
        timesShownCategory++;
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
    public void goToAddProduct() {
        timesAddedProducts++;
    }

    @Override
    public void goBack() {
        timesGoBack++;
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

    public int getNumberOfProducts() {
        return numberOfProducts;
    }

    public int getTimesAddedProducts() {
        return timesAddedProducts;
    }

    public int getTimesGoBack() {
        return timesGoBack;
    }
}
