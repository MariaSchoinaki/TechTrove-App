package com.example.tecktrove.dao;

import com.example.tecktrove.contacts.Email;
import com.example.tecktrove.contacts.Telephone;
import com.example.tecktrove.domain.Customer;
import com.example.tecktrove.domain.ProductType;
import com.example.tecktrove.domain.Synthesis;

import java.util.ArrayList;

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
        Customer c1 = new Customer(5673, "george", "ok", "George", "Johnson", new Email("klap@yahoo.com"), new Telephone("6898909678"), new ArrayList<Synthesis>(), new ArrayList<ProductType>());
        getCustomerDAO().save(c1);
    }



}