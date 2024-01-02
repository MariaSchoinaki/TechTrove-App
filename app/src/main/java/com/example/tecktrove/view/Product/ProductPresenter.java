package com.example.tecktrove.view.Product;

import com.example.tecktrove.dao.ComponentDAO;
import com.example.tecktrove.domain.Component;

public class ProductPresenter {

    private ProductView view;
    private ComponentDAO components;
    private Component comp;

    ProductPresenter(ComponentDAO components, ProductView view){
        this.components = components;
        this.view = view;
    }

    public void setInfo(int modelNo) {
        comp = components.find(modelNo);
        if (comp != null) {
            view.showInfo(comp.getModelNo(), comp.getPrice(), comp.getName(), comp.getDescription(), comp.getManufacturer(), comp.getAvailablePorts(), comp.getRequiredPorts(), comp.getQuantity());
        }
    }

    public void goToCart(int asked_quantity){
        if(asked_quantity <= comp.getQuantity() && asked_quantity!=0){
            comp.addQuantity(-asked_quantity);
            view.Cart(comp);
        }else{
            view.showMessage("Error", "The quantity you want is larger than what we have.");
        }
    }
    public void onIncreaseQuantity(){
        view.increaseQuantity();
    }
    public void onDecreaseQuantity(){
        view.decreaseQuantity();
    }
}
