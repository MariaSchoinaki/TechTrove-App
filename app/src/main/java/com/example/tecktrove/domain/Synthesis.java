package com.example.tecktrove.domain;

import com.example.tecktrove.util.Money;
import com.example.tecktrove.util.Pair;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Synthesis extends ProductType{
    private boolean publishState;
    private int numberOfRatings;
    private double subRating;
    private double rating;
    private Customer customer;
    private ArrayList<Component> components;
    private ArrayList<Pair<Double, Customer>> ratings;

    /**
     * Default Constructor
     */
    public Synthesis(){
        this.ratings = new ArrayList<Pair<Double, Customer>>();
        this.components = new ArrayList<Component>();
    }

    /**
     * Constructor of Synthesis
     * @param modelNo          the model number of the Synthesis as an Integer
     * @param price            the price of the Synthesis as Money
     * @param name             the name of the Synthesis
     */
    public Synthesis(int modelNo, Money price, String name){
        super(modelNo, price, name, 0);
        this.ratings = new ArrayList<Pair<Double, Customer>>();
        this.components = new ArrayList<Component>();
    }

    /**
     * Gets the publish state of the Synthesis
     *
     * @return  the publish state
     */
    public boolean getPublishState() {
        return publishState;
    }

    /**
     * Gets the total number of ratings of the Synthesis
     *
     * @return  the number of ratings
     */
    public int getNumberOfRatings() {
        return numberOfRatings;
    }

    /**
     * Gets the sub rating of the Synthesis
     *
     * @return  the sub rating
     */
    public double getSubRating() {
        return subRating;
    }

    /**
     * Gets the rating of the Synthesis
     *
     * @return  the rating
     */
    public double getRating() {
        return rating;
    }

    /**
     * Sets the publish state of the Synthesis
     *
     * @param publishState   Synthesis's publish state
     */
    public void setPublishState(boolean publishState) {
        this.publishState = publishState;
    }

    /**
     * Sets the total number of ratings of the Synthesis
     *
     * @param numberOfRatings   Synthesis's total number of ratings
     */
    public void setNumberOfRatings(int numberOfRatings) {
        this.numberOfRatings = numberOfRatings;
    }

    /**
     * Sets the sub rating of the Synthesis
     *
     * @param subRating   Synthesis's sub rating
     */
    public void setSubRating(double subRating, Customer customer) {
        this.ratings.add(new Pair<>(subRating, customer));
        this.customer = customer;
        this.subRating = subRating;
        setNumberOfRatings(numberOfRatings + 1);
        calcRating(subRating);
    }

    /**
     * Calculates the total rating of the Synthesis
     *
     * @param subRating   Synthesis's sub rating
     */
    private void calcRating(double subRating) {
        double old = this.rating * (numberOfRatings - 1);
        this.rating = (this.rating + subRating)/numberOfRatings;
    }

    /**
     * Calculates the synthesis total price
     */
    private void calcPrice(){
        price = Money.euros(BigDecimal.valueOf(0));
        for(Component i : components){
            price = price.plus(i.getPrice());
        }
    }

    /**
     * Adds a component to the synthesis
     *
     * @param component the component
     */
    public void add(Component component) {
        this.components.add(component);
        calcPrice();
        calculate_quantity();
    }

    /**
     * Removes a component from the synthesis
     *
     * @param component the component
     */
    public void remove(Component component){
        this.components.remove(component);
        calculate_quantity();
    }

    /**
     * Returns an ArrayList of all the components
     * in the synthesis
     *
     * @return an ArrayList of {@link Component} objects
     */
    public ArrayList<Component> getComponentList(){ return this.components; }

    /**
     * Returns an Arraylist of all the ratings made by the users
     *
     * @return an ArrayList of {@code Pair} objects (rating, customer)
     */
    public ArrayList<Pair<Double, Customer>> getRatingsList(){ return this.ratings; }

    /**
     * Gets the total price of the synthesis
     *
     * @return the price
     */
    public Money getPrice(){return price;}

    /**
     * Gets the customer who made this synthesis
     *
     * @return a {@code Customer} object
     */
    public Customer getCustomer(){ return this.customer; }

    /**
     * Calculates the quantity of the Synthesis
     */
    private void calculate_quantity(){
        if(this.components.size()>0) {
            int q = this.components.get(0).getQuantity();
            for (Component comp : this.components) {
                if (comp.getQuantity() < q) {
                    q = comp.getQuantity();
                }
            }
            this.quantity = q;
        }else{
            this.quantity = 0;
        }
    }
}
