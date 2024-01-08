package com.example.tecktrove.view.Customer.SavedProdacts;

public class SavedProductsPresenter {
    SavedProductView view;

    public SavedProductsPresenter(SavedProductView view){
        this.view= view;
    }


    public void onHome() {
        view.Home();
    }

    public void onCart() {
        view.Cart();
    }

    public void onSaved() {
        view.Saved();
    }

    public void onMyAccount() {
        view.MyAccount();
    }
}
