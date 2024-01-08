package com.example.tecktrove.view.Synthesis;

import android.app.AlertDialog;
import android.util.Log;

import com.example.tecktrove.R;
import com.example.tecktrove.dao.ComponentDAO;
import com.example.tecktrove.dao.SynthesisDAO;
import com.example.tecktrove.domain.Component;
import com.example.tecktrove.domain.ProductType;
import com.example.tecktrove.domain.Synthesis;
import com.example.tecktrove.util.Pair;
import com.example.tecktrove.view.SharedViewModel;

import java.util.ArrayList;

public class SynthesisPresenter {
    private SynthesisView view;

    ComponentDAO componentDAO;
    SynthesisDAO synthesisDAO;
    ArrayList<ProductType> searchResults;

    SharedViewModel sharedViewModel;

    private Synthesis synthesis = new Synthesis();

    /**
     * Constructor
     *
     * @param componentDAO
     * @param synthesisDAO
     * @param view
     * @param model
     */
    public SynthesisPresenter(ComponentDAO componentDAO, SynthesisDAO synthesisDAO, SynthesisView view ,SharedViewModel model) {
        this.componentDAO = componentDAO;
        this.synthesisDAO = synthesisDAO;
        this.view = view;
        model.setSharedSynthesis(this.synthesis);
    }

    /**
     * Calls displayProducts to display the products from the search result
     *
     * @param category
     */
    public void onDisplayProducts(String category) {
        searchProducts(category);
        view.displayProducts(searchResults);
    }

    /**
     * Calls synthesisDisplay to display the synthesis
     */
    public void onSynthesisDisplay(){
        view.synthesisDisplay();
    }

    /**
     * Checks the compatibility
     *
     * @param component
     *
     * @return if the component is compatible to the synthesis
     */
    public boolean compatibilityCheck(Component component) {
        Component motherboard = new Component();
        Boolean motherBoardExist = Boolean.FALSE;
        if (synthesis.getComponentList().size()==0){
            return true;
        }else {
            for (Component comp: synthesis.getComponentList()){
                if(comp.getName().toLowerCase().contains("motherboard".toLowerCase())){
                    motherboard = comp;
                    motherBoardExist = Boolean.TRUE;
                }
            }
            if(motherBoardExist){
                int count = 0;
                for (Pair<String,Integer> pair: component.getRequiredPorts().getPorts()){
                    for (Pair<String,Integer> pair2: motherboard.getAvailablePorts().getPorts()){
                        if (pair.equals(pair2)){
                            count++;
                        }
                    }
                }
                if (component.getRequiredPorts().getPorts().size() == count){
                    return true;
                }
            }else {
                if(component.getName().toLowerCase().contains("motherboard".toLowerCase())){
                    int countList = 0;
                    for (Component comp: synthesis.getComponentList()){
                        int count = 0;
                        for (Pair<String,Integer> pair: comp.getRequiredPorts().getPorts()){
                            for (Pair<String,Integer> pair2: component.getAvailablePorts().getPorts()){
                                if (pair.equals(pair2)){
                                    count++;
                                }
                            }

                        }
                        if (comp.getRequiredPorts().getPorts().size() == count){
                            countList++;
                        }
                    }
                    if(synthesis.getComponentList().size() == countList){
                        return true;
                    }
                }else{
                    return true;
                }
            }
        }
        return false;
    }


    /**
     * Searches for products that match the filter
     *
     * @param query the filter
     */
    public void searchProducts(String query) {
        searchResults = new ArrayList<>();
        ArrayList<ProductType> allProducts = new ArrayList<>(componentDAO.findAll());

            String[] queries = query.split(" ");

            Boolean contains = Boolean.FALSE;
            for (ProductType prod : allProducts) {
                for (String q : queries) {
                    if (prod.getName().toLowerCase().contains(q.toLowerCase()) ||
                            (String.valueOf(prod.getModelNo())).equals(q.toLowerCase())) {
                        if(compatibilityCheck((Component) prod)) {
                            for (Component component : synthesis.getComponentList()) {
                                if (component.getName().toLowerCase().contains("motherboard".toLowerCase())) {
                                    contains = Boolean.TRUE;
                                }
                            }
                            if (!contains||!prod.getName().toLowerCase().contains("motherboard".toLowerCase()))
                                searchResults.add(prod);
                        }
                    }
                }
            }
        }

    /**
     * Adds a component to the synthesis
     *
     * @param comp
     */
    public void saveToSynthesis(Component comp){
        this.synthesis.add(comp);

    }

    /**
     * Gets Search results
     *
     * @return search results as an ArrayList
     */
    public ArrayList<ProductType> getSearchResults(){
        return searchResults;
    }

    /**
     * Removes component from synthesis
     *
     * @param product
     */
    public void removeFromSynthesis(ProductType product) {
        SharedViewModel.getSynthesis().remove((Component)product);
    }

    /**
     * Navigates app to home screen
     */
    public void onHome() {
        view.home();
    }

    /**
     * Navigates app to cart screen
     */
    public void onCart() {
        view.Cart();
    }

    /**
     * Navigates app to my saved synthesis screen
     */
    public void onSaved() {
        view.Saved();
    }

    /**
     * Navigates app to my account screen
     */
    public void onMyAcount() {
        view.MyAcount();
    }
}
