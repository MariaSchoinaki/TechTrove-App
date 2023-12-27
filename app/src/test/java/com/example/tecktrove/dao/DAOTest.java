package com.example.tecktrove.dao;

import com.example.tecktrove.memorydao.ComponentDAOMemory;
import com.example.tecktrove.memorydao.CustomerDAOMemory;
import com.example.tecktrove.memorydao.EmployerDAOMemory;
import com.example.tecktrove.memorydao.ItemDAOMemory;
import com.example.tecktrove.memorydao.MemoryInitializer;
import com.example.tecktrove.memorydao.OrderDAOMemory;
import com.example.tecktrove.memorydao.SynthesisDAOMemory;
import org.junit.*;
import com.example.tecktrove.memorydao.*;
import com.example.tecktrove.util.Port;

import org.junit.Before;
import org.junit.Test;

public class DAOTest {

    private ComponentDAO componentDAO;
    private SynthesisDAO synthesisDAO;
    private ItemDAO itemDAO;
    private EmployerDAO employerDAO;
    private OrderDAO orderDAO;
    private OrderLineDAO orderLineDAO;
    private CustomerDAO customerDAO;

    private static final int INITIAL_COMPONENTS_COUNT = 3;

    @Before
    public void setUp() {
        Initializer dataDriver = new MemoryInitializer();
        dataDriver.prepareData();

        componentDAO = new ComponentDAOMemory();
        synthesisDAO = new SynthesisDAOMemory();
        itemDAO = new ItemDAOMemory();
        employerDAO = new EmployerDAOMemory();
        orderDAO = new OrderDAOMemory();
        orderLineDAO = new OrderLineDAO();
        customerDAO = new CustomerDAOMemory();
    }
    @Test
    void findNonExistingManufacturer(){
        Assert.assertNull(componentDAO.findByManufacturer("Lola"));
    }
    @Test
    void findNonExistingRequiredPorts(){
        Port p = new Port();
        Assert.assertNull(componentDAO.findAllByRequiredPorts(p));
    }

    @Test
    void findNonExistingAvailablePorts(){
        Port p = new Port();
        Assert.assertNull(componentDAO.findAllByAvailablePorts(p));
    }
    @Test
    void listAllComponents(){
        Assert.assertEquals(INITIAL_COMPONENTS_COUNT,componentDAO.findAll().size());

    }


}
