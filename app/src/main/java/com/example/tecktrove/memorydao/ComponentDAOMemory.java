package com.example.tecktrove.memorydao;

import com.example.tecktrove.dao.ComponentDAO;
import com.example.tecktrove.domain.Component;
import com.example.tecktrove.util.Port;

import java.util.ArrayList;


public class ComponentDAOMemory implements ComponentDAO {
    protected ArrayList<Component> components = new ArrayList<Component>();

    @Override
    public ArrayList<Component> findAll(){
        return new ArrayList<Component>(components);
    }

    @Override
    public ArrayList<Component> findByManufacturer(String manufacturer) {
        ArrayList <Component> manufacturers = new ArrayList<Component>();
        for(Component component :components){
            if(component.getManufacturer()==manufacturer){
                manufacturers.add(component);
            }
        }
        return manufacturers;
    }

    @Override
    public ArrayList<Component> findAllByAvailablePorts(Port ports) {
        ArrayList <Component> available = new ArrayList<Component>();
        for(Component component :components){
            if(component.getAvailablePorts()==ports){
                available.add(component);
            }
        }
        return available;
    }

    @Override
    public ArrayList<Component> findAllByRequiredPorts(Port ports) {
        ArrayList <Component> required = new ArrayList<Component>();
        for(Component component :components){
            if(component.getRequiredPorts()==ports){
                required.add(component);
            }
        }
        return required;

    }

    @Override
    public void delete(Component component) {
        components.remove(component);
    }

    public void deleteAll() {
        components.clear();
    }

    @Override
    public void deleteByAvailablePorts(Port ports) {
        for (int i =0; i<= findAllByAvailablePorts(ports).size();){
            components.remove(findAllByAvailablePorts(ports).get(i));
        }
    }

    @Override
    public void deleteByRequiredPorts(Port ports) {
        for (int i =0; i<= findAllByRequiredPorts(ports).size();){
            components.remove(findAllByRequiredPorts(ports).get(i));
        }
    }

    @Override
    public void deleteByManufacturer(String manufacturer) {
        for (int i =0; i<= findByManufacturer(manufacturer).size();){
            components.remove(findByManufacturer(manufacturer).get(i));
        }
    }



    @Override
    public void save(Component component) {
        components.add(component);
    }
}
