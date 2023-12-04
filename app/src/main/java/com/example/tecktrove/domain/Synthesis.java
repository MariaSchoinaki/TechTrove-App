package com.example.tecktrove.domain;

import com.example.tecktrove.util.Money;
import java.util.ArrayList;

public class Synthesis extends ProductType{
    private boolean publishState;
    private int numberOfRatings;
    private double subRating;
    private double rating;
    private Customer customer;
    private ArrayList<Component> components;
    private ArrayList<Pair<Double, Customer>> ratings;

    public Synthesis(){}

    /**
     * Constructor of Synthesis
     * @param components       the components of the Synthesis as an ArrayList<Component>
     * @param modelNo          the model number of the Synthesis as an Integer
     * @param price            the price of the Synthesis as Money
     */
    public Synthesis(int modelNo, Money price, String name, ArrayList<Component> components){
        super(modelNo, price, name);
        this.components = components;
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
        ratings.add(new Pair<>(subRating, customer));
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

    public void add(Component component) {
        this.components.add(component);
    }

    public void remove(Component component){
        this.components.remove(component);
    }

    public ArrayList<Component> getComponentList(){
        return this.components;
    }

    public ArrayList<Pair<Double, Customer>> getRatingsList(){
        return ratings;
    }

    public Customer getCustomer(){
        return this.customer;
    }
}
