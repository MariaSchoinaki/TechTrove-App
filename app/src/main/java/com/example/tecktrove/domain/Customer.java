package com.example.tecktrove.domain;

public class Customer {
    private int customerID;
    private ArrayList<Synthesis> savedSynthesis;
    private ArrayList<ProductType> cart;

    public int getCustomerID() {
        return this.customerID;
    }

    public ArrayList<Synthesis> getSavedSynthesis() {
        return this.savedSynthesis;
    }

    public ArrayList<ProductType> getCart() {
        return this.cart;
    }

    void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    void setSavedSynthesis(ArrayList<Synthesis> savedSynthesis) {
        this.savedSynthesis = savedSynthesis;
    }

    void setCart(ArrayList<ProductType> cart) {
        this.cart = cart;
    }
}
