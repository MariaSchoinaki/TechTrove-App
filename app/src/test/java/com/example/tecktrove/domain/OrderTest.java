package com.example.tecktrove.domain;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;


import java.time.LocalDate;
import com.example.tecktrove.contacts.Email;
import com.example.tecktrove.contacts.Telephone;
import com.example.tecktrove.util.Money;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Currency;
import org.junit.*;


import com.example.tecktrove.util.Pair;
import com.example.tecktrove.util.SimpleCalendar;
import com.example.tecktrove.util.SystemDate;


public class OrderTest  {
    private Order order1,order2;
    private Currency euroCurrency = Currency.getInstance("EUR");
    @Before
    public void setUp(){
        ArrayList<OrderLine> R1 = new ArrayList<OrderLine>();
        R1.add(new OrderLine(2,new ProductType(123,new Money(new BigDecimal(2100.0), euroCurrency),"chris", 8)));
        ArrayList<OrderLine> R2 = new ArrayList<OrderLine>();
        order1 = new Order(new SimpleCalendar(2023,11,26),2510000000000000L,new Telephone("2109843678"),new Email("ok@gmail.com"),R1);
        order2 = new Order(new SimpleCalendar(2023,6,25),2510100000000000L,new Telephone("1109843674"),new Email("oka1@gmail.com"),R2);

    }
    @Test
    public void checkDefaultConstructor(){
        Order o = new Order();
        o.setEmail(new Email("ok@gmail.com"));
        Assert.assertEquals("ok@gmail.com", o.getEmail().getEmail());
        o.setId(5);
        Assert.assertEquals(5, o.getId());
    }
    @Test
    public void checkGetSet() {
        assertNotEquals(this.order1.getDate(), this.order2.getDate());
        assertNotEquals(this.order1.getTotal(), this.order2.getTotal());
        assertNotEquals(this.order1.getCardNumber(), this.order2.getCardNumber());
        assertNotEquals(this.order1.getTelephone(), this.order2.getTelephone());
        assertNotEquals(this.order1.getEmail(), this.order2.getEmail());
        assertNotEquals(this.order1.getOrderLines(), this.order2.getOrderLines());

        SimpleCalendar s = new SimpleCalendar(2023,8,25);
        order1.setDate(s);
        Assert.assertEquals(s, order1.getDate());
        order1.setCardNumber(2510200000000000L);
        assertEquals(2510200000000000L, this.order1.getCardNumber());
        order2.setTelephone(new Telephone("2109843673"));
        assertEquals(new Telephone("2109843673"), this.order2.getTelephone());
        order2.setEmail(new Email("ok@gmail.com"));
        assertEquals(new Email("ok@gmail.com"), this.order2.getEmail());
        ArrayList<OrderLine> l1 = new ArrayList<OrderLine>();
        order1.setOrderLines(l1);
        order2.setOrderLines(l1);
        assertEquals(l1, this.order2.getOrderLines());
        assertEquals(l1,this.order1.getOrderLines());
        order1.setCustomer(new Customer(18,  "lola", "12345678", "lo", "la", new Email("ok@gmail.com"), new Telephone("1234567891"), new ArrayList<Synthesis>(), new ArrayList<OrderLine>()));
        assertEquals(new Customer(18,  "lola", "12345678", "lo", "la", new Email("ok@gmail.com"), new Telephone("1234567891"), new ArrayList<Synthesis>(), new ArrayList<OrderLine>()),this.order1.getCustomer());

    }
    @Test
    public void testAddRemove(){
        OrderLine R3 = new OrderLine(2,new ProductType(125,new Money(new BigDecimal(2100.1), euroCurrency),"chris", 2));
        order1.addOrderLine(R3);
        assertTrue(order1.getOrderLines().remove(R3));
        order2.addOrderLine(R3);
        order2.removeOrderline(R3);
        Boolean notfound = Boolean.TRUE;
        for(OrderLine r: order2.getOrderLines()){
            if(r==R3){
                notfound=Boolean.FALSE;
            }
        }
        assertTrue(notfound);
    }
}
