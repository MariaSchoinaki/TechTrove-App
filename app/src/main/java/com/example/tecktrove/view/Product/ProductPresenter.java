package com.example.tecktrove.view.Product;

import android.util.Log;

import com.example.tecktrove.dao.ComponentDAO;
import com.example.tecktrove.dao.SynthesisDAO;
import com.example.tecktrove.domain.Component;
import com.example.tecktrove.domain.Customer;
import com.example.tecktrove.domain.Order;
import com.example.tecktrove.domain.OrderLine;
import com.example.tecktrove.domain.Synthesis;
import com.example.tecktrove.util.Pair;

public class ProductPresenter {

    private ProductView view;
    private ComponentDAO components;
    private SynthesisDAO synthesisDAO;
    private Component comp;
    private Synthesis synthesi;

    /**
     * Constructor of the presenter
     * @param components    component dao
     * @param synthesisDAO  synthesis dao
     * @param view          ProductView
     */
    ProductPresenter(ComponentDAO components, SynthesisDAO synthesisDAO,ProductView view){
        this.components = components;
        this.view = view;
        this.synthesisDAO = synthesisDAO;
    }

    /**
     * Finds if the product is a synthesis or a component and displays the correct information
     * @param modelNo  the model number of the product
     * @param customer  the customer logged in
     */
    public void setInfo(int modelNo, Customer customer) {
        comp = components.find(modelNo);
        synthesi = synthesisDAO.find(modelNo);
        boolean showRating1 = true;
        boolean showRating2 = false;
        if (comp != null) {
            view.showProductInfo(comp.getModelNo(), comp.getPrice(), comp.getName(), comp.getDescription(), comp.getManufacturer(), comp.getAvailablePorts(), comp.getRequiredPorts(), comp.getQuantity());
        }else if(synthesi != null){
            view.showSynthesisInfo(synthesi.getModelNo(),synthesi.getName(), synthesi.getPrice().toString(), synthesi.getComponentList(), synthesi.getRating());
            for(Pair<Double, Customer> rating: synthesi.getRatingsList()){
                if(rating.getSecond().equals(customer)){
                    showRating1 = false;
                }
            }
            for(Order o : customer.getOrderList()){
                for(OrderLine or: o.getOrderLines()){
                    if(or.getProductType().equals(synthesi)){
                        showRating2 = true;
                    }
                }
            }

            view.showRating(showRating1 && showRating2);
        }
    }

    /**
     * Checks if the quantity the customer asked is valid
     * @param asked_quantity    the quantity the customer wants
     * @param modelNo           the model number of the product the customer wants
     */
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
                view.showMessage("Error", "The quantity you want is larger than what we have.");
            }
        }

    }

    /**
     * Navigates the app to increase quantity
     */
    public void onIncreaseQuantity(){
        view.increaseQuantity();
    }
    /**
     * Navigates the app to decrease quantity
     */
    public void onDecreaseQuantity(){
        view.decreaseQuantity();
    }

    /**
     * Navigates the app to the home screen
     */
    public void onExit(){
        view.goToHome();
    }

    /**
     * Sets the rating the customer submitted
     * @param modelNo   the model number of the synthesis
     * @param rating    the rating the user submitted
     * @param customer  the customer
     */
    public void setRating(int modelNo, int rating, Customer customer){
        synthesi = synthesisDAO.find(modelNo);
        if(synthesi!=null){
            synthesi.setSubRating(rating,customer);
        }
        setInfo(modelNo, customer);
    }
}
