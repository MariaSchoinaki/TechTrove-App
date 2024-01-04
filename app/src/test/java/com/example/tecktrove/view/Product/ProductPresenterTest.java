package com.example.tecktrove.view.Product;

import com.example.tecktrove.dao.Initializer;
import com.example.tecktrove.memorydao.ComponentDAOMemory;
import com.example.tecktrove.memorydao.MemoryInitializer;
import com.example.tecktrove.memorydao.SynthesisDAOMemory;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ProductPresenterTest {

    private ProductViewStub view;
    private ProductPresenter presenter;

    @Before
    public void setUp(){
        Initializer init = new MemoryInitializer();
        init.prepareData();

        view = new ProductViewStub();
        presenter = new ProductPresenter(new ComponentDAOMemory(), new SynthesisDAOMemory(),view);
    }

    @Test
    public void testShowInfo(){
        presenter.setInfo(1);
        Assert.assertEquals(0, view.getTimesShowInfoOfProduct());

        presenter.setInfo(2936);
        Assert.assertEquals(1, view.getTimesShowInfoOfProduct());
    }

    @Test
    public void test(){
        Assert.assertEquals(view, view.getProductView());
        Assert.assertNotNull(view.getProductView());

        //Assert.assertNull(new Object());
    }

    @Test
    public void testCart(){
        presenter.setInfo(2936);

        Assert.assertEquals(0, view.getTimesShowingMessage());
        presenter.goToCart(80, 2936);
        Assert.assertEquals(1, view.getTimesShowingMessage());
        Assert.assertEquals(75, view.getQuantity());

        presenter.goToCart(2, 2936);
        Assert.assertEquals(73, view.getQuantity());

        presenter.goToCart(1, 9787);
    }

    @Test
    public void testIncreaseDecrease(){
        presenter.setInfo(3260);
        Assert.assertEquals(0,view.getTimesDecreasedQuantity());
        Assert.assertEquals(0, view.getTimesIncreasedQuantity());

        presenter.onIncreaseQuantity();
        presenter.onDecreaseQuantity();
        Assert.assertEquals(1,view.getTimesDecreasedQuantity());
        Assert.assertEquals(1, view.getTimesIncreasedQuantity());
    }
}
