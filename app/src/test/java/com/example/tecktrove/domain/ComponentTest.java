package com.example.tecktrove.domain;

import static org.junit.Assert.assertEquals;

import com.example.tecktrove.util.Money;
import com.example.tecktrove.util.Port;
import com.example.tecktrove.util.Pair;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;

import java.math.BigDecimal;
import java.util.ArrayList;
public class ComponentTest {
    private Component component;
    private ArrayList<Pair<String, Integer>> available_ports,required_ports;
    private Port availablePorts, requiredPorts;

    /**
     * Sets up the data used
     */
    @Before
    public void setUp(){;
        Pair<String, Integer> port = new Pair<String, Integer> ("HDMI", 2);
        Pair<String, Integer> port2 = new Pair<String, Integer>("PCIExpress", 1);

        available_ports = new ArrayList<Pair<String, Integer>>();
        available_ports.add(port);
        availablePorts = new Port(available_ports);

        required_ports = new ArrayList<Pair<String, Integer>>();
        required_ports.add(port2);
        requiredPorts = new Port(required_ports);
        availablePorts.add(port);

        component = new Component(235456,Money.euros(BigDecimal.valueOf(73.45)) , "AMD Ryzen 7", "Επεξεργαστής 8 Πυρήνων για Socket AM4 σε Κουτί", "AMD", availablePorts, requiredPorts ,10);
    }


    /**
     * Tests the name of the component
     */
    @Test
    public void getName(){
     assertEquals(component.getName(),"AMD Ryzen 7");
    }

    /**
     * Tests the description of the component
     */
    @Test
    public void getDescription() {
        assertEquals(component.getDescription(),"Επεξεργαστής 8 Πυρήνων για Socket AM4 σε Κουτί");
    }

    /**
     * Tests the manufacturer of the component
     */
    @Test
    public void getManufacturer() {
        assertEquals(component.getManufacturer(), "AMD");
    }

    /**
     * Tests the model number of the component
     */
    @Test
    public void getModelNo(){
        assertEquals(component.getModelNo(), 235456);
    }

    /**
     * Tests the price of the component
     */
    @Test
    public void getPrice(){
        assertEquals(component.getPrice(), Money.euros(BigDecimal.valueOf(73.45)));
    }

    /**
     * Tests default constructor, setters and getters
     */
    @Test
    public void checkDefaultConstructor(){
        Component c = new Component();
        c.setAvailablePorts(availablePorts);
        c.setRequiredPorts(requiredPorts);

        Assert.assertEquals(availablePorts, c.getAvailablePorts());
        Assert.assertEquals(requiredPorts, c.getRequiredPorts());

        c.setManufacturer("abc");
        Assert.assertEquals("abc", c.getManufacturer());

        c.setDescription("hello");
        Assert.assertEquals("hello", c.getDescription());
    }

    /**
     * Tests quantity of the component
     */
    @Test
    public void checkQuantity(){
        Assert.assertEquals(10, component.getQuantity());

        component.addQuantity(5);
        Assert.assertEquals(15,component.getQuantity());

        component.removeQuantity(10);
        Assert.assertEquals(5,component.getQuantity());

        component.removeQuantity(10);
        Assert.assertEquals(0, component.getQuantity());
    }
}

