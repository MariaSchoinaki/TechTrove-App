package com.example.tecktrove.util;

import org.junit.*;

import java.util.Currency;
import java.math.BigDecimal;

public class MoneyTest {


    @Test
    public void checkEquals(){
        Money m = new Money(null, null);
        Assert.assertFalse(m.equals(new Object()));

        Assert.assertFalse((Money.euros(30)).equals(null));
        Assert.assertEquals(Money.dollars(20), new Money(new BigDecimal(20), Currency.getInstance("USD")));

        Money m1 = new Money((new BigDecimal(15)), Currency.getInstance("EUR"));
        Assert.assertNotNull(m1);
        Assert.assertEquals("10 €", new Money(new BigDecimal(10), Currency.getInstance("EUR")).toString());

        Assert.assertTrue(m.equals(m));
        Assert.assertTrue(m.equals(new Money(null,null)));

        Assert.assertFalse((m1.equals(Money.dollars(20))));

        Assert.assertEquals(465, m1.hashCode());

    }

    @Test
    public void plusSameCurrencies(){
        Money m1 = Money.euros(10);
        Money m2 = Money.euros(15);

        Money m3 = m1.plus(m2);
        Assert.assertEquals(new BigDecimal(25), m3.getAmount());
        Assert.assertEquals(Currency.getInstance("EUR"), m3.getCurrency());
        Assert.assertEquals(new BigDecimal(10), m1.getAmount());
        Assert.assertEquals(new BigDecimal(15), m2.getAmount());
    }

    @Test(expected=IllegalArgumentException.class)
    public void plusDifferentCurrencies() {
        Money a = Money.euros(10);
        Money b = Money.dollars(5);
        a.plus(b);
    }

    @Test
    public void minusSameCurrencies(){
        Money m1 = Money.euros(10);
        Money m2 = Money.euros(15);

        Money m3 = m2.minus(m1);
        Assert.assertEquals(new BigDecimal(5), m3.getAmount());
        Assert.assertEquals(Currency.getInstance("EUR"), m3.getCurrency());
        Assert.assertEquals(new BigDecimal(10), m1.getAmount());
        Assert.assertEquals(new BigDecimal(15), m2.getAmount());
    }

    @Test(expected=IllegalArgumentException.class)
    public void minusDifferentCurrencies() {
        Money a = Money.euros(10);
        Money b = Money.dollars(5);
        a.minus(b);
    }

    @Test
    public void multiply() {
        Money m1 = Money.euros(10);
        Money m2 = m1.times(5);
        Assert.assertEquals(new BigDecimal(10), m1.getAmount());
        Assert.assertEquals(Currency.getInstance("EUR"), m1.getCurrency());

        Assert.assertEquals(new BigDecimal(50), m2.getAmount());
        Assert.assertEquals(Currency.getInstance("EUR"), m2.getCurrency());

        m2 = m1.times(new BigDecimal(5));
        Assert.assertEquals(new BigDecimal(10), m1.getAmount());
        Assert.assertEquals(Currency.getInstance("EUR"), m1.getCurrency());

        Assert.assertEquals(new BigDecimal(50), m2.getAmount());
        Assert.assertEquals(Currency.getInstance("EUR"), m2.getCurrency());
    }

    @Test
    public void divide() {
        Money m1 = Money.euros(10);
        Money m2 = m1.divide(5);
        Assert.assertEquals(new BigDecimal(10), m1.getAmount());
        Assert.assertEquals(Currency.getInstance("EUR"), m1.getCurrency());

        Assert.assertEquals(new BigDecimal(2), m2.getAmount());
        Assert.assertEquals(Currency.getInstance("EUR"), m2.getCurrency());

        m2 = m1.divide(new BigDecimal(5));
        Assert.assertEquals(new BigDecimal(10), m1.getAmount());
        Assert.assertEquals(Currency.getInstance("EUR"), m1.getCurrency());

        Assert.assertEquals(new BigDecimal(2), m2.getAmount());
        Assert.assertEquals(Currency.getInstance("EUR"), m2.getCurrency());
    }

}
