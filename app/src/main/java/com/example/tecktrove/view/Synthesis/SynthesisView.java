package com.example.tecktrove.view.Synthesis;

import com.example.tecktrove.domain.ProductType;

import java.util.ArrayList;

public interface SynthesisView {
    /**
     * Shows a custom message
     *
     * @param title the title of the window
     * @param msg   the message of the window
     */
    void showErrorMessage(String title, String msg);

    /**
     * Initializes an ArrayList of products
     *
     * @param products
     */
    void displayProducts(ArrayList<ProductType> products);

    /**
     * Displays a synthesis
     */
    void synthesisDisplay();

    /**
     * Navigates app to home screen
     */
    void home();

    /**
     * Navigates app to cart screen
     */
    void Cart();

    /**
     * Navigates app to my saved synthesis screen
     */
    void Saved();

    /**
     * Navigates app to my account screen
     */
    void MyAcount();
}
