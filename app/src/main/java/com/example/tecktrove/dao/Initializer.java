package com.example.tecktrove.dao;

public abstract class Initializer {

    /**
     * Erases all the data from the database
     */
    protected abstract void eraseData();

    public abstract CustomerDAO getCustomerDAO();

    public abstract EmployerDAO getEmployerDAO();

    public abstract ComponentDAO getComponentDAO();


    public abstract SynthesisDAO getSynthesisDAO();

    public abstract OrderDAO getOrderDAO();

    public abstract OrderLineDAO getOrderLineDAO();

    public abstract ItemDAO getItemDAO();

    public void prepareData(){
        eraseData();
    }



}