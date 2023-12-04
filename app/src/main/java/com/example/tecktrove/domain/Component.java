package com.example.tecktrove.domain;

import com.example.tecktrove.util.Money;
import com.example.tecktrove.util.Port;

import java.util.ArrayList;

public class Component extends ProductType{
    private String description;
    private String manufacturer;
    private Port availablePorts;
    private Port requiredPorts;
    private int quantity;

    public Component(){this.quantity = 0;}

    /**
     * Constructor of Component
     * @param name            the name of the component as a String
     * @param description     the description of the component as a String
     * @param manufacturer    the manufacturer of the component as a String
     * @param availablePorts  the available ports of the component as an ArrayList
     * @param requiredPorts   the required ports of the component as an ArrayList
     * @param modelNo         the model number of the Component as an Integer
     * @param price           the price of the Component as Money
     * @param quantity        the quantity of the Component as Integer
     */
    public Component(int modelNo, Money price, String name, String description, String manufacturer, Port availablePorts, Port requiredPorts, int quantity){
        super(modelNo, price,name);
        this.description = description;
        this.manufacturer = manufacturer;
        this.availablePorts = availablePorts;
        this.requiredPorts = requiredPorts;
        this.quantity = quantity;
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
    public Port getAvailablePorts() {
        return availablePorts;
    }

    /**
     * Gets the required ports of the component
     *
     * @return  the required ports
     */
    public Port getRequiredPorts() {
        return requiredPorts;
    }

    public int getQuantity(){
        return this.quantity;
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
    public void setAvailablePorts(Port availablePorts) {
        this.availablePorts = availablePorts;
    }

    /**
     * Sets the required ports of a Component
     *
     * @param requiredPorts   Component's required ports
     */
    public void setRequiredPorts(Port requiredPorts) {
        this.requiredPorts = requiredPorts;
    }

    public void addQuantity(int quantity) {
        this.quantity += quantity;
    }

    public void removeQuantity(int quantity) {
        if(this.quantity <= quantity){
            this.quantity = 0;
        }else{
            this.quantity -= quantity;
        }
    }
}
