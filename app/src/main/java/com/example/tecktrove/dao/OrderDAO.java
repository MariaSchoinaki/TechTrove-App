package com.example.tecktrove.dao;

import com.example.tecktrove.domain.Order;
import com.example.tecktrove.domain.Customer;

import java.util.List;

public interface OrderDAO {

    /**
     * Stores an order object in the dao
     *
     * @param entity    the order object
     */
    void save(Order entity);

    /**
     * Returns a new ArrayList of all the orders in the dao
     *
     * @return          the ArrayList of Order objects
     */
    List<Order> findAll();

    /**
     * Finds an order by the order id.
     *
     * @param orderId   the order id
     * @return          the order object or null
     */
    Order find(int orderId);

    /**
     * Finds all the orders in the dao completed
     * by the given customer
     *
     * @param customer
     * @return the list of all the orders of the customer
     */
    List<Order> findByCustomer(Customer customer);

    /**
     * Deletes the order object from the dao
     *
     * @param entity    an order object
     */
    void delete(Order entity);

    /**
     * Deletes the order object from the dao based on the order id
     * if it exists
     *
     * @param orderId      the order id
     */
    void delete(int orderId);

    /**
     * Deletes all the orders from the dao
     */
    void deleteAll();

    /**
     * Returns the next available id that can be used for an order object
     *
     * @return  the next available number
     */
    int nextId();
}
