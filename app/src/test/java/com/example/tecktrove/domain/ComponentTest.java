package com.example.tecktrove.domain;

import static org.junit.Assert.assertEquals;

import com.example.tecktrove.util.Money;
import com.example.tecktrove.util.Port;
import com.example.tecktrove.util.Pair;

import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;

import java.math.BigDecimal;
import java.util.ArrayList;
public class ComponentTest {
    private Component component;
    private ArrayList<Pair> available_ports,required_ports;
    private Port availablePorts, requiredPorts;

    @Before
    public void setUp(){;
        Pair port = new Pair ("HDMI", 2);
        Pair port2 = new Pair("PCIExpress", 1);

        available_ports = new ArrayList<Pair>();
        available_ports.add(port);
        availablePorts = new Port(available_ports);

        required_ports = new ArrayList<Pair>();
        required_ports.add(port2);
        requiredPorts = new Port(required_ports);
        availablePorts.add(port);

        component = new Component(235456,Money.euros(BigDecimal.valueOf(73.45)) , "AMD Ryzen 7", "Επεξεργαστής 8 Πυρήνων για Socket AM4 σε Κουτί", "AMD", availablePorts, requiredPorts ,10);
    }



    @Test
    public void getName(){
     assertEquals(component.getName(),"AMD Ryzen 7");
    }
    @Test
    public void getDescription() {
        assertEquals(component.getDescription(),"Επεξεργαστής 8 Πυρήνων για Socket AM4 σε Κουτί");
    }

    @Test
    public void getManufacturer() {
        assertEquals(component.getManufacturer(), "AMD");
    }

    @Test
    public void getModelNo(){
        assertEquals(component.getModelNo(), 235456);
    }

    @Test
    public void getPrice(){
        assertEquals(component.getPrice(), Money.euros(BigDecimal.valueOf(73.45)));
    }

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

