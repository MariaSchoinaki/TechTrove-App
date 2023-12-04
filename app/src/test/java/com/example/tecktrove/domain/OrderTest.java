package com.example.tecktrove.domain;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;


import com.example.tecktrove.contacts.Email;
import com.example.tecktrove.contacts.Telephone;
import com.example.tecktrove.util.Money;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Currency;
import org.junit.*;


import java.util.Date;

public class OrderTest {
    private Order order1,order2;
    private Currency euroCurrency = Currency.getInstance("EUR");
    @Before
    public void setUp(){
        order1 = new Order(new Date(10),new Money(new BigDecimal(2100.0), euroCurrency),25100,new Telephone("210984367"),new Email("ok@gmail.com"),new ArrayList<OrderLine>());
        order2 = new Order(new Date(10),new Money(new BigDecimal(2100.1), euroCurrency),25101,new Telephone("110984367"),new Email("oka1@gmail.com"),new ArrayList<OrderLine>());
    }
    @Test
    public void checkDefaultConstructor(){
        Order o = new Order();
        o.setTotal(Money.euros(20));
        assertEquals(Money.euros(20), o.getTotal());
    }
    @Test
    public void checkGetSet(){
        assertEquals(this.order1.getDate(),this.order2.getDate());
        assertNotEquals(this.order1.getTotal(),this.order2.getTotal());
        assertNotEquals(this.order1.getCardNumber(),this.order2.getCardNumber());
        assertNotEquals(this.order1.getTelephone(),this.order2.getTelephone());
        assertNotEquals(this.order1.getEmail(),this.order2.getEmail());

        order1.setDate(new Date(12));
        assertNotEquals(order1.getDate(),order2.getDate());
        order2.setTotal(new Money(new BigDecimal(2100.0), euroCurrency));
        assertEquals(this.order1.getTotal(),this.order2.getTotal());
        order1.setCardNumber(25101);
        assertEquals(this.order1.getCardNumber(),this.order2.getCardNumber());
        order2.setTelephone(new Telephone("210984367"));
        assertEquals(this.order1.getTelephone(),this.order2.getTelephone());
        order2.setEmail(new Email("ok@gmail.com"));
        assertEquals(this.order1.getEmail(),this.order2.getEmail());
        ArrayList<OrderLine>l1= new ArrayList<OrderLine>();
        order1.setOrderLines(l1);
        assertEquals(order1.getOrderLines(),l1);

    }
}
