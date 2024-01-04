package com.example.tecktrove.domain;

import org.junit.Before;


import static org.junit.Assert.assertEquals;

import com.example.tecktrove.util.Money;

import java.util.Currency;
import java.math.BigDecimal;
import org.junit.*;



public class ProductTypeTest {
    private Currency euroCurrency = Currency.getInstance("EUR");
    ProductType t1,t2;
    @Before
    public void Setup(){
        t1 = new ProductType(25,new Money(new BigDecimal(2100.0),euroCurrency),"apple", 4);
        t2 = new ProductType(26,new Money(new BigDecimal(2100.1),euroCurrency),"arp", 3);
    }
    @Test
    public void checkDefaultConstructor(){
        ProductType t3 = new ProductType();
        t3.setModelNo(23);
        t3.setPrice(new Money(new BigDecimal(2100.0),euroCurrency));
        t3.setName("a");
        assertEquals(23,t3.getModelNo());
        assertEquals(new Money(new BigDecimal(2100.0),euroCurrency),t3.getPrice());
        assertEquals("a",t3.getName());
        t3.setQuantity(5);
        assertEquals(5, t3.getQuantity());
    }

    @Test
    public void checkGetSet(){
        t2.setModelNo(25);
        t2.setPrice(new Money(new BigDecimal(2100.0),euroCurrency));
        t2.setName("apple");
        assertEquals(this.t1.getModelNo(),this.t2.getModelNo());
        assertEquals(this.t1.getPrice(),this.t2.getPrice());
        assertEquals(this.t1.getName(),this.t2.getName());
    }
}
