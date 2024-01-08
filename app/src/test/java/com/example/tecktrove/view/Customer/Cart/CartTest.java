package com.example.tecktrove.view.Customer.Cart;

import com.example.tecktrove.dao.Initializer;
import com.example.tecktrove.memorydao.ComponentDAOMemory;
import com.example.tecktrove.memorydao.CustomerDAOMemory;
import com.example.tecktrove.memorydao.EmployerDAOMemory;
import com.example.tecktrove.memorydao.MemoryInitializer;
import com.example.tecktrove.memorydao.SynthesisDAOMemory;
import com.example.tecktrove.view.Customer.HomeScreen.HomeScreenPresenter;
import com.example.tecktrove.view.Customer.HomeScreen.HomeScreenViewStub;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CartTest {
    private CartViewStub view;

    private Initializer init;

    private CartPresenter presenter;


    @Before
    public void setUp(){
        init = new MemoryInitializer();
        init.prepareData();
        view = new CartViewStub();
        presenter = new CartPresenter(view);
    }

    @Test
    public void TestCart(){
        presenter.onCart();
        Assert.assertEquals(1, view.getOnCart());
    }

    @Test
    public void TestHome(){
        presenter.onHome();
        Assert.assertEquals(1, view.getOnHome());
    }

    @Test
    public void TestSaved(){
        presenter.onSaved();
        Assert.assertEquals(1, view.getOnSaved());
    }

    @Test
    public void TestMyacount(){
        presenter.onMyAcount();
        Assert.assertEquals(1, view.getOnMyacount());
    }

    @Test
    public void TestPurchase(){
        presenter.onPurchase();
        Assert.assertEquals(1, view.getPurchase());
    }





}
