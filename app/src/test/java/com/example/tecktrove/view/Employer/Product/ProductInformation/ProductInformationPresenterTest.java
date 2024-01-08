package com.example.tecktrove.view.Employer.Product.ProductInformation;

import com.example.tecktrove.dao.ComponentDAO;
import com.example.tecktrove.dao.Initializer;
import com.example.tecktrove.dao.SynthesisDAO;
import com.example.tecktrove.memorydao.ComponentDAOMemory;
import com.example.tecktrove.memorydao.MemoryInitializer;
import com.example.tecktrove.memorydao.SynthesisDAOMemory;
import com.example.tecktrove.util.Money;
import com.example.tecktrove.util.Pair;
import com.example.tecktrove.util.Port;
import com.example.tecktrove.view.Employer.Product.ProductInformation.ProductPresenter;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;

public class ProductInformationPresenterTest {

    private ProductInformationViewStub view;
    private ProductPresenter presenter;
    private ComponentDAO componentDAO;
    private SynthesisDAO synthesisDAO;

    /**
     * Sets up the presenter and initializes the data
     */
    @Before
    public void setUp(){
        Initializer init = new MemoryInitializer();
        init.prepareData();

        view = new ProductInformationViewStub();
        componentDAO = new ComponentDAOMemory();
        synthesisDAO = new SynthesisDAOMemory();
        presenter = new ProductPresenter(componentDAO, synthesisDAO,view);
    }

    /**
     * Tests showing product info
     */
    @Test
    public void testShowInfo(){
        Assert.assertEquals(0, view.getTimesShowInfoOfProduct());
        presenter.setInfo(3260);
        Assert.assertEquals(1, view.getTimesShowInfoOfProduct());
        Assert.assertEquals("AMD CPU Ryzen 3 3200G", view.getName());
        Assert.assertEquals("3260", view.getModelNo());
        Assert.assertEquals("Με τέσσερις πυρήνες Zen σε Socket AM4, μέγιστη συχνότητα λειτουργίας 4GHz, μνήμη cache 6MB και Radeon Vega 8 iGPU για αξεπέραστες επιδόσεις γραφικών.", view.getDescription());
        Assert.assertEquals("AMD", view.getManufacturer());
        Assert.assertNull(view.getAvailablePorts());

        Assert.assertEquals(0, view.getTimesShowInfoOfSynthesi());
        presenter.setInfo(9787);
        Assert.assertEquals(1, view.getTimesShowInfoOfSynthesi());
        Assert.assertEquals("Synthesis1", view.getName());
        Assert.assertEquals(Money.euros(new BigDecimal(521.29)).toString(), view.getPrice());
        Assert.assertEquals("9787", view.getModelNo());
    }

    /**
     * Testing the page on exit navigation
     */
    @Test
    public void testOnExit(){
        Assert.assertEquals(0, view.getTimesExited());
        presenter.goToHomeScreen();
        Assert.assertEquals(1, view.getTimesExited());
    }

    /**
     * Testing adding quantity to product
     */
    @Test
    public void testAddQuantity(){
        presenter.setInfo(3260);
        view.setQuantity(-3);
        presenter.onIncreaseQuantity(3260);
        Assert.assertEquals(1, view.getTimesShowingMessage());

        view.setQuantity(10);
        presenter.onIncreaseQuantity(3260);
        Assert.assertEquals(70, componentDAO.find(3260).getQuantity());
    }

    /**
     * Testing delete functionality
     */
    @Test
    public void TestDelete(){
        presenter.onDelete(3260);
        Assert.assertNull(componentDAO.find(3260));

        presenter.onDelete(9787);
        Assert.assertNull(synthesisDAO.find(9787));
    }

    /**
     * Tests changing the information of a component
     */
    @Test
    public void testChange(){

        presenter.setInfo(3260);
        presenter.goToChange(3260);

        Assert.assertEquals(0, view.getTimesShowingMessage());
        view.setName("");
        presenter.ChangeInfo(3260);
        Assert.assertEquals(1, view.getTimesShowingMessage());

        presenter.setInfo(3260);
        view.setName("Turbo-X PSU Value III Series 550 W");
        presenter.ChangeInfo(3260);
        Assert.assertEquals(2, view.getTimesShowingMessage());

        presenter.setInfo(3260);
        view.setModelNo(2936);
        presenter.ChangeInfo(3260);
        Assert.assertEquals(3, view.getTimesShowingMessage());


        view.setName("nice ram");
        view.setModelNo(3260);
        view.setPorts("socket AM4: 1");
        presenter.ChangeInfo(3260);}
}
