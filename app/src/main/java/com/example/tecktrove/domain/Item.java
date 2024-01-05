package com.example.tecktrove.domain;


public class Item {
    private int serialNo;

    /**
     * Default Constructor
     */
    public Item(){}

    /**
     * Constructor of Item
     * @param serialNo     the serial number as an Integer
     */
    public Item(int serialNo){
        this.serialNo = serialNo;
    }

    /**
     * Gets the serial number of an Item
     *
     * @return  the serial number
     */
    public int getSerialNo() {
        return serialNo;
    }

    /**
     * Sets the serial number of an Item
     *
     * @param serialNo   Item's serial number
     */
    public void setSerialNo(int serialNo) {
        this.serialNo = serialNo;
    }
}
