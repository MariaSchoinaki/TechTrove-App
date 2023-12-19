package com.example.tecktrove.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;

import com.example.tecktrove.contacts.Email;
import com.example.tecktrove.contacts.Telephone;

import org.junit.Test;
import org.junit.Before;

public class EmployerTest {

    private Employer employer;

    @Before
    public void setUp(){
        this.employer = new Employer(3456, "employer1", "emp78", "Joanna", "Legrange" ,new Email("joanna@gmail.com"), new Telephone("6970876734"));
    }

    @Test
    public void checkDefaultConstructor(){
        Employer emp = new Employer();
        assertNull(emp.getUsername());
        emp.setName("Christos");
        assertEquals("Christos", emp.getName());
    }

    @Test
    public void checkEquals(){
        Employer e1 = new Employer(5673, "george", "george56", "George", "Kennedy", new Email("klap@yahoo.com"), new Telephone("6898909678"));
        Employer e2 = new Employer(8956, "kenny1999", "ken1256k", "Kenny", "Jonhson", new Email("kennyjonhson@gmail.com"), new Telephone("6984564578"));

        assertNotEquals(e1, e2);

        Employer e3 = new Employer(8956, "kenny1999", "ken1256k", "Kenny", "Jonhson", new Email("kennyjonhson@gmail.com"), new Telephone("6984564578"));
        assertEquals(e2,e3);

        Object other = new Object();
        assertNotEquals(e1, other);
        assertEquals(e1,e1);
        assertFalse(e2.equals(null));

    }

}
