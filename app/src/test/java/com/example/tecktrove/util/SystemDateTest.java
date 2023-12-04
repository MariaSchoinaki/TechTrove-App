package com.example.tecktrove.util;

import java.util.Calendar;
import org.junit.*;


public class SystemDateTest {
    int YEAR_STUB = 1971;
    int MONTH_STUB = 11;
    int DATE_STUB = 30;

    SimpleCalendar stub;

    @Before
    public void setUp() {
        SystemDate.removeStub();
        stub = new SimpleCalendar(YEAR_STUB, MONTH_STUB, DATE_STUB);
    }

    @After
    public void reset()
    {
        SystemDate d = new SystemDate();
        SystemDate.removeStub();
    }

    @Test
    public void testWithoutStub() {
        SimpleCalendar realNow = new SimpleCalendar(Calendar.getInstance());
        Assert.assertEquals(SystemDate.now(), realNow);
    }

    @Test
    public void testWithStub() {
        SystemDate.setStub(stub);
        Assert.assertEquals(stub, SystemDate.now());

    }

    @Test
    public void switchStubUsage() {
        Assert.assertEquals(new SimpleCalendar(Calendar.getInstance()), SystemDate.now());
        SystemDate.setStub(stub);
        Assert.assertEquals(stub, SystemDate.now());
        SystemDate.removeStub();
        Assert.assertEquals(new SimpleCalendar(Calendar.getInstance()), SystemDate.now());
    }
}