package com.example.tecktrove.util;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import org.junit.*;

public class PairTest {
    private Pair p1;
    private Pair p2;
    @Before
    public void setUp(){
         p1 = new Pair("SATA3",2);
         p2 = new Pair("FIREWIRE",1);
    }
    @Test
    public void checkDefaultConstructor(){
        Pair p =new Pair();
        p.setFirst("VGA");
        p.setSecond(1);
        assertEquals(p.getFirst(),"VGA");
        assertEquals(p.getSecond(),1);

    }

    @Test
    public void checkGetSet(){
        assertNotEquals(this.p1.getSecond(),this.p2.getSecond());
        p1.setFirst("FIREWIRE");
        assertEquals(this.p1.getFirst(),this.p2.getFirst());
        p2.setSecond(2);
        assertEquals(this.p1.getSecond(),this.p2.getSecond());
    }
}
