package com.example.tecktrove.view.Employer.HomeSreen;

import com.example.tecktrove.dao.Initializer;
import com.example.tecktrove.memorydao.ComponentDAOMemory;
import com.example.tecktrove.memorydao.CustomerDAOMemory;
import com.example.tecktrove.memorydao.EmployerDAOMemory;
import com.example.tecktrove.memorydao.MemoryInitializer;
import com.example.tecktrove.memorydao.SynthesisDAOMemory;
import com.example.tecktrove.view.Employer.HomeScreen.HomeScreenPresenter;

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
        Assert.assertEquals(0,view.getTimesVisitedHome());
        presenter.onHome();
        Assert.assertEquals(1,view.getTimesVisitedHome());

        Assert.assertEquals(0, view.getTimesVisitedMyAccount());
        presenter.onMyAccount();
        Assert.assertEquals(1, view.getTimesVisitedMyAccount());


        Assert.assertEquals(0, view.getTimesGoBack());
        presenter.onBack();
        Assert.assertEquals(1, view.getTimesGoBack());


        Assert.assertEquals(0, view.getTimesAddedProducts());
        presenter.onAddProduct();
        Assert.assertEquals(1, view.getTimesAddedProducts());
    }

    @Test
    public void testDisplayProducts(){
        Assert.assertEquals(0, view.getTimesShownCategory());
        presenter.onDisplayProducts("all");
        Assert.assertEquals(1, view.getTimesShownCategory());
        Assert.assertEquals(18, view.getNumberOfProducts());

        presenter.onDisplayProducts("ram");
        Assert.assertEquals(2, view.getNumberOfProducts());

        presenter.onDisplayProducts("hmmmm");
        Assert.assertEquals(0, view.getNumberOfProducts());
    }
}
