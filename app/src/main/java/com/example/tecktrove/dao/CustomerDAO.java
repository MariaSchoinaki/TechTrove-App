package com.example.tecktrove.dao;

import com.example.tecktrove.domain.Customer;
import java.util.ArrayList;

public interface CustomerDAO {

    /**
     * Get a List of all customers
     *
     * @return      a list of customer objects
     */
    ArrayList<Customer> findAll();

    /**
     * Get an customer based on the username and the password
     *
     * @param username      the username of the customer as a String
     * @param password      the password of the customer as a String
     * @return              an customer if it exists or null
     */
    public Customer findCustomerByUsernameAndPassword(String username, String password);

    /**
     *Get an customer based on the customer id
     *
     * @param       id the id of the customer
     * @return      an customer if it exists or null
     */
    public Customer findEmployerByID(int id);

    /**
     * Save the customer if they don't exist in the dao
     *
     * @param entity    the customer object
     */
    public void save(Customer entity);

    /**
     * Delete the customer if they don't exist in the dao
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
