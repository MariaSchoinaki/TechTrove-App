package com.example.tecktrove.view.Customer.Saved;

import com.example.tecktrove.dao.Initializer;
import com.example.tecktrove.memorydao.ComponentDAOMemory;
import com.example.tecktrove.memorydao.CustomerDAOMemory;
import com.example.tecktrove.memorydao.EmployerDAOMemory;
import com.example.tecktrove.memorydao.MemoryInitializer;
import com.example.tecktrove.memorydao.SynthesisDAOMemory;
import com.example.tecktrove.view.Customer.HomeScreen.HomeScreenPresenter;
import com.example.tecktrove.view.Customer.HomeScreen.HomeScreenViewStub;
import com.example.tecktrove.view.Customer.SavedProdacts.SavedProductsPresenter;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SavedProductsTest {
    private SavedProductsStub view;
    private Initializer init;
    private SavedProductsPresenter presenter;

    @Before
    public void Setup(){
        init = new MemoryInitializer();
        init.prepareData();

        view = new SavedProductsStub();
        presenter = new SavedProductsPresenter(view);
    }
    @Test
    public void tabTest(){
        presenter.onHome();
        Assert.assertEquals(1,view.getHome());

        presenter.onSaved();
        Assert.assertEquals(1,view.getSaved());

        presenter.onCart();
        Assert.assertEquals(1,view.getCart());

        presenter.onMyAccount();
        Assert.assertEquals(1,view.getMyAccount());
    }


}
