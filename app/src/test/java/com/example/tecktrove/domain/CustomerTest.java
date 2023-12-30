package com.example.tecktrove.domain;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
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
       customer1 = new Customer(18,  "lola", "1234", "lo", "la", new Email("ok@gmail.com"), new Telephone("12345"), new ArrayList<Synthesis>(), new ArrayList<ProductType>());
       customer2 = new Customer(18,  "lola", "1234", "lo", "la", new Email("ok@gmail.com"), new Telephone("12345"), new ArrayList<Synthesis>(), new ArrayList<ProductType>());
   }
   @Test
   public void checkDefaultConstructor(){
      Customer o = new Customer();
      ArrayList<ProductType> c1 = new ArrayList<ProductType>();
      o.setCart(c1);
      assertEquals(o.getCart(),c1);
   }
    @Test
    public void testGetSet(){

       assertEquals(this.customer1.getSavedSynthesis(),this.customer2.getSavedSynthesis());
       assertEquals(this.customer1.getCart(),this.customer2.getCart());
       ArrayList<Synthesis> s1 = new ArrayList<Synthesis>();
       s1.add(new Synthesis(1234, Money.euros(20),""));
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
      ProductType k = new ProductType(15627,Money.euros(10), "acb");
      customer1.addToCart(p);
      customer1.addToCart(k);
      assertNotNull(customer1.getCart());

      assertEquals(k, customer1.getProductFromCart(15627));

      customer1.removeFromCart(p);

      assertNotEquals(p, customer1.getProductFromCart(16627));
   }

   @Test
   public void checkSaved(){
      assertEquals(new ArrayList<>(), customer1.getSavedSynthesis());
      Synthesis p = new Synthesis(1234, Money.euros(20), "bcd");

      Synthesis k = new Synthesis(15627,Money.euros(10), "acb");
      customer1.addToSavedSynthesis(p);
      customer1.addToSavedSynthesis(k);
      assertNotNull(customer1.getSavedSynthesis());

      assertEquals(k, (Synthesis) customer1.getProductFromSaved(15627));

      customer1.removeFromSaved(p);

      assertNotEquals(p, customer1.getProductFromSaved(16627));

   }
   @Test
   public void checkEquality(){
      Customer c1 = new Customer(5673, "george", "g5797j6", "George", "Johnson", new Email("klap@yahoo.com"), new Telephone("6898909678"), new ArrayList<Synthesis>(), new ArrayList<ProductType>());
      Customer c2 = new Customer(18,  "lola", "1234", "lo", "la", new Email("ok@gmail.com"), new Telephone("12345"), new ArrayList<Synthesis>(), new ArrayList<ProductType>());
      assertNotEquals(c1, c2);

      Customer c3 = new Customer(18,  "lola", "1234", "lo", "la", new Email("ok@gmail.com"), new Telephone("12345"), new ArrayList<Synthesis>(), new ArrayList<ProductType>());
      assertEquals(c2,c3);

      Object other = new Object();
      assertNotEquals(c1, other);
      assertEquals(c1,c1);
      assertFalse(c2.equals(null));
   }
}
