package com.example.tecktrove.memorydao;

import com.example.tecktrove.dao.ComponentDAO;
import com.example.tecktrove.dao.CustomerDAO;
import com.example.tecktrove.dao.DAOFactory;
import com.example.tecktrove.dao.EmployerDAO;
import com.example.tecktrove.dao.ItemDAO;
import com.example.tecktrove.dao.OrderDAO;
import com.example.tecktrove.dao.OrderLineDAO;
import com.example.tecktrove.dao.SynthesisDAO;

public class MemoryDAOFactory extends DAOFactory {

    private CustomerDAOMemory customerDAOMemory = new CustomerDAOMemory();
    private EmployerDAOMemory employerDAOMemory = new EmployerDAOMemory();
    private ComponentDAOMemory componentDAOMemory = new ComponentDAOMemory();
    private SynthesisDAOMemory synthesisDAOMemory = new SynthesisDAOMemory();
    private OrderDAOMemory orderDAOMemory =new OrderDAOMemory();
    //private OrderLineDAO orderLineDAO = new OrderDAOMemory();
    private ItemDAOMemory itemDAOMemory = new ItemDAOMemory();

    @Override
    public CustomerDAO getCustomerDAO() {
        return customerDAOMemory;
    }

    @Override
    public EmployerDAO getEmployerDAO() {
        return employerDAOMemory;
    }

    @Override
    public ComponentDAO getComponentDAO() {
        return componentDAOMemory;
    }

    @Override
    public SynthesisDAO getSynthesisDAO() {
        return synthesisDAOMemory;
    }

    @Override
    public OrderDAO getOrderDAO() {
        return orderDAOMemory;
    }

    @Override
    public OrderLineDAO getOrderLineDAO() {
        return null;
    }

    @Override
    public ItemDAO getItemDAO() {
        return itemDAOMemory;
    }
}
