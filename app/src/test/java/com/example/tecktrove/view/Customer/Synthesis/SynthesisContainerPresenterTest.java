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
    @Test
    public void TestCompletedSynthesis(){

        SharedViewModel.getSynthesis().add(componentDAOMemory.find(4191));
        SharedViewModel.getSynthesis().add(componentDAOMemory.find(2936));
        SharedViewModel.getSynthesis().add(componentDAOMemory.find(3260));
        SharedViewModel.getSynthesis().add(componentDAOMemory.find(3888));
        SharedViewModel.getSynthesis().add(componentDAOMemory.find(4188));
        SharedViewModel.getSynthesis().add(componentDAOMemory.find(3935));
        SharedViewModel.getSynthesis().add(componentDAOMemory.find(4311));

        Assert.assertEquals(true,presenter.completeSynthesis());

    }

}
