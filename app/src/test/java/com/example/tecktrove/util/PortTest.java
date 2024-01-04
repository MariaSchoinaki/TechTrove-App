package com.example.tecktrove.util;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

import org.junit.*;

import java.util.ArrayList;
public class PortTest {

    private ArrayList<Pair<String,Integer>> available_ports;
    private Port availablePorts;

    @Before
    public void setUp(){
        Pair<String,Integer> port1 = new Pair<String,Integer>("PCIExpress", 1);

        available_ports = new ArrayList<Pair<String,Integer>>();
        available_ports.add(port1);
        availablePorts = new Port(available_ports);
    }

    @Test
    public void checkDefaultConstructor(){
        Port port = new Port();
        Assert.assertNotNull(port);
    }

    @Test
    public void  checkPortFunctionality(){
        Assert.assertNotNull(available_ports);

        Assert.assertEquals(1, availablePorts.getPorts().size());
        Pair<String,Integer> c = new Pair<String,Integer>("HDMI",4);
        availablePorts.add(c);
        Assert.assertEquals(4, availablePorts.getPortNumber("HDMI"));
        Assert.assertEquals(1, availablePorts.getPortNumber("PCIExpress"));

        Assert.assertEquals(-1, availablePorts.getPortNumber("hchc"));

        availablePorts.remove(c);
        Assert.assertEquals(-1, availablePorts.getPortNumber("HDMI"));

    }

    @Test
    public void testEquals(){
        Assert.assertEquals(availablePorts, availablePorts);
        Assert.assertNotEquals(availablePorts, null);
        Assert.assertNotEquals(availablePorts, new Port());
    }
}
