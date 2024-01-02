package com.example.tecktrove.domain;

import com.example.tecktrove.contacts.Email;
import com.example.tecktrove.contacts.Telephone;

import java.util.ArrayList;

public class Customer extends User {

    private ArrayList<Synthesis> savedSynthesis;
    private ArrayList<ProductType> cart;

    public Customer(){}

    /**
     * Constructor of Customer
     *
     *
     * @param savedSynthesis   a list that contains all saved synthesis of a customer
     * @param cart             the customer's cart
     */
    public Customer( int id, String username, String password, String firstName, String lastName, Email email, Telephone telephone, ArrayList<Synthesis> savedSynthesis, ArrayList<ProductType>cart){
        super(id,username,password, firstName,lastName,email,telephone);
        this.savedSynthesis=savedSynthesis;
        this.cart=cart;
    }
    /**
     * Gets the id of the Customer
     *
     * @return the customer id
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
     * Sets the  customer's saved synthesis list
     *
     * @param savedSynthesis the customer's saved synthesis list
     */
    public void setSavedSynthesis(ArrayList<Synthesis> savedSynthesis) {
        this.savedSynthesis = savedSynthesis;
    }
    /**
     * Sets the customer's cart
     *
     * @param cart the cart of the customer
     */
    public void setCart(ArrayList<ProductType> cart) {
        this.cart = cart;
    }

    public void addToSavedSynthesis(Synthesis synthesis){
        this.savedSynthesis.add(synthesis);
    }

    public void removeFromSaved(Synthesis synthesis){
        this.savedSynthesis.remove(synthesis);
    }

    public void addToCart(ProductType product){
        this.cart.add(product);
    }

    public void removeFromCart(ProductType product){
        this.cart.remove(product);
    }

    public ProductType getProductFromCart(int ProductID){
        int i = this.cart.size() - 1;
        ProductType p;
        while(i>=0){
            p = this.cart.get(i);
            if(p.getModelNo() == ProductID){
                return p;
            }
            i-=1;
        }
        return null;
    }
    public ProductType getProductFromSaved(int ProductID){

        int j = this.savedSynthesis.size()-1;
        ProductType p;

        while(j>=0){
            p = this.savedSynthesis.get(j);
            if(p.getModelNo() == ProductID){
                return p;
            }
            j-=1;
        }
        return null;
    }
}
