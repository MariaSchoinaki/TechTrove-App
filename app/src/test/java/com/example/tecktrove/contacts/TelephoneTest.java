package com.example.tecktrove.contacts;

import org.junit.*;

public class TelephoneTest {

    @Test
    public void checkEquals(){
        Telephone t = new Telephone("123");

        Assert.assertFalse(t.equals(new Object()));

        Assert.assertEquals("123", t.getTelephone());
        Assert.assertFalse((new Telephone("456")).equals(null));
        Assert.assertNotNull(t);
        Assert.assertEquals(t , new Telephone("123"));
    }
}
