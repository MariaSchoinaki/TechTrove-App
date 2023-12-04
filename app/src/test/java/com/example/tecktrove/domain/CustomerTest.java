package com.example.tecktrove.domain;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;


import com.example.tecktrove.contacts.Email;
import com.example.tecktrove.contacts.Telephone;
import com.example.tecktrove.util.Money;

import org.junit.*;

import java.util.ArrayList;

public class CustomerTest {
    private Customer customer1, customer2;
   @Before
    public void setup() {
       customer1 = new Customer(18, 18, "lola", "1234", "lo", "la", new Email("ok@gmail.com"), new Telephone("12345"), new ArrayList<Synthesis>(), new ArrayList<ProductType>());
       customer2 = new Customer(18, 18, "lola", "1234", "lo", "la", new Email("ok@gmail.com"), new Telephone("12345"), new ArrayList<Synthesis>(), new ArrayList<ProductType>());
   }
   @Test
   public void checkDefaultConstructor(){
      Customer o = new Customer();
      o.setCustomerID(20);
      assertEquals(o.getCustomerID(),20);
   }
    @Test
    public void testGetSet(){
       customer1.setCustomerID(19);
       assertNotEquals(this.customer1.getCustomerID(),this.customer2.getCustomerID());
       assertEquals(this.customer1.getSavedSynthesis(),this.customer2.getSavedSynthesis());
       assertEquals(this.customer1.getCart(),this.customer2.getCart());
       ArrayList<Synthesis> s1 = new ArrayList<Synthesis>();
       s1.add(new Synthesis(1234, Money.euros(20),"", new ArrayList<Component>()));
       ArrayList<ProductType>p1 = new ArrayList<ProductType>();
       customer1.setSavedSynthesis(s1);
       customer2.setSavedSynthesis(new ArrayList<>());
       customer2.setCart(p1);
       customer1.setCart(p1);
       assertNotEquals(this.customer1.getSavedSynthesis(),this.customer2.getSavedSynthesis());
       assertEquals(this.customer1.getCart(),this.customer2.getCart());
   }

   @Test
   public void checkCart(){

      assertEquals(new ArrayList<>(), customer1.getCart());
      ProductType p = new ProductType(16627,Money.euros(10), "abc");
      customer1.addToCart(p);
      assertNotNull(customer1.getCart());

      assertEquals(p, customer1.getProduct(16627));

      customer1.removeFromCart(p);

      assertNotEquals(p, customer1.getProduct(16627));
   }

   @Test
   public void checkSaved(){
      assertEquals(new ArrayList<>(), customer1.getSavedSynthesis());
      Synthesis p = new Synthesis(1234, Money.euros(20), "bcd", new ArrayList<Component>());
      customer1.addToSavedSynthesis(p);
      assertNotNull(customer1.getSavedSynthesis());

      assertEquals(p, (Synthesis) customer1.getProduct(1234));

      customer1.removeFromSaved(p);

      assertNotEquals(p, customer1.getProduct(16627));

   }
}
