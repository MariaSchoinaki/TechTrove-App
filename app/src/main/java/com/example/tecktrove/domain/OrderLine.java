package com.example.tecktrove.domain;

public class OrderLine {
    private int quantity;
    private Money subTotal;
    private ProductType ProductType;


    public int getQuantity() {
        return quantity;
    }

    public void getProductType(){
        this.ProductType;
    }

    public Money getSubTotal() {
        return subTotal;
    }

    void setQuantity(int quantity) {
        this.quantity = quantity;
    }


}
