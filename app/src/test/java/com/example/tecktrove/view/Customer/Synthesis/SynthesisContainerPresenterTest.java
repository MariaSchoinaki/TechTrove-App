package com.example.tecktrove.view.Customer.Synthesis;

import com.example.tecktrove.dao.Initializer;
import com.example.tecktrove.domain.Customer;
import com.example.tecktrove.domain.Synthesis;
import com.example.tecktrove.memorydao.ComponentDAOMemory;
import com.example.tecktrove.memorydao.MemoryInitializer;
import com.example.tecktrove.memorydao.SynthesisDAOMemory;
import com.example.tecktrove.view.SharedViewModel;
import com.example.tecktrove.view.Synthesis.SynthesisContainerPresenter;
import com.example.tecktrove.view.Synthesis.SynthesisPresenter;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SynthesisContainerPresenterTest {
    SynthesisContainerViewStub view;

    private SharedViewModel model;
    private Initializer init;

    private SynthesisContainerPresenter presenter;
    private ComponentDAOMemory componentDAOMemory;
    private SynthesisDAOMemory synthesisDAOMemory;

    /**
     * setup data
     * */
    @Before
    public void setUp(){
        init = new MemoryInitializer();
        init.prepareData();
        model = new SharedViewModel();
        componentDAOMemory = new ComponentDAOMemory();
        synthesisDAOMemory = new SynthesisDAOMemory();

        view = new SynthesisContainerViewStub();
        presenter = new SynthesisContainerPresenter(view,model,synthesisDAOMemory);



    }
    /**
     * Test navigation
     * */
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
