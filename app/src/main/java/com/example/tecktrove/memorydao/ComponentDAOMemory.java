package com.example.tecktrove.memorydao;

import com.example.tecktrove.dao.ComponentDAO;
import com.example.tecktrove.domain.Component;
import com.example.tecktrove.util.Port;

import java.util.ArrayList;


public class ComponentDAOMemory implements ComponentDAO {
    protected static ArrayList<Component> components = new ArrayList<Component>();

    /**
     * Stores the component in the dao
     *
     * @param component the component
     */
    @Override
    public void save(Component component) {
        components.add(component);
    }


    /**
     * Returns all the components in the dao.
     *
     * @return  new ArrayList with the components
     */
    @Override
    public ArrayList<Component> findAll(){
        return new ArrayList<Component>(components);
    }

    /**
     * Finds a component by its name
     *
     * @param name the component's name
     * @return     a Component object or null
     */
    @Override
    public Component find(String name) {
        for (Component c : components) {
            if (c.getName() == name) {
                return c;
            }
        }
        return null;
    }

    /**
     * Finds a component by its model number
     *
     * @param modelNo component's model number
     * @return     a Component object or null
     */
    @Override
    public Component find(int modelNo) {
        for (Component c : components) {
            if (c.getModelNo() == modelNo) {
                return c;
            }
        }
        return null;
    }

    /**
     * Returns all the components made by
     * the given manufacturer
     *
     * @param manufacturer the manufacturer
     * @return ArrayList with the components or null
     */
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

    /**
     * Returns all the components which have
     * the given required ports.
     *
     * @param ports the required ports
     * @return     Arraylist with the components or null
     */
    @Override
    public ArrayList<Component> findAllByRequiredPorts(Port ports) {
        ArrayList <Component> required = new ArrayList<Component>();
        for(Component component :components){
            if(component.getRequiredPorts().getPorts().equals(ports.getPorts())){
                required.add(component);
            }
        }
        return required;

    }

    /**
     * Returns all the components which have
     * the given available ports.
     *
     * @param ports the available ports
     * @return  Arraylist with the components or null
     */
    @Override
    public ArrayList<Component> findAllByAvailablePorts(Port ports) {
        ArrayList <Component> available = new ArrayList<Component>();
        for(Component component :components){
            if(component.getAvailablePorts().equals(ports)){
                available.add(component);
            }
        }
        return available;
    }

    /**
     * Deletes the given component
     *
     * @param component the component
     */
    @Override
    public void delete(Component component) {
        components.remove(component);
    }

    /**
     * Deletes a component based on their name
     *
     * @param name the name of the component
     */
    @Override
    public void delete(String name) {
        components.remove(find(name));
    }

    /**
     * Deletes a component based on the model number
     *
     * @param modelNo the model number
     */
    @Override
    public void delete(int modelNo) {
        components.remove(find(modelNo));
    }

    /**
     * Function that deletes all
     * the components in the dao
     */
    public void deleteAll() {
        components.clear();
    }

    /**
     * Deletes all the components which have the
     * given available ports
     *
     * @param ports the available ports
     */
    @Override
    public void deleteByAvailablePorts(Port ports) {
        for (int i =0; i< findAllByAvailablePorts(ports).size();){
            components.remove(findAllByAvailablePorts(ports).get(i));
        }
    }

    /**
     * Deletes all the components which have the
     * given required ports
     *
     * @param ports the required ports
     */
    @Override
    public void deleteByRequiredPorts(Port ports) {
        for (int i =0; i< findAllByRequiredPorts(ports).size();){
            components.remove(findAllByRequiredPorts(ports).get(i));
        }
    }

    /**
     * Deletes all the components made by
     * given manufacturer
     *
     * @param manufacturer the manufacturer
     */
    @Override
    public void deleteByManufacturer(String manufacturer) {
        for (int i =0; i< findByManufacturer(manufacturer).size();){
            components.remove(findByManufacturer(manufacturer).get(i));
        }
    }
}

