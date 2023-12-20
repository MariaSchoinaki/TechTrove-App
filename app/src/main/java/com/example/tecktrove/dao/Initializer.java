package com.example.tecktrove.dao;

import com.example.tecktrove.contacts.Email;
import com.example.tecktrove.contacts.Telephone;
import com.example.tecktrove.domain.Customer;
import com.example.tecktrove.domain.Employer;
import com.example.tecktrove.domain.ProductType;
import com.example.tecktrove.domain.Synthesis;
import com.example.tecktrove.domain.Component;
import com.example.tecktrove.util.Port;
import com.example.tecktrove.util.Money;

import java.math.BigDecimal;
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
        //Customers
        Customer c1 = new Customer(5673, "george", "ok123456", "George", "Johnson", new Email("klap@yahoo.com"), new Telephone("6898909678"), new ArrayList<Synthesis>(), new ArrayList<ProductType>());
        getCustomerDAO().save(c1);

        Customer c2 = new Customer(7859, "maria5", "31m@ria5", "Maria", "Papadaki", new Email("papadaki27@gmail.com"), new Telephone("6984596936"), new ArrayList<Synthesis>(), new ArrayList<ProductType>());
        getCustomerDAO().save(c2);

        Customer c3 = new Customer(2598, "chris", "chr!s598", "Christos", "Papaioanou", new Email("papaio54@gmail.com"), new Telephone("6985369825"), new ArrayList<Synthesis>(), new ArrayList<ProductType>());
        getCustomerDAO().save(c3);

        //Employers
        Employer em1 = new Employer(1252, "eleni3", "elen!562", "Eleni", "Georgali", new Email("eleniii2@gmail.com"), new Telephone("6988745961"));
        getEmployerDAO().save(em1);

        Employer em2 = new Employer(5698, "faihh1", "faihskoni1", "Foteini", "Soultatou", new Email("apple3r@yahoo.com"), new Telephone("6978451236"));
        getEmployerDAO().save(em2);

        Employer em3 = new Employer(8596, "kostas34", "13k023m32", "Konstantinos", "Glitsas", new Email("glitsas13@gmail.com"), new Telephone("6945259875"));
        getEmployerDAO().save(em3);

        //Components
        Component com2 = new Component(4310, Money.euros(BigDecimal.valueOf(38.75)),);
        getComponentDAO().save(com2);

        Component com1 = new Component(4590, Money.euros(BigDecimal.valueOf(38.75)), "CPU Intel I5", "Intel Core Qc I5-4590, 3.3ghz, 6mb, 5gt, 84w Lga1150", "Intel", new Port(), new Port(), 150);
        getComponentDAO().save(com1);

    }
}