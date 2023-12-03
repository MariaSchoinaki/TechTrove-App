package com.example.tecktrove.domain;

import java.util.ArrayList;

public class Component extends ProductType{

    private String name;
    private String description;
    private String manufacturer;
    private ArrayList<T, K> availablePorts;
    private ArrayList<T, K> requiredPorts;

    public Component(){}

    /**
     * Constructor of Component
     * @param name            the name of the component as a String
     * @param description     the description of the component as a String
     * @param manufacturer    the manufacturer of the component as a String
     * @param availablePorts  the available ports of the component as an ArrayList
     * @param requiredPorts   the required ports of the component as an ArrayList
     * @param modelNo         the model number of the Component as an Integer
     * @param price           the price of the Component as Money
     */
    public Component(int modelNo, Money price, String name, String description, String manufacturer, ArrayList<T, K> availablePorts, ArrayList<T, K> requiredPorts){
        super(modelNo, price);
        this.name = name;
        this.description = description;
        this.manufacturer = manufacturer;
        this.availablePorts = availablePorts;
        this.requiredPorts = requiredPorts;
    }

    /**
     * Gets the name of the component
     *
     * @return  the name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the description of the component
     *
     * @return  the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Gets the manufacturer of the component
     *
     * @return  the manufacturer
     */
    public String getManufacturer() {
        return manufacturer;
    }

    /**
     * Gets the available ports of the component
     *
     * @return  the available ports
     */
    public ArrayList<T, K> getAvailablePorts() {
        return availablePorts;
    }

    /**
     * Gets the required ports of the component
     *
     * @return  the required ports
     */
    public ArrayList<T, K> getRequiredPorts() {
        return requiredPorts;
    }

    /**
     * Sets the name of a Component
     *
     * @param name   Component's name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets the description of a Component
     *
     * @param description   Component's description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Sets the manufacturer of a Component
     *
     * @param manufacturer   Component's manufacturer
     */
    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    /**
     * Sets the available ports of a Component
     *
     * @param availablePorts   Component's available ports
     */
    public void setAvailablePorts(ArrayList<T, K> availablePorts) {
        this.availablePorts = availablePorts;
    }

    /**
     * Sets the required ports of a Component
     *
     * @param requiredPorts   Component's required ports
     */
    public void setRequiredPorts(ArrayList<T, K> requiredPorts) {
        this.requiredPorts = requiredPorts;
    }
}
