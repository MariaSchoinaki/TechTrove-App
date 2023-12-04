package com.example.tecktrove.util;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

import org.junit.*;

import java.util.ArrayList;
public class PortTest {

    @Test
    public void checkDefaultConstructor(){
        Port port = new Port();
        Assert.assertNotNull(port);
    }

    @Test
    public void  checkPortFunctionality(){
        Pair port1 = new Pair("PCIExpress", 1);

        ArrayList<Pair> available_ports = new ArrayList<Pair>();
        available_ports.add(port1);
        Port availablePorts = new Port(available_ports);


        Assert.assertNotNull(available_ports);

        Assert.assertEquals(1, availablePorts.getPorts().size());
        Pair c = new Pair("HDMI",4);
        availablePorts.add(c);
        Assert.assertEquals(4, availablePorts.getPortNumber("HDMI"));
        Assert.assertEquals(1, availablePorts.getPortNumber("PCIExpress"));

        Assert.assertEquals(-1, availablePorts.getPortNumber("hchc"));

        availablePorts.remove(c);
        Assert.assertEquals(-1, availablePorts.getPortNumber("HDMI"));

    }
}
