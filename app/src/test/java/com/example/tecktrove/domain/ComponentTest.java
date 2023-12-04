package com.example.tecktrove.domain;

import static org.junit.Assert.assertEquals;

import com.example.tecktrove.util.Money;
import com.example.tecktrove.util.Port;
import com.example.tecktrove.util.Pair;

import org.junit.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;

import java.math.BigDecimal;
import java.util.ArrayList;
public class ComponentTest {
    private Component component;

    @Before
    public void setUp(){;
        Pair port = new Pair ("HDMI", 2);
        Pair port2 = new Pair("PCIExpress", 1);

        ArrayList<Pair> available_ports = new ArrayList<Pair>();
        available_ports.add(port);
        Port availablePorts = new Port(available_ports);

        ArrayList<Pair> required_ports = new ArrayList<Pair>();
        required_ports.add(port2);
        Port requiredPorts = new Port(required_ports);
        availablePorts.add(port);

        component = new Component(235456,Money.euros(BigDecimal.valueOf(73.45)) , "AMD Ryzen 7", "Επεξεργαστής 8 Πυρήνων για Socket AM4 σε Κουτί", "AMD", availablePorts, requiredPorts );
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
}

