package com.example.tecktrove.view.Employer.Product.ProductInformation;

import com.example.tecktrove.dao.ComponentDAO;
import com.example.tecktrove.dao.SynthesisDAO;
import com.example.tecktrove.domain.Component;
import com.example.tecktrove.domain.Synthesis;
import com.example.tecktrove.util.Money;
import com.example.tecktrove.util.Pair;
import com.example.tecktrove.util.Port;

import java.math.BigDecimal;

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
    ProductPresenter(ComponentDAO components, SynthesisDAO synthesisDAO, ProductView view){
        this.components = components;
        this.view = view;
        this.synthesisDAO = synthesisDAO;
    }

    /**
     *
     *
     *
     */
    public void setInfo(int modelNo) {
        comp = components.find(modelNo);
        synthesi = synthesisDAO.find(modelNo);
        if (comp != null) {
            view.showProductInfo(comp.getModelNo(), comp.getPrice(), comp.getName(), comp.getDescription(), comp.getManufacturer(), comp.getAvailablePorts(), comp.getRequiredPorts(), comp.getQuantity());
        }else if(synthesi != null){
            view.showSynthesisInfo(synthesi.getModelNo(),synthesi.getName(), synthesi.getPrice().toString(), synthesi.getComponentList(), synthesi.getRating());
        }
    }

    /**
     * Checks if the changed information is correct and changes it
     * @param modelNo the model number of the component
     */
    public void ChangeInfo(int modelNo){
        comp = components.find(modelNo);
        if(comp!=null){
            String modelNumber = view.getModelNo();
            String name = view.getName();
            String price = view.getPrice();
            String manufacturer = view.getManufacturer();
            String description = view.getDescription();
            String avports = view.getAvailablePorts();
            String reqports = view.getRequiredPorts();

            if(modelNumber.equals("") || manufacturer.equals("") || price.equals("") || name.equals("") || description.equals("")){
                view.showMessage("Προσοχή!" ,"Τα πεδία: Όνομα, Περιγραφή, Τιμή, Κατασκευαστής και Κωδικός Προϊόντος πρέπει να είναι συμπληρωμένα.");
            }else if(components.find(name) != null){
                view.showMessage("Προσοχή!", "Υπάρχει προϊόν με αυτό το όνομα.");
            }else if(components.find(Integer.parseInt(modelNumber)) != null){
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
                    p.setFirst(values[0].trim()); p.setSecond(Integer.parseInt(values[1].trim()));
                    reqport.add(p);
                }
                comp.setAvailablePorts(avport); comp.setRequiredPorts(reqport);
                view.showMessage("", "Οι αλλαγές έγιναν.");
            }
        }
    }

    /**
     * Displays the form for changing the components info
     * @param modelNo   the model number of the component
     */
    public void goToChange(int modelNo){
        comp = components.find(modelNo);
        view.ChangeComponentInfo(comp);
    }

    /**
     * Navigates the app to the home screen
     */
    public void goToHomeScreen(){
        view.onExit();
    }

    /**
     * Increases the quantity of a product
     * @param modelNo   the model number of the component
     */
    public void onIncreaseQuantity(int modelNo){
        comp = components.find(modelNo);
        int quantity = view.getQuantity();
        if(quantity < 0){
            view.showMessage("Προσοχή!", "Λάθος εισαγωγή ποσότητας.");
        }else{
            comp.addQuantity(quantity);
            setInfo(modelNo);
        }
    }

    /**
     * Deletes a product
     * @param modelNo   the model number of the product
     */
    public void onDelete(int modelNo){
        comp = components.find(modelNo);
        synthesi = synthesisDAO.find(modelNo);
        if (comp != null) {
            components.delete(comp);
        }else if(synthesi != null){
            synthesisDAO.delete(synthesi);
        }
        view.showMessage("", "Το προϊόν διαγράφτηκε.");
    }
}
