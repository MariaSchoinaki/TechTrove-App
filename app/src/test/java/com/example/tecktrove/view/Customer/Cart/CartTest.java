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


    /**
     * Initializes the data
     */
    @Before
    public void setUp(){
        init = new MemoryInitializer();
        init.prepareData();
        view = new CartViewStub();
        presenter = new CartPresenter(view);
    }

    /**
     * Tests the cart's functionality
     */
    @Test
    public void TestCart(){
        presenter.onCart();
        Assert.assertEquals(1, view.getOnCart());
    }

    /**
     * Tests navigating on the Homepage
     */
    @Test
    public void TestHome(){
        presenter.onHome();
        Assert.assertEquals(1, view.getOnHome());
    }

    /**
     * Tests navigating on the saved synthesis
     */
    @Test
    public void TestSaved(){
        presenter.onSaved();
        Assert.assertEquals(1, view.getOnSaved());
    }

    /**
     * Tests navigating on my account tab
     */
    @Test
    public void TestMyacount(){
        presenter.onMyAcount();
        Assert.assertEquals(1, view.getOnMyacount());
    }

    /**
     * Tests navigating to purchase
     */
    @Test
    public void TestPurchase(){
        presenter.onPurchase();
        Assert.assertEquals(1, view.getPurchase());
    }





}
