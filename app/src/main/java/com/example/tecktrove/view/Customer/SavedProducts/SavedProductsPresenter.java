package com.example.tecktrove.view.Customer.SavedProducts;

public class SavedProductsPresenter {
    SavedProductView view;

    /**
     * Constructor
     *
     * @param view
     */
    public SavedProductsPresenter(SavedProductView view){
        this.view= view;
    }

    /**
     * Navigates the app to home screen
     */
    public void onHome() {
        view.Home();
    }

    /**
     * Navigates the app to cart screen
     */
    public void onCart() {
        view.Cart();
    }

    /**
     * Navigates the app to the my saved screen
     */
    public void onSaved() {
        view.Saved();
    }

    /**
     * Navigates the app to my account screen
     */
    public void onMyAccount() {
        view.MyAccount();
    }
}
