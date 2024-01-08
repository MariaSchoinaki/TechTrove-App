package com.example.tecktrove.view.Customer.Synthesis;

import androidx.lifecycle.ViewModelProvider;

import com.example.tecktrove.dao.Initializer;
import com.example.tecktrove.domain.Component;
import com.example.tecktrove.domain.Synthesis;
import com.example.tecktrove.memorydao.ComponentDAOMemory;
import com.example.tecktrove.memorydao.CustomerDAOMemory;
import com.example.tecktrove.memorydao.EmployerDAOMemory;
import com.example.tecktrove.memorydao.MemoryInitializer;
import com.example.tecktrove.memorydao.SynthesisDAOMemory;
import com.example.tecktrove.util.Money;
import com.example.tecktrove.util.Pair;
import com.example.tecktrove.util.Port;
import com.example.tecktrove.view.Customer.HomeScreen.HomeScreenPresenter;
import com.example.tecktrove.view.Customer.HomeScreen.HomeScreenViewStub;
import com.example.tecktrove.view.SharedViewModel;
import com.example.tecktrove.view.Synthesis.SynthesisPresenter;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;


public class SynthesisPresenterTest {
    private SynthesisViewStub view;
    private Initializer init;

    private SynthesisPresenter presenter;

    private SharedViewModel model;

    private ComponentDAOMemory componentDAOMemory;
    private SynthesisDAOMemory synthesisDAOMemory;

    @Before
    public void setUp(){
        init = new MemoryInitializer();
        init.prepareData();
        model = new SharedViewModel();
         componentDAOMemory = new ComponentDAOMemory();
         synthesisDAOMemory = new SynthesisDAOMemory();

        view = new SynthesisViewStub();
        presenter = new SynthesisPresenter(componentDAOMemory,synthesisDAOMemory,view,model);

        Synthesis s1 = new Synthesis();

    }

    @Test
    public void SearchProducts(){
        presenter.searchProducts("CPU");
        Assert.assertEquals(2,presenter.getSearchResults().size());

        presenter.searchProducts("motherboard");
        Assert.assertEquals(2,presenter.getSearchResults().size());

        model.getComponentsFromSynthesis().add(componentDAOMemory.find(4188));
        presenter.searchProducts("motherboard");
        Assert.assertEquals(0,presenter.getSearchResults().size());


    }

    @Test
    public void TestCompatibles(){
        Pair<String, Integer> pair7_1 = new Pair<String, Integer>("PCI Express x16 3.0",1);
        Pair<String, Integer> pair7_2 = new Pair<String, Integer>("HDMI",1);
        Pair<String, Integer> pair7_3 = new Pair<String, Integer>("DVI-D",1);

        Port port7 = new Port();
        Port port7_1 = new Port();

        port7.add(pair7_3);
        port7.add(pair7_2);
        port7_1.add(pair7_1);
        Component com7 = new Component(4311, Money.euros(BigDecimal.valueOf(69.90)), "Asus VGA GPU GeForce GT 730 Evo Low Profile BRK 2 GB", "Είναι ιδανική για υπολογιστές γραφείου, Small Form Factor (SFF) ή Home Theater PCs (HTPC). Είναι χαμηλής κατανάλωσης, με παθητική ψύξη και διαθέτει 3x εξόδους εικόνας.", "ASUS",  port7,port7_1, 28);


        Pair<String, Integer> pair15_1 = new Pair<String, Integer>("socket AM4+",1);
        Pair<String, Integer> pair15_2 = new Pair<String, Integer>("DDR5",1);
        Pair<String, Integer> pair15_3 = new Pair<String, Integer>("PCI Express x16 3.0",1);
        Pair<String, Integer> pair15_4 = new Pair<String, Integer>("M.2",1);

        Port port15 = new Port();

        port15.add(pair15_1);
        port15.add(pair15_2);
        port15.add(pair15_3);
        port15.add(pair15_4);
        Component com15 = new Component(3639, Money.euros(BigDecimal.valueOf(69.90)), "MSI Motherboard A520M-A PRO", "Βασίζεται στο AMD® A520 Chipset και δέχεται επεξεργαστές AMD Ryzen™ 5000 και 3000 Series καθώς και 4000 G-Series. Υποστηρίζει μνήμη DDR5 ως 64GB και έχει υποδοχές Μ.2 και PCI Express Gen3 x16.", "AMD", port15, new Port(), 85);


        presenter.saveToSynthesis(com7);
        presenter.saveToSynthesis(com15);
        presenter.onDisplayProducts("ram");
        Assert.assertEquals(1,presenter.getSearchResults().size());
        presenter.removeFromSynthesis(com15);
        presenter.onDisplayProducts("ram");
        Assert.assertEquals(2,presenter.getSearchResults().size());
        presenter.onSynthesisDisplay();



    }

    @Test
    public  void testTheRest(){
        presenter.onCart();
        presenter.onHome();
        presenter.onSaved();
        presenter.onMyAcount();

        Assert.assertEquals(1,view.getHome());
        Assert.assertEquals(1,view.getCart());
        Assert.assertEquals(1,view.getMyaccount());
        Assert.assertEquals(1,view.getSaved());
    }


}
