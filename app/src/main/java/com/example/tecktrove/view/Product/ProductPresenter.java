package com.example.tecktrove.view.Product;

import android.util.Log;

import com.example.tecktrove.dao.ComponentDAO;
import com.example.tecktrove.dao.SynthesisDAO;
import com.example.tecktrove.domain.Component;
import com.example.tecktrove.domain.Synthesis;

public class ProductPresenter {

    private ProductView view;
    private ComponentDAO components;
    private SynthesisDAO synthesisDAO;
    private Component comp;
    private Synthesis synthesi;

    ProductPresenter(ComponentDAO components, SynthesisDAO synthesisDAO,ProductView view){
        this.components = components;
        this.view = view;
        this.synthesisDAO = synthesisDAO;
    }

    public void setInfo(int modelNo) {
        comp = components.find(modelNo);
        synthesi = synthesisDAO.find(modelNo);
        if (comp != null) {
            view.showProductInfo(comp.getModelNo(), comp.getPrice(), comp.getName(), comp.getDescription(), comp.getManufacturer(), comp.getAvailablePorts(), comp.getRequiredPorts(), comp.getQuantity());
        }else if(synthesi != null){
            view.showSynthesisInfo(synthesi.getModelNo(),synthesi.getName(), synthesi.getPrice().toString(), synthesi.getComponentList());
        }
    }

    public void goToCart(int asked_quantity, int modelNo){
        comp = components.find(modelNo);
        synthesi = synthesisDAO.find(modelNo);
        if(comp!=null){
            if(asked_quantity <= comp.getQuantity() && asked_quantity!=0){
                comp.addQuantity(-asked_quantity);
                view.Cart(comp);
            }else{
                view.showMessage("Error", "The quantity you want is larger than what we have.");
            }
        }else if(synthesi!=null){
            if(asked_quantity <= synthesi.getQuantity() && asked_quantity!=0){
                view.Cart(synthesi);
            }else{
                Log.d("ProductPresenter",String.valueOf(synthesi.getQuantity()));
                view.showMessage("Error", "The quantity you want is larger than what we have.");
            }
        }

    }
    public void onIncreaseQuantity(){
        view.increaseQuantity();
    }
    public void onDecreaseQuantity(){
        view.decreaseQuantity();
    }
}
