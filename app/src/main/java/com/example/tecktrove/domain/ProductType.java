package com.example.tecktrove.domain;

import com.example.tecktrove.contacts.Money;
public class ProductType {
    private int modelNo;
    private Money price;

    public ProductType(){}

    /**
     * Constructor of ProductType
     * @param modelNo       the model number as an Integer
     * @param price         the price of the ProductType
     */
    public ProductType(int ModelNo, Money Price){
        this.modelNo = ModelNo;
        this.price = Price;
    }

    /**
     * Gets the model number
     *
     * @return  the model number
     */
    public int getModelNo() {
        return modelNo;
    }

    /**
     * Gets the price of a ProductType
     *
     * @return  the price
     */
    public Money getPrice() {
        return price;
    }

    /**
     * Sets the model number of a ProductType
     *
     * @param modelNo   ProductType's model number
     */
    public void setModelNo(int ModelNo) {
        this.modelNo = ModelNo;
    }

    /**
     * Sets the price of a ProductType
     *
     * @param price   ProductType's price
     */
    public void setPrice(Money Price) {
        this.price = Price;
    }

}
