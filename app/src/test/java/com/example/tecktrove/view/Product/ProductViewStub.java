package com.example.tecktrove.view.Product;

import com.example.tecktrove.domain.Component;
import com.example.tecktrove.domain.ProductType;
import com.example.tecktrove.util.Money;
import com.example.tecktrove.util.Port;

public class ProductViewStub implements ProductView{

    private int timesShowInfoOfProduct = 0;
    private int timesVisitedCart = 0;
    private int timesShowingMessage = 0;
    private int quantity;
    private int timesIncreasedQuantity = 0;
    private int timesDecreasedQuantity = 0;


    @Override
    public void showInfo(int modelNo, Money price, String name, String description, String manufacturer, Port availablePorts, Port requiredPorts, int quantity) {
        timesShowInfoOfProduct++;
        this.quantity = quantity;
    }

    @Override
    public void Cart(ProductType product) {
        if(product instanceof Component){
            this.quantity = ((Component)product).getQuantity();
        }
        timesVisitedCart++;
    }

    @Override
    public void increaseQuantity() {
        timesIncreasedQuantity++;
    }

    @Override
    public void decreaseQuantity() {
        timesDecreasedQuantity++;
    }

    @Override
    public void showMessage(String title, String msg) {
        timesShowingMessage++;
    }

    public int getTimesShowInfoOfProduct() {
        return timesShowInfoOfProduct;
    }

    public ProductView getProductView(){
        return this;
    }

    public int getTimesVisitedCart() {
        return timesVisitedCart;
    }

    public int getTimesShowingMessage() {
        return timesShowingMessage;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getTimesDecreasedQuantity() {
        return timesDecreasedQuantity;
    }

    public int getTimesIncreasedQuantity() {
        return timesIncreasedQuantity;
    }
}
