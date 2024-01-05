package com.example.tecktrove.domain;


import com.example.tecktrove.util.Money;
public class ProductType {
    protected int modelNo;
    protected Money price;
    protected String name;
    protected int quantity;

    /**
     * Default Constructor
     */
    public ProductType(){}

    /**
     * Constructor of ProductType
     *
     * @param modelNo       the model number of the product
     * @param price         the price of the product
     * @param name          the name of the product
     * @param quantity      the quantity of the product
     */
    public ProductType(int modelNo, Money price, String name, int quantity){
        this.modelNo = modelNo;
        this.price = price;
        this.name = name;
        this.quantity = quantity;
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
     * Gets the name of the ProductType
     * @return
     */
    public String getName(){
        return this.name;
    }

    /**
     * Sets the model number of a ProductType
     *
     * @param modelNo   ProductType's model number
     */
    public void setModelNo(int modelNo) {
        this.modelNo = modelNo;
    }

    /**
     * Sets the price of a ProductType
     *
     * @param price   ProductType's price
     */
    public void setPrice(Money price) {
        this.price = price;
    }

    /**
     * Sets the name of the ProductType
     *
     * @param name the name
     */
    public void setName(String name){
        this.name = name;
    }

    /**
     * Sets the quantity of the ProductType
     *
     * @param q the quantity
     */
    public void setQuantity(int q){
        this.quantity = q;
    }

    /**
     * Gets the quantity of the ProductType
     *
     * @return the quantity
     */
    public int getQuantity(){
        return quantity;
    }

    /**
     * Returns {@code true} if an object is equals
     * with the object ProductType
     *
     * @param other the other object
     * @return  true if the objects are equal, false otherwise
     */
    @Override
    public boolean equals(Object other) {
        if (other == null){
            return false;
        }
        if (this == other){
            return true;
        }
        if (!(other instanceof ProductType)){
            return false;
        }
        ProductType product = (ProductType) other;
        return this.getModelNo() == product.getModelNo();
    }
}
