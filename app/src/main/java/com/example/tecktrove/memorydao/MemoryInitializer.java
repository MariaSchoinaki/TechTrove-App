package com.example.tecktrove.memorydao;

import com.example.tecktrove.dao.ComponentDAO;
import com.example.tecktrove.dao.CustomerDAO;
import com.example.tecktrove.dao.DAOFactory;
import com.example.tecktrove.dao.EmployerDAO;
import com.example.tecktrove.dao.Initializer;
import com.example.tecktrove.dao.ItemDAO;
import com.example.tecktrove.dao.OrderDAO;
import com.example.tecktrove.dao.SynthesisDAO;

public class MemoryInitializer extends Initializer {

    public MemoryInitializer() {
        System.setProperty("daofactory", "com.example.tecktrove.memorydao.MemoryDAOFactory");
    }

    /**
     * Erases all the data from the database
     */
    @Override
    protected void eraseData() {

        getCustomerDAO().deleteAll();
        getEmployerDAO().deleteAll();
        getComponentDAO().deleteAll();
        getSynthesisDAO().deleteAll();
        getItemDAO().deleteAll();
        getOrderDAO().deleteAll();
    }

    /**
     * Returns the object for the interface {@link CustomerDAO}
     *
     * @return  the static customer DAO
     */
    @Override
    public CustomerDAO getCustomerDAO() {
        return DAOFactory.getFactory().getCustomerDAO();
    }

    /**
     * Returns the object for the interface {@link EmployerDAO}
     *
     * @return  the static employer DAO
     */
    @Override
    public EmployerDAO getEmployerDAO() {
        return DAOFactory.getFactory().getEmployerDAO();
    }

    /**
     * Returns the object for the interface {@link ComponentDAO}
     *
     * @return  the static component DAO
     */
    @Override
    public ComponentDAO getComponentDAO() {
        return DAOFactory.getFactory().getComponentDAO();
    }

    /**
     * Returns the object for the interface {@link SynthesisDAO}
     *
     * @return  the static synthesis DAO
     */
    @Override
    public SynthesisDAO getSynthesisDAO() {
        return DAOFactory.getFactory().getSynthesisDAO();
    }

    /**
     * Returns the object for the interface {@link OrderDAO}
     *
     * @return  the static order DAO
     */
    @Override
    public OrderDAO getOrderDAO() {
        return DAOFactory.getFactory().getOrderDAO();
    }

    /**
     * Returns the object for the interface {@link ItemDAO}
     *
     * @return  the static item DAO
     */
    @Override
    public ItemDAO getItemDAO() {
        return DAOFactory.getFactory().getItemDAO();
    }
}
