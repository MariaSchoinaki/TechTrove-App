package com.example.tecktrove.domain;

import com.example.tecktrove.util.Money;
import com.example.tecktrove.util.Port;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

import java.math.BigDecimal;

public class OrderLineTest {

    OrderLine orderl1;
    OrderLine orderl2;
    OrderLine orderl3;

    @Before
    public void setUp(){
        orderl1 = new OrderLine(2,new Component(235456, Money.euros(BigDecimal.valueOf(30.5)) , "AMD Ryzen 7", "Επεξεργαστής 8 Πυρήνων για Socket AM4 σε Κουτί", "AMD", new Port(), new Port() ));
        orderl2 = new OrderLine(5,new Component(12345, Money.euros(BigDecimal.valueOf(20)) , "Ryzen 7 5800 X", "Επεξεργαστής", "AMD", new Port(), new Port() ));
        orderl3 = new OrderLine(1,new Synthesis(235456, Money.euros(1500) , false, 0, 0, 0));
    }

    @Test
    public void checkGetSet(){
        Assert.assertEquals("61 €", orderl1.getSubTotal().toString());
        Assert.assertEquals(100, orderl2.getSubTotal());
        Assert.assertEquals(1500, orderl3.getSubTotal());

        Assert.assertEquals(235456, orderl1.getProductType().getModelNo());

        Assert.assertEquals(2, orderl1.getQuantity());
        Assert.assertEquals(5, orderl2.getQuantity());
        Assert.assertEquals(1, orderl3.getQuantity());

        Assert.assertNotEquals(orderl1, orderl2);
    }

    @Test
    public void CalculateSubTotal(){
        orderl1.setQuantity(5);
        Assert.assertEquals("152.5 €", orderl1.getSubTotal().toString());
    }
}
