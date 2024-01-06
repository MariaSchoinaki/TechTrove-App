package com.example.tecktrove.view.Customer.HomeScreen;

import com.example.tecktrove.dao.Initializer;
import com.example.tecktrove.memorydao.ComponentDAOMemory;
import com.example.tecktrove.memorydao.CustomerDAOMemory;
import com.example.tecktrove.memorydao.EmployerDAOMemory;
import com.example.tecktrove.memorydao.MemoryInitializer;
import com.example.tecktrove.memorydao.SynthesisDAOMemory;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class HomeScreenPresenterTest {

    private HomeScreenViewStub view;
    private Initializer init;
    private HomeScreenPresenter presenter;

    @Before
    public void setUp(){
        init = new MemoryInitializer();
        init.prepareData();

        view = new HomeScreenViewStub();
        presenter = new HomeScreenPresenter(view, new CustomerDAOMemory(), new EmployerDAOMemory(), new ComponentDAOMemory(), new SynthesisDAOMemory());
    }

    @Test
    public void test(){

        Assert.assertEquals(0, view.getTimesVisitedCart());
        presenter.onCart();
        Assert.assertEquals(1, view.getTimesVisitedCart());

        Assert.assertEquals(0,view.getTimesVisitedHome());
        presenter.onHome();
        Assert.assertEquals(1,view.getTimesVisitedHome());

        Assert.assertEquals(0, view.getTimesVisitedMyAccount());
        presenter.onMyAccount();
        Assert.assertEquals(1, view.getTimesVisitedMyAccount());

        Assert.assertEquals(0, view.getTimesVisitedDiySynthesis());
        presenter.onDIYSyntesis();
        Assert.assertEquals(1, view.getTimesVisitedDiySynthesis());

        Assert.assertEquals(0, view.getGoback());
        presenter.onBack();
        Assert.assertEquals(1, view.getGoback());

    }

    @Test
    public void testDisplayProducts(){
        Assert.assertEquals(0, view.getTimesShownCategory());
        presenter.onDisplayProducts("all");
        Assert.assertEquals(1, view.getTimesShownCategory());
        Assert.assertEquals(18, view.getNumberOfProducts());

        presenter.onDisplayProducts("ram");
        Assert.assertEquals(2, view.getNumberOfProducts());
    }
}
