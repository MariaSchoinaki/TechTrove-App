package com.example.tecktrove.dao;


import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNull;

import com.example.tecktrove.domain.Component;
import com.example.tecktrove.domain.Synthesis;
import com.example.tecktrove.memorydao.ComponentDAOMemory;
import com.example.tecktrove.memorydao.CustomerDAOMemory;
import com.example.tecktrove.memorydao.EmployerDAOMemory;
import com.example.tecktrove.memorydao.ItemDAOMemory;
import com.example.tecktrove.memorydao.MemoryInitializer;
import com.example.tecktrove.memorydao.OrderDAOMemory;
import com.example.tecktrove.memorydao.SynthesisDAOMemory;
import com.example.tecktrove.util.Money;
import com.example.tecktrove.util.Pair;
import com.example.tecktrove.util.Port;
import com.example.tecktrove.dao.Initializer;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Currency;

public class DAOTest {

    private ComponentDAO componentDAO;
    private SynthesisDAO synthesisDAO;
    private ItemDAO itemDAO;
    private EmployerDAO employerDAO;
    private OrderDAO orderDAO;
    private OrderLineDAO orderLineDAO;
    private CustomerDAO customerDAO;

    private static final int INITIAL_COMPONENTS_COUNT = 0;
    private static final int INITIAL_AVAILABLE_COUNT = 0;

    private static final int INITIAL_REQUIRED_COUNT = 0;
    private static final int INITIAL_SYNTHESIS_COUNT = 0;

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
    public void findNonExistingModelNo(){
        Assert.assertNull(componentDAO.find(123456));
        Assert.assertNull(synthesisDAO.find(342156));
    }
    @Test
    public void findNonExistingName(){
        Assert.assertNull(componentDAO.find("somalia"));
        Assert.assertNull(synthesisDAO.find("izola"));
    }
    @Test
    public void findNonExistingManufacturer(){
        Assert.assertEquals(new ArrayList<Component>(),componentDAO.findByManufacturer("Lola"));
    }
    @Test
    public void findNonExistingRequiredPorts(){
        Port p = new Port();
        Assert.assertEquals(new ArrayList<Component>(),componentDAO.findAllByRequiredPorts(p));
    }

    @Test
    public void findNonExistingAvailablePorts(){
        Port p = new Port();
        Assert.assertEquals(new ArrayList<Component>(),componentDAO.findAllByAvailablePorts(p));
    }
    @Test
    public void listAllComponents(){
        ArrayList<Component> allComponents = componentDAO.findAll();
        Assert.assertEquals(INITIAL_COMPONENTS_COUNT,allComponents.size());
    }

    @Test
    public void testSaveComponents(){
        Component component = new Component(12,new Money(BigDecimal.valueOf(123), Currency.getInstance("EUR")),"display","very good","SAMSUNG ELECTRONICS CO&LTD",new Port(),new Port(),13);
        componentDAO.save(component);
        Assert.assertEquals(INITIAL_COMPONENTS_COUNT+1,componentDAO.findAll().size());
        Assert.assertNotNull(componentDAO.find(12));
        Assert.assertNotNull(componentDAO.find("display"));
        Assert.assertTrue(componentDAO.findAll().contains(component));
    }

    @Test
    public void findNonExistingRating(){
        Assert.assertEquals(new ArrayList<Synthesis>(),synthesisDAO.findAllByRating(12.2));
    }

    @Test
    public void findNonExistingNumberOfRatings(){
        Assert.assertEquals(new ArrayList<Synthesis>(),synthesisDAO.findAllByNumberOfRatings(5));
    }

    @Test
    public void testSaveSynthesis(){
        Synthesis s1 = new Synthesis(235456, Money.euros(1500), "Best Synthesis", new ArrayList<Component>());
        synthesisDAO.save(s1);
        Assert.assertEquals(INITIAL_SYNTHESIS_COUNT+1,synthesisDAO.findAll().size());
        Assert.assertNotNull(synthesisDAO.find(235456));
        Assert.assertNotNull(synthesisDAO.find("Best Synthesis"));
        Assert.assertTrue(synthesisDAO.findAll().contains(s1));
    }
    @Test
    public void testAvailablePorts(){

        Pair p = new Pair("HDMI",1);
        Port port = new Port();
        port.add(p);

        ArrayList<Component> components = componentDAO.findAllByAvailablePorts(port);
        Assert.assertEquals(INITIAL_AVAILABLE_COUNT,components.size());
    }


    @Test
    public void testRequiredPorts(){

        Pair p = new Pair("HDMI",1);
        Port port = new Port();
        port.add(p);

        ArrayList<Component> components = componentDAO.findAllByRequiredPorts(port);
        Assert.assertEquals(INITIAL_REQUIRED_COUNT,components.size());

    }

    @Test
    public void testDeleteByRequiredPorts(){
        Pair p = new Pair("HDMI",1);
        Port port = new Port();
        port.add(p);

        componentDAO.deleteByRequiredPorts(port);
        Assert.assertEquals(0,componentDAO.findAllByRequiredPorts(port).size());

    }

    @Test
    public void testDeleteByAvailablePorts(){
        Pair p = new Pair("HDMI",1);
        Port port = new Port();
        port.add(p);

        componentDAO.deleteByAvailablePorts(port);
        Assert.assertEquals(0,componentDAO.findAllByAvailablePorts(port).size());
    }

    @Test
    public void testDeleteByManufacturer(){
        componentDAO.deleteByManufacturer("Sharkoon");
        Assert.assertEquals(0,componentDAO.findByManufacturer("Sharkoon").size());

    }

    @Test
    public void ComponentDelete(){
        componentDAO.delete(new Component());
        componentDAO.delete("Turbo-X PSU Value III Series 550 W");
        componentDAO.delete(4191);
    }

    @Test
    public void SynthesisDelete(){
            synthesisDAO.delete(new Synthesis());
            synthesisDAO.delete("Synthesis1");
            synthesisDAO.delete(9485);
    }




}
