package com.example.tecktrove.domain;

import com.example.tecktrove.util.Money;
import java.util.ArrayList;

public class Synthesis extends ProductType{
    private boolean publishState;
    private int numberOfRatings;
    private double subRating;
    private double rating;

    public Synthesis(){}

    /**
     * Constructor of Synthesis
     * @param publishState     the publish state of the Synthesis as a Boolean
     * @param numberOfRatings  the total number of ratings of the Synthesis as an Integer
     * @param subRating        the subRating of the Synthesis as a Double
     * @param rating           the total rating of the Synthesis as a Double
     * @param modelNo          the model number of the Synthesis as an Integer
     * @param price            the price of the Synthesis as Money
     */
    public Synthesis(int modelNo, Money price, String name,boolean publishState, int numberOfRatings, double subRating, double rating){
        super(modelNo, price, name);
        this.publishState = publishState;
        this.numberOfRatings = numberOfRatings;
        this.subRating = subRating;
        this.rating = rating;
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
    public void setSubRating(double subRating) {
        this.subRating = subRating;
    }
}
