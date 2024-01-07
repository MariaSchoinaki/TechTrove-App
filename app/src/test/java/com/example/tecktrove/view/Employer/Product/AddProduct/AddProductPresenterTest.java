package com.example.tecktrove.view.Employer.Product.AddProduct;

import com.example.tecktrove.dao.ComponentDAO;
import com.example.tecktrove.dao.Initializer;
import com.example.tecktrove.memorydao.ComponentDAOMemory;
import com.example.tecktrove.memorydao.MemoryInitializer;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AddProductPresenterTest {

    private AddProductViewStub view;
    private AddProductPresenter presenter;
    private ComponentDAO componentDAO;

    /**
     * Sets up the presenter and initializes the data
     */
    @Before
    public void setUp(){
        Initializer init = new MemoryInitializer();
        init.prepareData();

        view = new AddProductViewStub();
        componentDAO = new ComponentDAOMemory();
        presenter = new AddProductPresenter(view ,componentDAO);
    }

    /**
     * Testing the page on home navigation
     */
    @Test
    public void testHome(){
        Assert.assertEquals(0, view.getTimesHomeScreen());
        presenter.onHomeScreen();
        Assert.assertEquals(1, view.getTimesHomeScreen());
    }

    /**
     * Testing add product functionality
     */
    @Test
    public void testAddProduct(){
        //absent main attribute
        Assert.assertEquals(0, view.getTimesShowingMessage());
        view.setModelNo("");
        presenter.saveProduct();
        Assert.assertEquals(1, view.getTimesShowingMessage());

        //existing name
        view.setDescription("Runs very fast");
        view.setAvailable_ports("");
        view.setManufacturer("AMD");
        view.setRequired_ports("");
        view.setModelNo("12347");
        view.setPrice("36.90 €");
        view.setName("Turbo-X PSU Value III Series 550 W");
        presenter.saveProduct();
        Assert.assertEquals(2, view.getTimesShowingMessage());

        //existing modelno
        view.setModelNo("2936");
        view.setName("Great cpu");
        presenter.saveProduct();
        Assert.assertEquals(2, view.getTimesShowingMessage());

        //everything good
        view.setName("Great cpu");
        view.setModelNo("123457");
        view.setDescription("Runs very fast");
        view.setAvailable_ports("socket AM4: 1");
        view.setManufacturer("AMD");
        view.setRequired_ports("socket AM4: 1");
        view.setPrice("36.90 €");
        presenter.saveProduct();

        Assert.assertNotNull(componentDAO.find(123457));
        Assert.assertEquals("Great cpu", componentDAO.find(123457).getName());
    }
}
