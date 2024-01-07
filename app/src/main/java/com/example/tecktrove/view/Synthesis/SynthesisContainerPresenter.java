package com.example.tecktrove.view.Synthesis;

import com.example.tecktrove.dao.ComponentDAO;
import com.example.tecktrove.dao.SynthesisDAO;
import com.example.tecktrove.domain.Component;
import com.example.tecktrove.view.SharedViewModel;

import java.util.ArrayList;


public class SynthesisContainerPresenter {

    SynthesisContainerView view;

    SharedViewModel sharedViewModel;

    SynthesisContainerPresenter(  SynthesisContainerView view) {
        this.view = view;
    }

   public ArrayList<Component> getComponents(){
        sharedViewModel = new SharedViewModel();
        return sharedViewModel.getComponentsFromSynthesis();
   }


    public void onComplete() {
        view.completeSynthesis();
    }

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
        return count==6;
    }

    public void onSave() {
        view.save();
    }
}
