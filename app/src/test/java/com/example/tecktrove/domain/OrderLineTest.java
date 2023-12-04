package com.example.tecktrove.domain;

import com.example.tecktrove.util.Money;
import com.example.tecktrove.util.Port;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.ArrayList;

public class OrderLineTest {

    OrderLine orderl1;
    OrderLine orderl2;
    OrderLine orderl3;
    OrderLine orderl4;
    OrderLine orderl5;

    @Before
    public void setUp(){
        orderl1 = new OrderLine(2,new Component(235456, Money.euros(BigDecimal.valueOf(30.5)) , "AMD Ryzen 7", "Επεξεργαστής 8 Πυρήνων για Socket AM4 σε Κουτί", "AMD", new Port(), new Port(), 10 ));
        orderl2 = new OrderLine(5,new Component(12345, Money.euros(BigDecimal.valueOf(20)) , "Ryzen 7 5800 X", "Επεξεργαστής", "AMD", new Port(), new Port() ,5));
        orderl3 = new OrderLine(1,new Synthesis(235456, Money.euros(1500),"lola" , new ArrayList<Component>()));
        orderl4 = new OrderLine(2,new Synthesis(235456, Money.euros(1500), "abcd ",new ArrayList<Component>()));
    }

    @Test
    public void checkDefaultConstructor(){
        orderl5 = new OrderLine();
        Assert.assertEquals(0, orderl5.getQuantity());
        Assert.assertEquals(orderl5.getSubTotal(), null);
        Assert.assertEquals(orderl5.getProductType(), null);

        orderl5.setProductType(new Synthesis(235456, Money.euros(1500), "Best Synthesis" ,  new ArrayList<Component>()));
        orderl5.setQuantity(3);
        Assert.assertEquals("4500 €", orderl5.getSubTotal().toString());
        Assert.assertEquals(3, orderl5.getQuantity());
    }
    @Test
    public void checkGetSet(){
        Assert.assertEquals("61.0 €", orderl1.getSubTotal().toString());
        Assert.assertEquals("100 €", orderl2.getSubTotal().toString());
        Assert.assertEquals("1500 €", orderl3.getSubTotal().toString());

        Assert.assertEquals(235456, orderl1.getProductType().getModelNo());

        Assert.assertEquals(2, orderl1.getQuantity());
        Assert.assertEquals(5, orderl2.getQuantity());
        Assert.assertEquals(1, orderl3.getQuantity());
    }

    @Test
    public void CalculateSubTotal(){
        orderl1.setQuantity(5);
        Assert.assertEquals("152.5 €", orderl1.getSubTotal().toString());
    }

    @Test
    public void checkEquality(){
        Assert.assertFalse(orderl1.equals(orderl2));
        Assert.assertTrue(orderl1.equals(orderl1));
        Assert.assertFalse(orderl1.equals(null));
        assertEquals(orderl4,orderl3);
        Assert.assertFalse(orderl3.equals(new Object()));
    }
}
