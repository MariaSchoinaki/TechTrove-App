package com.example.tecktrove.view.Customer.Saved;

import com.example.tecktrove.view.Customer.SavedProducts.SavedProductView;

public class SavedProductsStub implements SavedProductView {
    int home=0;
    int cart =0;

    int myAccount=0;

    int saved=0;
    @Override
    public void Home() {
        home++;
    }

    @Override
    public void Cart() {
        cart++;
    }

    @Override
    public void MyAccount() {
        myAccount++;
    }

    @Override
    public void Saved() {
        saved++;
    }

    public int getCart() {
        return cart;
    }

    public int getHome() {
        return home;
    }

    public int getMyAccount() {
        return myAccount;
    }

    public int getSaved() {
        return saved;
    }
}
