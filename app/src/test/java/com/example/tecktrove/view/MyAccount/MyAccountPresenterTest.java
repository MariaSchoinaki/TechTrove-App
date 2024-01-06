package com.example.tecktrove.view.MyAccount;

import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;

import com.example.tecktrove.dao.Initializer;
import com.example.tecktrove.domain.Customer;
import com.example.tecktrove.domain.Employer;
import com.example.tecktrove.memorydao.CustomerDAOMemory;
import com.example.tecktrove.memorydao.EmployerDAOMemory;
import com.example.tecktrove.memorydao.MemoryInitializer;
import com.example.tecktrove.view.SharedViewModel;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MyAccountPresenterTest {

    private MyAccountPresenter presenter;
    private MyAccountViewStub view;
    private Initializer init;
    private SharedViewModel sharedViewModel;

    @Before
    public void setUp(){
        init = new MemoryInitializer();
        init.prepareData();

        view = new MyAccountViewStub();
        presenter = new MyAccountPresenter(view, new CustomerDAOMemory(), new EmployerDAOMemory());
    }

    @Test
    public void testLogOut(){
        Assert.assertEquals(0, view.getTimesLogedOut());

        presenter.onLogout();
        Assert.assertEquals(1, view.getTimesLogedOut());
    }

    @Test
    public void testDeleteAccount(){
        presenter.onDeleteAccount();
        Assert.assertEquals(1, view.getTimesLogedOut());
    }

    @Test
    public void testChanges(){
        Customer c = init.getCustomerDAO().findCustomerByUsernameAndPassword("george", "ok123456");

        presenter.setInfo("", c.getEmail().getEmail(), c.getTelephone().getTelephone(), c.getUsername(), c.getPassword(), c.getPassword(), false);
        presenter.onSaveChanges(c,5673);
        Assert.assertEquals(1, view.getTimesShowingMessage());

        presenter.setInfo(c.getName()+" "+c.getLastName(), c.getEmail().getEmail(), c.getTelephone().getTelephone(), "1", c.getPassword(), c.getPassword(), false);
        presenter.onSaveChanges(c,5673);
        Assert.assertEquals(2, view.getTimesShowingMessage());

        presenter.setInfo(c.getName()+" "+c.getLastName(), c.getEmail().getEmail(), c.getTelephone().getTelephone(), "meow meow", c.getPassword(), c.getPassword(), false);
        presenter.onSaveChanges(c,5673);
        Assert.assertEquals(3, view.getTimesShowingMessage());

        presenter.setInfo(c.getName()+" "+c.getLastName(), c.getEmail().getEmail(), "69878", c.getUsername(), c.getPassword(), c.getPassword(), false);
        presenter.onSaveChanges(c,5673);
        Assert.assertEquals(4, view.getTimesShowingMessage());


        presenter.setInfo(c.getName()+" "+c.getLastName(), c.getEmail().getEmail(), c.getTelephone().getTelephone(), c.getUsername(), "plk", c.getPassword(), false);
        presenter.onSaveChanges(c,5673);
        Assert.assertEquals(5, view.getTimesShowingMessage());


        presenter.setInfo(c.getName()+" "+c.getLastName(), c.getEmail().getEmail(), c.getTelephone().getTelephone(), c.getUsername(), c.getPassword(), "plot8890", false);
        presenter.onSaveChanges(c,5673);
        Assert.assertEquals(6, view.getTimesShowingMessage());


        presenter.setInfo(c.getName()+" "+c.getLastName(), c.getEmail().getEmail(), c.getTelephone().getTelephone(), "maria5", c.getPassword(), c.getPassword(), false);
        presenter.onSaveChanges(c,5673);
        Assert.assertEquals(7, view.getTimesShowingMessage());

        presenter.setInfo(c.getName()+" "+c.getLastName(), "el.gr", c.getTelephone().getTelephone(),  c.getUsername(), c.getPassword(), c.getPassword(), false);
        presenter.onSaveChanges(c,5673);
        Assert.assertEquals(8, view.getTimesShowingMessage());

        presenter.setInfo("George kallifanakis", c.getEmail().getEmail(), "6987898956", "georgie", c.getPassword(), c.getPassword(), false);
        presenter.onSaveChanges(c,5673);

        c = init.getCustomerDAO().findCustomerByUsernameAndPassword("george", "ok123456");
        Assert.assertNull(c);

        c = init.getCustomerDAO().findCustomerByUsernameAndPassword("georgie", "ok123456");
        Assert.assertNotNull(c);
        Assert.assertEquals("kallifanakis", c.getLastName());

        Employer e = init.getEmployerDAO().findEmployerByUsernameAndPassword("eleni3", "elen!562");

        presenter.setInfo("eleni maria", e.getEmail().getEmail(), "6987020265", "faihh1", e.getPassword(), e.getPassword(), true);
        presenter.onSaveChanges(e, 1252);
        Assert.assertEquals(10, view.getTimesShowingMessage());

        presenter.setInfo("eleni maria", e.getEmail().getEmail(), "6987020265", "elenara", e.getPassword(), e.getPassword(), true);
        presenter.onSaveChanges(e, 1252);

        e = init.getEmployerDAO().findEmployerByUsernameAndPassword("eleni3", "elen!562");
        Assert.assertNull(e);
        e = init.getEmployerDAO().findEmployerByUsernameAndPassword("elenara", "elen!562");
        Assert.assertNotNull(e);
        Assert.assertEquals("eleni", e.getName());
    }
}
