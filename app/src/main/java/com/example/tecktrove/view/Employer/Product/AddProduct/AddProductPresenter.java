package com.example.tecktrove.view.Employer.Product.AddProduct;

import com.example.tecktrove.dao.ComponentDAO;
import com.example.tecktrove.domain.Component;
import com.example.tecktrove.util.Money;
import com.example.tecktrove.util.Pair;
import com.example.tecktrove.util.Port;

import java.math.BigDecimal;

public class AddProductPresenter {

    private AddProductView view;
    private ComponentDAO components;

    /**
     * Constructor of the presenter
     *
     * @param view          AddProductView view
     * @param components    component dao
     */
    public AddProductPresenter(AddProductView view, ComponentDAO components){
        this.view = view;
        this.components = components;
    }

    /**
     * Helps presenter call goToHomeScreen, so
     * that the navigation return back to home screen
     */
    void onHomeScreen(){
        view.goToHomeScreen();
    }

    /**
     * Checks if the given from the employer values, are following
     * some of the basic rules. Sets the values of the new component.
     * Stores the component at the component dao and returns to home screen
     */
    void saveProduct(){
        String modelNumber = view.getModelNo();
        String name = view.getName();
        String price = view.getPrice();
        String manufacturer = view.getManufacturer();
        String description = view.getDescription();
        String avports = view.getAvailablePorts();
        String reqports = view.getRequiredPorts();

        Component comp = new Component();

        if(modelNumber.equals("") || manufacturer.equals("") || price.equals("") || name.equals("") || description.equals("")){
            view.showMessage("Προσοχή!" ,"Τα πεδία: Όνομα, Περιγραφή, Τιμή, Κατασκευαστής και Κωδικός Προϊόντος πρέπει να είναι συμπληρωμένα.");
        }else if(components.find(name) != null){
            view.showMessage("Προσοχή!", "Υπάρχει προϊόν με αυτό το όνομα.");
        }else if(components.find(modelNumber) != null){
            view.showMessage("Προσοχή!", "Υπάρχει προϊόν με αυτόν τον κωδικό.");
        }else{
            comp.setDescription(description); comp.setManufacturer(manufacturer); comp.setName(name);
            comp.setModelNo(Integer.parseInt(modelNumber));
            if(price.contains("€")){
                price = price.replace("€", "").trim();
            }
            comp.setPrice(Money.euros(new BigDecimal(Double.parseDouble(price))));
            Port avport = new Port();
            String[] avpairs = avports.split(",");
            Port reqport = new Port();
            String[] reqpairs = reqports.split(",");
            for(String pair: avpairs){
                if(pair.equals("") || !pair.contains(":")) break;
                Pair<String, Integer> p = new Pair<>();
                String[] values = pair.split(":");
                p.setFirst(values[0].trim()); p.setSecond(Integer.parseInt(values[1].trim()));
                avport.add(p);
            }
            for(String pair: reqpairs){
                if(pair.equals("") || !pair.contains(":")) break;
                Pair<String, Integer> p = new Pair<>();
                String[] values = pair.split(":");
                p.setFirst(values[0].trim());
                p.setSecond(Integer.parseInt(values[1].trim()));
                reqport.add(p);
            }
            comp.setAvailablePorts(avport); comp.setRequiredPorts(reqport);
            components.save(comp);
            onHomeScreen();
        }
    }
}
