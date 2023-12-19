package com.example.tecktrove.dao;

import com.example.tecktrove.domain.Order;
import com.example.tecktrove.domain.Customer;

import java.util.List;

public interface OrderDAO {
    /**
     * Gets the order for some input number.
     *
     * @param orderId   the input number
     * @return          the order
     */
    Order find(int orderId); //maybe in an exel san eggrafh na prosdiorizetai apo to id

    /**
     * Gets a list of all the orders in the dao
     *
     * @return          the list of all the orders
     */
    List<Order> findAll();

    /**
     * Gets a list of all the orders in the dao of the input customer
     *
     * @return          the list of all the orders of the customer
     */
    List<Order> findByCustomer(Customer customer);

    /**
     * Saves an object order in the dao
     *
     * @param entity    the order object
     */
    void save(Order entity);

    /**
     * Deletes the order object from the dao
     *
     * @param entity    an order object
     */
    void delete(Order entity);

    /**
     * Deletes the order object from the dao if it exists based on the id of the order
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
