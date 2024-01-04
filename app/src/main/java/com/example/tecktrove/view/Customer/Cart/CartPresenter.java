package com.example.tecktrove.view.Customer.Cart;
public class CartPresenter {

    CartView view;

    public CartPresenter(CartView view){
        this.view= view;
    }
    public void onCart() {
        view.cart();
    }

    public void onHome() {
        view.home();
    }


}
