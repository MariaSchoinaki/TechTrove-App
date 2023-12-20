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

    @Override
    public CustomerDAO getCustomerDAO() {
        return customerDAOMemory;
    }

    @Override
    public EmployerDAO getEmployerDAO() {
        return null;
    }

    @Override
    public ComponentDAO getComponentDAO() {
        return null;
    }

    @Override
    public SynthesisDAO getSynthesisDAO() {
        return null;
    }

    @Override
    public OrderDAO getOrderDAO() {
        return null;
    }

    @Override
    public OrderLineDAO getOrderLineDAO() {
        return null;
    }

    @Override
    public ItemDAO getItemDAO() {
        return null;
    }
}
