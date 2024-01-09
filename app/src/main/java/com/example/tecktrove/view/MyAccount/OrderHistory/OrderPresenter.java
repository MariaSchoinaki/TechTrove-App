package com.example.tecktrove.view.MyAccount.OrderHistory;

public class OrderPresenter {
    private OrderView view;

    public OrderPresenter(OrderView view){
        this.view = view;

    }

    public void onHome() {
        view.home();
    }

    public void onCart() {
        view.cart();
    }

    public void onSaved() {
        view.Saved();
    }

    public void onMyAcount() {
        view.MyAcount();
    }
}
