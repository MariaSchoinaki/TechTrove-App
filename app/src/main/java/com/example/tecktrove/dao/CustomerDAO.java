package com.example.tecktrove.dao;

import com.example.tecktrove.domain.Customer;
import java.util.ArrayList;

public interface CustomerDAO {

    /**
     * Stores a customer if they don't exist in the dao
     *
     * @param entity    the customer object
     */
    public void save(Customer entity);

    /**
     * Get a List of all customers
     *
     * @return an ArrayList of customer objects
     */
    ArrayList<Customer> findAll();

    /**
     * Finds a customer based on the username and the password
     *
     * @param username      the username of the customer as a String
     * @param password      the password of the customer as a String
     * @return              a customer if it exists or null
     */
    public Customer findCustomerByUsernameAndPassword(String username, String password);

    /**
     * Finds a customer based on the username
     *
     * @param username the username
     * @return         a Customer object or null
     */
    public Customer findCustomerByUsername(String username);

    /**
     * Finds a customer based on the customer id
     *
     * @param       id the id of the customer
     * @return      a customer if it exists or null
     */
    public Customer findCustomerByID(int id);


    /**
     * Deletes a customer
     *
     * @param entity    the customer object
     */
    public void delete(Customer entity);

    /**
     * Delete all the customers in the dao
     */
    public void deleteAll();

    /**
     * Return the next available id that can be used for an customer
     *
     * @return the id for the customer
     */
    public int nextId();

}
