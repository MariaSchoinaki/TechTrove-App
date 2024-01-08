package com.example.tecktrove.view.Employer.HomeScreen;

import com.example.tecktrove.domain.ProductType;

import java.util.ArrayList;

public interface HomeScreenView {

    /**
     * Displayes the products
     * @param products the products
     */
    void displayProducts(ArrayList<ProductType> products);

    /**
     * Navigates the user to the home screen
     */
    void goToHome();

    /**
     * Navigates the user to the my account
     */
    void goToMyAccount();

    /**
     * Navigates the app to the add product form
     */
    void goToAddProduct();

    /**
     * Goes on the previous page
     */
    void goBack();
}
