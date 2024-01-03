package com.example.tecktrove.view.LogIn;

import com.example.tecktrove.dao.CustomerDAO;
import com.example.tecktrove.dao.EmployerDAO;
import com.example.tecktrove.dao.Initializer;
import com.example.tecktrove.memorydao.CustomerDAOMemory;
import com.example.tecktrove.memorydao.EmployerDAOMemory;
import com.example.tecktrove.memorydao.MemoryInitializer;
import com.example.tecktrove.view.Authentication.LogIn.LogInPresenter;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LogInPresenterTest {
    private Initializer init;
    private LogInPresenter presenter;
    private LogInViewStub view;
    private CustomerDAO customerDAO;
    private EmployerDAO employerDAO;

    @Before
    public void setUp(){
        init = new MemoryInitializer();
        init.prepareData();
        view = new LogInViewStub();
        this.presenter = new LogInPresenter(view, new CustomerDAOMemory(), new EmployerDAOMemory());
    }

    @Test
    public void testStartProcess() {
        view.setUser("", "ok123456", false);
        presenter.startProcess();
        Assert.assertEquals(0, view.timesLogedIn());


        view.setUser("george", "", false);
        presenter.startProcess();
        Assert.assertEquals(0, view.timesLogedIn());

        view.setUser("", "", false);
        presenter.startProcess();
        Assert.assertEquals(0, view.timesLogedIn());
        Assert.assertEquals(3, view.getErrorMessage());



        view.setUser("george", "ok123456", false);
        presenter.startProcess();
        Assert.assertEquals(1, view.timesLogedIn());

        view.setUser("eleni3", "elen!562", true);
        presenter.startProcess();
        Assert.assertEquals(2, view.timesLogedIn());

        view.setUser("yolo5", "hehe4567", false);
        presenter.startProcess();
        Assert.assertEquals(4, view.getErrorMessage());

    }

    @Test
    public void testSignUp(){
        presenter.onSignUp();
        Assert.assertEquals(1,view.getTimesVisitedSignUp());
    }
}
