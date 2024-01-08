package com.example.tecktrove.memorydao;

import com.example.tecktrove.dao.OrderDAO;
import com.example.tecktrove.domain.Order;
import com.example.tecktrove.domain.Customer;

import java.util.ArrayList;
import java.util.List;

public class OrderDAOMemory implements OrderDAO{

    protected static ArrayList<Order> orders = new ArrayList<Order>();


    /**
     * Saves an object order in the dao
     *
     * @param entity    the order object
     */
    @Override
    public void save(Order entity){ orders.add(entity); }

    /**
     * Returns a new ArrayList of all the orders in the dao
     *
     * @return          the ArrayList of Order objects
     */
    @Override
    public List<Order> findAll() { return new ArrayList<Order>(orders); }


    /**
     * Finds an order by the order id.
     *
     * @param orderId   the order id
     * @return          the order object or null
     */
    @Override
    public Order find(int orderId){ //maybe in an exel san eggrafh na prosdiorizetai apo to id
        for(Order order: orders){
            if(order.getId() == orderId){
                return order;
            }
        }
        return null;
    }

    /**
     * Finds all the orders in the dao completed
     * by the given customer
     *
     * @param customer
     * @return the list of all the orders of the customer
     */
    @Override
    public List<Order> findByCustomer(Customer customer){
        ArrayList<Order> customer_order = new ArrayList<>();
        for(Order order : orders){
            if(order.getCustomer().equals(customer)){
                customer_order.add(order);
            }
        }
        return customer_order;
    }

    /**
     * Deletes the order object from the dao
     *
     * @param entity    an order object
     */
    @Override
    public void delete(Order entity){ orders.remove(entity); }

    /**
     * Deletes the order object from the dao based on the order id
     * if it exists
     *
     * @param orderId      the order id
     */
    @Override
    public void delete(int orderId){ orders.remove(find(orderId)); }

    /**
     * Deletes all the orders from the dao
     */
    @Override
    public void deleteAll(){ orders.clear(); }

    /**
     * Returns the next available id that can be used for an order object
     *
     * @return  the next available number
     */
    @Override
    public int nextId(){
        return (orders.size() > 0 ? orders.get(orders.size() - 1).getId() + 1 : 1);
    }

}
