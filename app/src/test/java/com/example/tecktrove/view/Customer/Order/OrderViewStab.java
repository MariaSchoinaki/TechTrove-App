package com.example.tecktrove.view.Customer.Order;

import com.example.tecktrove.view.MyAccount.OrderHistory.OrderView;

public class OrderViewStab implements OrderView {

    int home=0;
    int cart=0;
    int saved = 0;

    int myAccount =0 ;
    /**
     * navigate to home
     */
    @Override
    public void home() {
        home++;
    }

    /**
     * navigate to cart
     */
    @Override
    public void cart() {
        cart++;
    }

    /**
     * navigate to Saved
     */
    @Override
    public void Saved() {
        saved++;
    }

    /**
     * navigate to MyAcount
     */
    @Override
    public void MyAcount() {
        myAccount++;
    }
    /**
     * @return times navigated to cart;
     */
    public int getCart() {
        return cart;
    }

    /**
     * @return times navigated to home
     */
    public int getHome() {
        return home;
    }
    /**
     * @return times navigated to myAccount
     */
    public int getMyAccount() {
        return myAccount;
    }
    /**
     * @return times navigated to SavedProducts
     */
    public int getSaved() {
        return saved;
    }
}
