package com.example.tecktrove.contacts;

import org.junit.*;

public class EmailTest {

    @Test
    public void checkEquals(){
        Email e = new Email("elen@gmail.com");

        Assert.assertFalse(e.equals(new Object()));

        Assert.assertEquals("elen@gmail.com", e.getEmail());
        Assert.assertFalse((new Email("other@g.gr")).equals(null));
        Assert.assertNotNull(e);
        Assert.assertEquals(e , new Email("elen@gmail.com"));
        Assert.assertEquals(e,e);

        Assert.assertTrue(e.isValid());
    }
}
