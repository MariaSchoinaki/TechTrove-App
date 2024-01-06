package com.example.tecktrove.view.Authentication.SignUp;

import com.example.tecktrove.contacts.Email;
import com.example.tecktrove.contacts.Telephone;
import com.example.tecktrove.dao.CustomerDAO;
import com.example.tecktrove.dao.EmployerDAO;
import com.example.tecktrove.dao.Initializer;
import com.example.tecktrove.memorydao.CustomerDAOMemory;
import com.example.tecktrove.memorydao.EmployerDAOMemory;
import com.example.tecktrove.memorydao.MemoryInitializer;
import com.example.tecktrove.view.Authentication.LogIn.LogInPresenter;
import com.example.tecktrove.view.Authentication.LogIn.LogInViewStub;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SignUpPresenterTest {
    private Initializer init;

    private SignUpPresenter presenter;

    private SignUpViewStub view;

    private CustomerDAO customerDAO;

    private EmployerDAO employerDAO;

    @Before
    public void setUp(){
        init = new MemoryInitializer();
        init.prepareData();
        view = new SignUpViewStub();
        this.presenter = new SignUpPresenter( view, new CustomerDAOMemory(), new EmployerDAOMemory());
    }


    

    @Test
    public void testLogin(){
        presenter.onLogIn();
        Assert.assertEquals(1,view.getTimesVisitedLogIn());
    }
}
