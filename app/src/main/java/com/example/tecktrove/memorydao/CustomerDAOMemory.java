package com.example.tecktrove.memorydao;

import com.example.tecktrove.dao.CustomerDAO;
import com.example.tecktrove.domain.Customer;
import com.example.tecktrove.domain.Employer;

import java.util.ArrayList;

public class CustomerDAOMemory implements CustomerDAO {

    protected static ArrayList<Customer> customers = new ArrayList<>();

    /**
     * Get a List of all customers
     *
     * @return      a list of customer objects
     */
    @Override
    public ArrayList<Customer> findAll() {
        return new ArrayList<>(customers);
    }

    /**
     * Get an customer based on the username and the password
     *
     * @param username      the username of the customer as a String
     * @param password      the password of the customer as a String
     * @return              an customer if it exists or null
     */
    @Override
    public Customer findCustomerByUsernameAndPassword(String username, String password){
        for (Customer customer: customers){
            if (customer.getUsername().equals(username) && customer.getPassword().equals(password)){
                return customer;
            }
        }
        return null;
    }

    /**
     *Get an customer based on the customer id
     *
     * @param       id the id of the customer
     * @return      an customer if it exists or null
     */
    @Override
    public Customer findEmployerByID(int id){
        for (Customer customer: customers){
            if (customer.getId() == id){
                return customer;
            }
        }
        return null;
    }

    /**
     * Save the customer if they don't exist in the dao
     *
     * @param entity    the customer object
     */
    @Override
    public void save(Customer entity) {
        if (!customers.contains(entity)){
            customers.add(entity);
        }
    }

    /**
     * Delete the customer if they don't exist in the dao
     *
     * @param entity    the customer object
     */
    @Override
    public void delete(Customer entity) {
        customers.remove(entity);
    }

    /**
     * Delete all the customers in the dao
     */
    @Override
    public void deleteAll(){
        customers.clear();
    }

    /**
     * Return the next available id that can be used for an customer
     *
     * @return the id for the customer
     */
    @Override
    public int nextId() {
        return (customers.size() > 0 ? customers.get(customers.size()-1).getId()+1 : 1);
    }
}
