package com.example.tecktrove.view.Customer.Order;

import com.example.tecktrove.dao.Initializer;
import com.example.tecktrove.memorydao.ComponentDAOMemory;
import com.example.tecktrove.memorydao.MemoryInitializer;
import com.example.tecktrove.memorydao.SynthesisDAOMemory;
import com.example.tecktrove.view.Customer.Synthesis.SynthesisContainerViewStub;
import com.example.tecktrove.view.MyAccount.OrderHistory.OrderHistoryPresenter;
import com.example.tecktrove.view.SharedViewModel;
import com.example.tecktrove.view.Synthesis.SynthesisContainerPresenter;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class OrderHistoryPresenterTest {

    OrderHistoryViewStub view;

    private SharedViewModel model;
    private Initializer init;

    private OrderHistoryPresenter presenter;
    private ComponentDAOMemory componentDAOMemory;
    private SynthesisDAOMemory synthesisDAOMemory;

    @Before
    public void setUp(){
        init = new MemoryInitializer();
        init.prepareData();
        model = new SharedViewModel();
        componentDAOMemory = new ComponentDAOMemory();
        synthesisDAOMemory = new SynthesisDAOMemory();

        view = new OrderHistoryViewStub();
        presenter = new OrderHistoryPresenter(view);



    }

    @Test
    public  void testAll(){
        presenter.onCart();
        presenter.onHome();
        presenter.onSaved();
        presenter.onMyAcount();

        Assert.assertEquals(1,view.getCart());
        Assert.assertEquals(1,view.getHome());
        Assert.assertEquals(1,view.getSaved());
        Assert.assertEquals(1,view.getMyAccount());

    }
}
