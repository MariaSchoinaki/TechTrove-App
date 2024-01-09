package com.example.tecktrove.view.Synthesis;

import com.example.tecktrove.dao.ComponentDAO;
import com.example.tecktrove.dao.SynthesisDAO;
import com.example.tecktrove.domain.Component;
import com.example.tecktrove.view.SharedViewModel;

import java.util.ArrayList;


public class SynthesisContainerPresenter {

    SynthesisContainerView view;

    SharedViewModel sharedViewModel;

    SynthesisDAO synthesisDAO;

    /**
     * Constructor
     *
     * @param view
     * @param model
     * @param synthesisDAO
     */
    public SynthesisContainerPresenter(SynthesisContainerView view, SharedViewModel model, SynthesisDAO synthesisDAO) {
        this.sharedViewModel= model;
        this.view = view;
        this.synthesisDAO = synthesisDAO;
    }

    /**
     * Gets the components list
     *
     * @return the components as an ArrayList
     */
   public ArrayList<Component> getComponents(){
        return sharedViewModel.getComponentsFromSynthesis();
   }

    /**
     * Calls completeSynthesis
     */
    public void onComplete() {
        view.completeSynthesis();
    }

    /**
     * Checks if the synthesis contains mandatory components
     *
     * @return if the synthesis is completed
     */
    public Boolean completeSynthesis() {
        String box = "box";
        String cpu = "cpu";
        String motherboard = "motherboard";
        String psu = "psu";
        String ram = "ram";
        String gpu = "gpu";
        int count = 0;
        for (Component component : sharedViewModel.getComponentsFromSynthesis()) {
            if (component.getName().toLowerCase().contains(box.toLowerCase())||component.getName().toLowerCase().contains(cpu.toLowerCase())||component.getName().toLowerCase().contains(motherboard.toLowerCase())||component.getName().toLowerCase().contains(ram.toLowerCase())||component.getName().toLowerCase().contains(psu.toLowerCase())||component.getName().toLowerCase().contains(gpu.toLowerCase())) {
                count++;
            }
        }
        if(count == 6){
            saveSynthesis();
        }
        return count==6;
    }

    /**
     * Calls saveSynthesis in order to save
     */
    public void onSave() {
        view.save();
        saveSynthesis();
    }

    /**
     * Saves synthesis
     */
    private void saveSynthesis(){
        SharedViewModel.getSynthesis().setName(view.getName());
        int id = (synthesisDAO.findAll().size() > 0 ? synthesisDAO.findAll().get(synthesisDAO.findAll().size()-1).getModelNo()+1 : 1);
        SharedViewModel.getSynthesis().setModelNo(id);
        sharedViewModel.getCustomer().getSavedSynthesis().add(SharedViewModel.getSynthesis());
        synthesisDAO.save(SharedViewModel.getSynthesis());
    }
}
