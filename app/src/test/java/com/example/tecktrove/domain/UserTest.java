package com.example.tecktrove.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;

import com.example.tecktrove.contacts.Email;
import com.example.tecktrove.contacts.Telephone;

import org.junit.*;

import java.util.ArrayList;

public class UserTest {

    private User user1;
    private User user2;

    @Before
    public void setUp(){
        this.user1 = new User(1, "george15", "12345", "George", "Papageorge", new Email("george@gmail.com"), new Telephone("6987402775"));
        this.user2 = new User(45, "leana", "les34", "Leana", "Triantafillidi", new Email("lean@gmail.com"), new Telephone("6987563456"));
    }
    @Test
    public void checkDefaultConstructor(){
        User user = new User();
        assertNull(user.getUsername());
        user.setId(4534);
        assertEquals(4534, user.getId());
    }

    @Test
    public void checkGetSet(){
        assertNotEquals(this.user1.getEmail(), this.user2.getEmail());
        assertNotEquals(this.user1.getId(),this.user2.getId());
        assertNotEquals(this.user1.getName(),this.user2.getName());
        assertNotEquals(this.user1.getTelephone(),this.user2.getTelephone());
        assertNotEquals(this.user1.getPassword(),this.user2.getPassword());
        assertNotEquals(this.user1.getUsername(),this.user2.getUsername());
        assertNotEquals(this.user1.getLastName(),this.user2.getLastName());

        this.user1.setName("Leana");
        assertEquals("Leana", this.user1.getName());

        assertEquals(user1,user1);
        assertNotEquals(user1, new User());


        user1.setEmail(new Email("a@b.g"));
        assertEquals("a@b.g",user1.getEmail().getEmail());

        user1.setPassword("password");
        assertEquals("password", user1.getPassword());

        user1.setUsername("a23");
        assertEquals("a23", user1.getUsername());

        user2.setLastName("Triantafillidou");
        assertEquals("Triantafillidou", user2.getLastName());

        user2.setTelephone(new Telephone("6987036565"));
        assertEquals(new Telephone("6987036565"), user2.getTelephone());

    }
    @Test
    public void checkEquality(){
        assertNotEquals(user1, user2);
        User user3 = new User(45, "leana", "les34", "Leana", "Triantafillidi", new Email("lean@gmail.com"), new Telephone("6987563456"));
        assertEquals(user2,user3);

        Object other = new Object();
        assertNotEquals(user1, other);
        assertEquals(user1,user1);
        assertFalse(user2.equals(null));
    }
}
