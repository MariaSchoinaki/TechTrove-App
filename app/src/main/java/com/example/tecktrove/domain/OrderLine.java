package com.example.tecktrove.domain;
import com.example.tecktrove.util.Money;

import java.math.BigDecimal;

public class OrderLine {
    private int quantity;
    private Money subTotal;
    private ProductType productType;

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
    }
    /**
     * Gets the quantity of a product
     *
     * @return the quantity
     */
    public int getQuantity() {
        return quantity;
    }
    /**
     * Gets the type of a product
     *
     * @return the ProductType
     */
    public ProductType getProductType(){
        return this.productType;
    }
    /**
     * Gets the price of a product
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
    void setQuantity(int quantity) {
        this.quantity = quantity;
        calculateSubTotal();
    }

    /**
     * Calculates the total of this product
     */
    private void calculateSubTotal(){
        this.subTotal = this.productType.getPrice().times(new BigDecimal(this.quantity));
    }

}
