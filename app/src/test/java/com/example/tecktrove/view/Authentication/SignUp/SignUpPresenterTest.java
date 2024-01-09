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
        public void StartProsesTest() {
            view.setUser("george", "ok123456","ok123456", "klap@yahoo.com", "6898909678", "GeorgeJohnson",Boolean.FALSE);
            presenter.startProcess();
            Assert.assertEquals(0, view.timesSignedUp());
            Assert.assertEquals(1,view.getErrorMessage());

            view.setUser("", "ok123456","ok123456", "klap@yahoo.com", "6898909678", "GeorgeJohnson",Boolean.FALSE);
            presenter.startProcess();
            Assert.assertEquals(0, view.timesSignedUp());
            Assert.assertEquals(2,view.getErrorMessage());

            view.setUser("geo", "ok123456","ok123456", "klap@yahoo.com", "6898909678", "GeorgeJohnson",Boolean.FALSE);
            presenter.startProcess();
            Assert.assertEquals(0, view.timesSignedUp());
            Assert.assertEquals(3,view.getErrorMessage());


            view.setUser("geo rge", "ok123456", "ok123456", "klap@yahoo.com", "6898909678", "GeorgeJohnson", Boolean.FALSE);
            presenter.startProcess();
            Assert.assertEquals(0, view.timesSignedUp());
            Assert.assertEquals(4, view.getErrorMessage());

            view.setUser("george", "ok123456", "ok123456", "klap@yahoo.com", "689", "GeorgeJohnson", Boolean.FALSE);
            presenter.startProcess();
            Assert.assertEquals(0, view.timesSignedUp());
            Assert.assertEquals(5, view.getErrorMessage());

            view.setUser("george", "ok1", "ok1", "klap@yahoo.baloon", "6898909678", "GeorgeJohnson", Boolean.FALSE);
            presenter.startProcess();
            Assert.assertEquals(0, view.timesSignedUp());
            Assert.assertEquals(6, view.getErrorMessage());

            view.setUser("george", "ok123456", "ok123456", "klap@yahoo.com", "6898909678", "GeorgeJohnson", Boolean.FALSE);
            presenter.startProcess();
            Assert.assertEquals(0, view.timesSignedUp());
            Assert.assertEquals(7, view.getErrorMessage());

            view.setUser("george", "ok123456", "ok123456", "klap@yahoo.baloon", "6898909678", "GeorgeJohnson", Boolean.FALSE);
            presenter.startProcess();
            Assert.assertEquals(0, view.timesSignedUp());
            Assert.assertEquals(8, view.getErrorMessage());



            view.setUser("georga", "ok11111111111", "ok123456", "klap@yahoo.com", "6898909678", "GeorgeJohnsonnn", Boolean.FALSE);
            presenter.startProcess();
            Assert.assertEquals(0, view.timesSignedUp());
            Assert.assertEquals(9, view.getErrorMessage());

            view.setUser("lolaaaa", "ok123456","ok123456", "klap@yahoo.com", "6898909678", "Georga Johnson",Boolean.TRUE);
            presenter.startProcess();
            Assert.assertEquals(1, view.timesSignedUp());
            Assert.assertEquals(10,view.getErrorMessage());

            view.setUser("george", "ok123456","ok123456", "klap@yahoo.com", "6898909678", "GeorgeJohnson",Boolean.TRUE);
            presenter.startProcess();
            Assert.assertEquals(1, view.timesSignedUp());
            Assert.assertEquals(11,view.getErrorMessage());

            view.setUser("georga", "ok123456","ok123456", "klap@yahoo.com", "6898909678", "GeorgeJohnson",Boolean.FALSE);
            presenter.startProcess();
            Assert.assertEquals(2, view.timesSignedUp());
            Assert.assertEquals(12,view.getErrorMessage());





        }

    @Test
    public void testLogin(){
        presenter.onLogIn();
        Assert.assertEquals(1,view.getTimesVisitedLogIn());
    }
}
