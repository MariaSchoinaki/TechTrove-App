package com.example.tecktrove.view.Customer.Order;

import com.example.tecktrove.view.MyAccount.OrderHistory.OrderPresenter;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class OrderTest {

    OrderViewStab view;

    OrderPresenter presenter;
    /**
     * setup data
     * */
    @Before
    public void setUp(){
        view = new OrderViewStab();
        presenter = new OrderPresenter(view);
    }
    /**
     * Test navigation
     * */
    @Test
    public  void testAll(){
        presenter.onCart();
        presenter.onHome();
        presenter.onSaved();
        presenter.onMyAcount();

        Assert.assertEquals(1,view.getCart());
        Assert.assertEquals(1,view.getHome());
        Assert.assertEquals(1,view.getSaved());
        Assert.assertEquals(1,view.getMyAccount());

    }
}
