package com.example.tecktrove.view.Customer.HomeScreen;

import com.example.tecktrove.domain.ProductType;

import java.util.ArrayList;

public interface HomeScreenView {

    /**
     * Displayes the products
     * @param products the products
     */
    void displayProducts(ArrayList<ProductType> products);

    /**
     * Navigates the user to the cart
     */
    void Cart();

    /**
     * Navigates the user to the home screen
     */
    void goToHome();

    /**
     * Navigates the user to the my account
     */
    void goToMyAccount();

    /**
     * Navigates the user to the make your own synthesis page
     */
    void diySynthesis();

    /**
     * Goes on the previous page
     */
    void goBack();

    /**
     * Navigates the user to the saved synthesis page
     */
    void saved();
}
