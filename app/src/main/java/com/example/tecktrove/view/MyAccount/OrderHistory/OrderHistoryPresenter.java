package com.example.tecktrove.view.MyAccount.OrderHistory;

public class OrderHistoryPresenter {

    private OrderHistoryView view;

    /**
     * Constructor
     * @param view OrderHistoryView
     */
    public OrderHistoryPresenter(OrderHistoryView view){
        this.view = view;
    }

    /**
     * navigate to home
     * */
    public void onHome() {
        view.home();
    }
    /**
     * navigate to cart
     * */
    public void onCart() {
        view.cart();
    }
    /**
     * navigate to Saved
     * */
    public void onSaved() {
        view.Saved();
    }

    /**
     * navigate to MyAcount
     * */
    public void onMyAcount() {
        view.MyAcount();
    }
}
