package com.example.tecktrove.domain;

import java.util.ArrayList;

public class Customer {
    private int customerID;
    private ArrayList<Synthesis> savedSynthesis;
    private ArrayList<ProductType> cart;

    public Customer(){}

    /**
     * Constructor of Customer
     *
     * @param customerID       the id of a customer
     * @param savedSynthesis   a list that contains all saved synthesis of a customer
     * @param cart             the customer's cart
     */
    public Customer(int customerID, ArrayList<Synthesis> savedSynthesis, ArrayList<ProductType>cart){
        this.customerID=customerID;
        this.savedSynthesis=savedSynthesis;
        this.cart=cart;
    }
    /**
     * Gets the id of the Customer
     *
     * @return the customer id
     */
    public int getCustomerID() {
        return this.customerID;
    }
    /**
     * Gets the list of the customer's saved synthesis
     *
     * @return the savedSynthesis
     */
    public ArrayList<Synthesis> getSavedSynthesis() {
        return this.savedSynthesis;
    }
    /**
     * Gets the list of the customer's cart
     *
     * @return the cart
     */
    public ArrayList<ProductType> getCart() {
        return this.cart;
    }
    /**
     * Sets the ID of the customer
     *
     * @param customerID  the ID of the customer
     */
    void setCustomerID(int customerID) {
        this.customerID = customerID;
    }
    /**
     * Sets the  customer's saved synthesis list
     *
     * @param savedSynthesis the customer's saved synthesis list
     */
    void setSavedSynthesis(ArrayList<Synthesis> savedSynthesis) {
        this.savedSynthesis = savedSynthesis;
    }
    /**
     * Sets the customer's cart
     *
     * @param cart the cart of the customer
     */
    void setCart(ArrayList<ProductType> cart) {
        this.cart = cart;
    }
}
