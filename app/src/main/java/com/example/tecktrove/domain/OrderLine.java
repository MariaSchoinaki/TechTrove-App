package com.example.tecktrove.domain;

import com.example.tecktrove.util.Money;

import java.math.BigDecimal;

public class OrderLine {
    private int quantity;
    private Money subTotal;
    private ProductType productType;

    /**
     * Deafult Constructor
     */
    public OrderLine(){}

    /**
     * Constructor of OrderLine
     *
     * @param quantity         the quantity of a specific product inside the customers order
     * @param productType      the type of a product
     */
    public OrderLine(int quantity, ProductType productType){
        this.quantity=quantity;
        this.productType=productType;
        calculateSubTotal();
    }

    /**
     * Gets the quantity of a product
     *
     * @return the quantity
     */
    public int getQuantity() {
        return this.quantity;
    }

    /**
     * Gets the product of the orderline
     *
     * @return the ProductType
     */
    public ProductType getProductType(){
        return this.productType;
    }

    /**
     * Gets the price of the product of the orderline
     *
     * @return the subTotal
     */
    public Money getSubTotal() {
        return this.subTotal;
    }

    /**
     * Sets the quantity of a product
     *
     * @param quantity the quantity that the customer needs
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
        calculateSubTotal();
    }

    /**
     * Sets the product for this orderline
     *
     * @param productType   the product
     */
    public void setProductType(ProductType productType){
        this.productType = productType;
    }

    /**
     * Calculates the total of this product
     */
    private void calculateSubTotal(){
        this.subTotal = this.productType.getPrice().times(new BigDecimal(this.quantity));
    }

    /**
     * Returns {@code true} if an object is equals
     * with the object orderline
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
        if (!(other instanceof OrderLine)){
            return false;
        }
        OrderLine o = (OrderLine) other;
        return this.productType.equals(o.getProductType()) && this.quantity == o.getQuantity();
    }
}
