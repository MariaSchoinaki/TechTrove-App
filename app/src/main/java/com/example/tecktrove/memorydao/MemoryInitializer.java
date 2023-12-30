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


    @Override
    protected void eraseData() {

        getCustomerDAO().deleteAll();
        getEmployerDAO().deleteAll();
        getComponentDAO().deleteAll();
        getSynthesisDAO().deleteAll();
        getItemDAO().deleteAll();
        getOrderDAO().deleteAll();
        //getOrderLineDAO().de
    }

    @Override
    public CustomerDAO getCustomerDAO() {
        return DAOFactory.getFactory().getCustomerDAO();
    }

    @Override
    public EmployerDAO getEmployerDAO() {
        return DAOFactory.getFactory().getEmployerDAO();
    }

    @Override
    public ComponentDAO getComponentDAO() {
        return DAOFactory.getFactory().getComponentDAO();
    }

    @Override
    public SynthesisDAO getSynthesisDAO() {
        return DAOFactory.getFactory().getSynthesisDAO();
    }

    @Override
    public OrderDAO getOrderDAO() {
        return DAOFactory.getFactory().getOrderDAO();
    }

    @Override
    public ItemDAO getItemDAO() {
        return DAOFactory.getFactory().getItemDAO();
    }
}
