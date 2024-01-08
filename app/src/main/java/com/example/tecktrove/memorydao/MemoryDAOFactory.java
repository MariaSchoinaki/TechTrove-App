package com.example.tecktrove.memorydao;

import com.example.tecktrove.dao.ComponentDAO;
import com.example.tecktrove.dao.CustomerDAO;
import com.example.tecktrove.dao.DAOFactory;
import com.example.tecktrove.dao.EmployerDAO;
import com.example.tecktrove.dao.OrderDAO;
import com.example.tecktrove.dao.SynthesisDAO;

public class MemoryDAOFactory extends DAOFactory {

    private CustomerDAOMemory customerDAOMemory = new CustomerDAOMemory();
    private EmployerDAOMemory employerDAOMemory = new EmployerDAOMemory();
    private ComponentDAOMemory componentDAOMemory = new ComponentDAOMemory();
    private SynthesisDAOMemory synthesisDAOMemory = new SynthesisDAOMemory();
    private OrderDAOMemory orderDAOMemory =new OrderDAOMemory();

    /**
     * Returns the object for the interface {@link CustomerDAO}
     *
     * @return  the DAO object
     */
    @Override
    public CustomerDAO getCustomerDAO() {
        return customerDAOMemory;
    }

    /**
     * Returns the object for the interface {@link EmployerDAO}
     *
     * @return  the DAO object
     */
    @Override
    public EmployerDAO getEmployerDAO() {
        return employerDAOMemory;
    }

    /**
     * Returns the object for the interface {@link ComponentDAO}
     *
     * @return  the DAO object
     */
    @Override
    public ComponentDAO getComponentDAO() {
        return componentDAOMemory;
    }

    /**
     * Returns the object for the interface {@link SynthesisDAO}
     *
     * @return  the DAO object
     */
    @Override
    public SynthesisDAO getSynthesisDAO() {
        return synthesisDAOMemory;
    }

    /**
     * Returns the object for the interface {@link OrderDAO}
     *
     * @return  the DAO object
     */
    @Override
    public OrderDAO getOrderDAO() {
        return orderDAOMemory;
    }
}
