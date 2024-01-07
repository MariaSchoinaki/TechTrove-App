package com.example.tecktrove.view.Synthesis;

import android.app.AlertDialog;
import android.util.Log;

import com.example.tecktrove.R;
import com.example.tecktrove.dao.ComponentDAO;
import com.example.tecktrove.dao.SynthesisDAO;
import com.example.tecktrove.domain.Component;
import com.example.tecktrove.domain.ProductType;
import com.example.tecktrove.domain.Synthesis;
import com.example.tecktrove.view.SharedViewModel;

import java.util.ArrayList;

public class SynthesisPresenter {
    private SynthesisView view;

    ComponentDAO componentDAO;
    SynthesisDAO synthesisDAO;
    ArrayList<ProductType> searchResults;

    SharedViewModel sharedViewModel;

    private Synthesis synthesis = new Synthesis();

    SynthesisPresenter(ComponentDAO componentDAO, SynthesisDAO synthesisDAO, SynthesisView view) {
        this.componentDAO = componentDAO;
        this.synthesisDAO = synthesisDAO;
        this.view = view;
        sharedViewModel = new SharedViewModel();
        sharedViewModel.setSharedSynthesis(this.synthesis);
    }

    public void onDisplayProducts(String category) {
        searchProducts(category);
        view.displayProducts(searchResults);
    }

    public void onSynthesisDisplay(){
        view.synthesisDisplay();
    }


    public boolean compatibilityCheck(Component component) {
        Boolean first = Boolean.FALSE;
        Boolean second = Boolean.FALSE;
        if (this.synthesis.getComponentList().size() >0) {
            for (Component comp : this.synthesis.getComponentList()) {
                if ((component.getRequiredPorts().getPorts().size() == 0)) {
                    first = Boolean.TRUE;

                    for (com.example.tecktrove.util.Pair<String, Integer> pair : comp.getRequiredPorts().getPorts()) {
                        for (com.example.tecktrove.util.Pair<String, Integer> pair1 : component.getAvailablePorts().getPorts()) {
                            if (pair.equals(pair1)) {
                                second = Boolean.TRUE;

                            }
                        }
                    }

                } else {
                    for (com.example.tecktrove.util.Pair<String, Integer> pair : comp.getAvailablePorts().getPorts()) {
                        for (com.example.tecktrove.util.Pair<String, Integer> pair1 : component.getRequiredPorts().getPorts()) {
                            if (pair.equals(pair1)) {
                                first = Boolean.TRUE;
                            }
                        }

                    }if(comp.getRequiredPorts().getPorts().size()==0){
                        second = Boolean.TRUE;
                    }else {
                    for (com.example.tecktrove.util.Pair<String, Integer> pair : comp.getRequiredPorts().getPorts()) {
                        for (com.example.tecktrove.util.Pair<String, Integer> pair1 : component.getAvailablePorts().getPorts()) {
                            if (pair.equals(pair1)) {
                                second = Boolean.TRUE;
                            }
                        }
                    }

                    }
                }
            }
        }else {
            return Boolean.TRUE;
        }
        for (Component comp : this.synthesis.getComponentList()) {
            if (  component.getRequiredPorts().getPorts().size()==0&&component.getAvailablePorts().getPorts().size()==0){
                return true;
            }
        }
        return first && second;
    }



    public void searchProducts(String query) {
        searchResults = new ArrayList<>();
        ArrayList<ProductType> allProducts = new ArrayList<>(componentDAO.findAll());
        if(query.equals("all")){
            searchResults = allProducts;
        }else {
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
    }

    public void saveToSynthesis(Component comp){
        this.synthesis.add(comp);

    }


}
