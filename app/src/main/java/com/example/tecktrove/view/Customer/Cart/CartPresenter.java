package com.example.tecktrove.view.Customer.Cart;
public class CartPresenter {

    CartView view;

    /**
     * Constructor
     * @param view CartView
     */
    public CartPresenter(CartView view){
        this.view= view;
    }

    /**
     * Navigates the app to the cart
     */
    public void onCart() {
        view.cart();
    }

    /**
     * Navigates the app to home screen
     */
    public void onHome() {
        view.home();
    }

    /**
     * Navigates the app to the purchase screen
     */
    public void onPurchase() {
        view.Purchase();
    }
}
