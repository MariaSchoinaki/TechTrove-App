package com.example.tecktrove.domain;


import com.example.tecktrove.util.Money;
public class ProductType {
    protected int modelNo;
    protected Money price;
    protected String name;
    protected int quantity;

    public ProductType(){}

    /**
     * Constructor of ProductType
     * @param modelNo       the model number as an Integer
     * @param price         the price of the ProductType
     * @param name          the name of the ProductType
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

    public void setName(String name){
        this.name = name;
    }

    public void setQuantity(int q){
        this.quantity = q;
    }

    public int getQuantity(){
        return quantity;
    }

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
