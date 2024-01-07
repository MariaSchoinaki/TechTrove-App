package com.example.tecktrove.dao;


import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import com.example.tecktrove.contacts.Email;
import com.example.tecktrove.contacts.Telephone;
import com.example.tecktrove.domain.Component;
import com.example.tecktrove.domain.Customer;
import com.example.tecktrove.domain.Employer;
import com.example.tecktrove.domain.OrderLine;
import com.example.tecktrove.domain.ProductType;
import com.example.tecktrove.domain.Synthesis;
import com.example.tecktrove.memorydao.ComponentDAOMemory;
import com.example.tecktrove.memorydao.CustomerDAOMemory;
import com.example.tecktrove.memorydao.EmployerDAOMemory;
import com.example.tecktrove.memorydao.ItemDAOMemory;
import com.example.tecktrove.memorydao.MemoryInitializer;
import com.example.tecktrove.memorydao.OrderDAOMemory;
import com.example.tecktrove.memorydao.SynthesisDAOMemory;
import com.example.tecktrove.util.Money;
import com.example.tecktrove.util.Pair;
import com.example.tecktrove.util.Port;
import com.example.tecktrove.dao.Initializer;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Currency;

public class DAOTest {

    private ComponentDAO componentDAO;
    private CustomerDAO customerDAO;
    private EmployerDAO employerDAO;
    private ItemDAO itemDAO;
    private OrderDAO orderDAO;
    private SynthesisDAO synthesisDAO;


    private static final int INITIAL_COMPONENTS_COUNT = 16;
    private static  int INITIAL_AVAILABLE_COUNT = 1;

    private static final int INITIAL_REQUIRED_COUNT = 2;
    private static final int INITIAL_SYNTHESIS_COUNT = 2;

    @Before
    public void setUp() {
        Initializer dataHelper = new MemoryInitializer();
        dataHelper.prepareData();

        componentDAO = new ComponentDAOMemory();
        synthesisDAO = new SynthesisDAOMemory();
        itemDAO = new ItemDAOMemory();

        employerDAO = new EmployerDAOMemory();
        customerDAO = new CustomerDAOMemory();

        orderDAO = new OrderDAOMemory();
    }

    @Test
    public void CustomerCheckFindAll(){
        Assert.assertEquals(3, customerDAO.findAll().size());
        Assert.assertTrue(customerDAO.findAll().contains(new Customer(5673, "george", "ok123456", "George", "Johnson", new Email("klap@yahoo.com"), new Telephone("6898909678"), new ArrayList<Synthesis>(), new ArrayList<OrderLine>())));
    }

    @Test
    public void CustomerCheckFindByUsernameAndPassword(){
        Assert.assertEquals("Maria", customerDAO.findCustomerByUsernameAndPassword("maria5", "31m@ria5").getName());
        Assert.assertNull(customerDAO.findCustomerByUsernameAndPassword("abcd","ljhg7yhb"));
        Assert.assertEquals(new Customer(2598, "chris", "chr!s598", "Christos", "Papaioanou", new Email("papaio54@gmail.com"), new Telephone("6985369825"), new ArrayList<Synthesis>(), new ArrayList<OrderLine>()), customerDAO.findCustomerByUsernameAndPassword("chris","chr!s598"));
    }

    @Test
    public void CustomerCheckFindById(){
        Assert.assertEquals(new Customer(2598, "chris", "chr!s598", "Christos", "Papaioanou", new Email("papaio54@gmail.com"), new Telephone("6985369825"), new ArrayList<Synthesis>(), new ArrayList<OrderLine>()), customerDAO.findCustomerByID(2598));
        Assert.assertNull(customerDAO.findCustomerByID(4));
    }

    @Test
    public void CustomerCheckSave(){
        customerDAO.save(new Customer(34, "leon", "leon2001", "leonidas","fragkias", new Email("leon@gmail.com"), new Telephone("6972342376"), new ArrayList<Synthesis>(),new ArrayList<OrderLine>()));
        Assert.assertEquals(4, customerDAO.findAll().size());
    }

    @Test
    public void CustomerCheckDelete(){
        customerDAO.delete(new Customer(7859, "maria5", "31m@ria5", "Maria", "Papadaki", new Email("papadaki27@gmail.com"), new Telephone("6984596936"), new ArrayList<Synthesis>(), new ArrayList<OrderLine>()));
        Assert.assertEquals(2, customerDAO.findAll().size());
    }

    @Test
    public void CustomerCheckNextId(){
        Assert.assertEquals(2599,customerDAO.nextId());
    }

    @Test
    public void EmployerCheckFindAll(){
        Assert.assertEquals(3, employerDAO.findAll().size());
        Assert.assertTrue(employerDAO.findAll().contains(new Employer(1252, "eleni3", "elen!562", "Eleni", "Georgali", new Email("eleniii2@gmail.com"), new Telephone("6988745961"))));
    }

    @Test
    public void EmployerCheckFindByUsernameAndPassword(){
        Assert.assertEquals("Konstantinos", employerDAO.findEmployerByUsernameAndPassword("kostas34", "13k023m32").getName());
        Assert.assertNull(employerDAO.findEmployerByUsernameAndPassword("abcd","ljhg7yhb"));
        Assert.assertEquals(new Employer(5698, "faihh1", "faihskoni1", "Foteini", "Soultatou", new Email("apple3r@yahoo.com"), new Telephone("6978451236")), employerDAO.findEmployerByUsernameAndPassword("faihh1","faihskoni1"));
    }

    @Test
    public void EmployerCheckFindByUsername(){
        Assert.assertNull(employerDAO.findEmployerByUsername("yolo"));
        Assert.assertNotNull(employerDAO.findEmployerByUsername("eleni3"));
    }

    @Test
    public void EmployerCheckNextId(){
        Assert.assertEquals(8597,employerDAO.nextId());
    }

    @Test
    public void EmployerCheckFindById(){
        Assert.assertEquals(new Employer(8596, "kostas34", "13k023m32", "Konstantinos", "Glitsas", new Email("glitsas13@gmail.com"), new Telephone("6945259875")), employerDAO.findEmployerByID(8596));
        Assert.assertNull(employerDAO.findEmployerByID(0));
    }

    @Test
    public void EmployerCheckSave(){
        employerDAO.save(new Employer(34, "ippo", "ippo1999", "Ippokratis","Morfonios", new Email("ippomorf@gmail.com"), new Telephone("6972247306")));
        Assert.assertEquals(4, employerDAO.findAll().size());
    }

    @Test
    public void EmployerCheckDelete(){
        employerDAO.delete(new Employer(8596, "kostas34", "13k023m32", "Konstantinos", "Glitsas", new Email("glitsas13@gmail.com"), new Telephone("6945259875")));
        Assert.assertEquals(2, employerDAO.findAll().size());
        employerDAO.delete(new Employer());
        Assert.assertEquals(2, employerDAO.findAll().size());
    }

    @Test
    public void findNonExistingModelNo(){
        Assert.assertNull(componentDAO.find(123456));
        Assert.assertNull(synthesisDAO.find(342156));
    }

    @Test
    public void findNonExistingName(){
        Assert.assertNull(componentDAO.find("somalia"));
        Assert.assertNull(synthesisDAO.find("izola"));
    }

    @Test
    public void findNonExistingManufacturer(){
        Assert.assertEquals(new ArrayList<Component>(),componentDAO.findByManufacturer("Lola"));
    }

    @Test
    public void findNonExistingRequiredPorts(){
        Pair p = new Pair("HDMI535",1);
        Port port = new Port();
        port.add(p);
        Assert.assertEquals(new ArrayList<Component>(),componentDAO.findAllByRequiredPorts(port));
    }

    @Test
    public void findNonExistingAvailablePorts(){
        Pair p = new Pair("HDMI535",1);
        Port port = new Port();
        port.add(p);
        Assert.assertEquals(new ArrayList<Component>(),componentDAO.findAllByAvailablePorts(port));
    }

    @Test
    public void listAllComponents(){
        ArrayList<Component> allComponents = componentDAO.findAll();
        Assert.assertEquals(INITIAL_COMPONENTS_COUNT, allComponents.size());
    }

    @Test
    public void testSaveComponents(){
        Component component = new Component(12,new Money(BigDecimal.valueOf(123), Currency.getInstance("EUR")),"display","very good","SAMSUNG ELECTRONICS CO&LTD",new Port(),new Port(),13);
        componentDAO.save(component);
        Assert.assertEquals(INITIAL_COMPONENTS_COUNT+1,componentDAO.findAll().size());
        Assert.assertNotNull(componentDAO.find(12));
        Assert.assertNotNull(componentDAO.find("display"));
        Assert.assertTrue(componentDAO.findAll().contains(component));
    }

    @Test
    public void findNonExistingRating(){
        Assert.assertEquals(new ArrayList<Synthesis>(),synthesisDAO.findAllByRating(12.2));
    }

    @Test
    public void findNonExistingNumberOfRatings(){
        Assert.assertEquals(new ArrayList<Synthesis>(),synthesisDAO.findAllByNumberOfRatings(5));
    }

    @Test
    public void testSaveSynthesis(){
        Synthesis s1 = new Synthesis(235456, Money.euros(1500), "Best Synthesis");
        synthesisDAO.save(s1);
        Assert.assertEquals(INITIAL_SYNTHESIS_COUNT+1,synthesisDAO.findAll().size());
        Assert.assertNotNull(synthesisDAO.find(235456));
        Assert.assertNotNull(synthesisDAO.find("Best Synthesis"));
        Assert.assertTrue(synthesisDAO.findAll().contains(s1));
    }
    @Test
    public void findSynthesis(){
        Synthesis s3 = new Synthesis();
        s3.setSubRating(5.0,new Customer());
        s3.setSubRating(5.0,new Customer());
        synthesisDAO.save(s3);
        Assert.assertEquals(1,synthesisDAO.findAllByRating(5.0).size());
        Assert.assertEquals(1,synthesisDAO.findAllByNumberOfRatings(2).size());
        synthesisDAO.deleteAllByRating(5.0);
        Assert.assertEquals("Synthesis1",synthesisDAO.find("Synthesis1").getName());
        Assert.assertEquals(9787,synthesisDAO.find(9787).getModelNo());

        Assert.assertEquals(2, synthesisDAO.findAllPublished().size());
    }
    @Test
    public void testAvailablePorts(){


        Pair pair2_1 = new Pair("ATX Power Port",1);
        Pair pair2_2 = new Pair("ATX 12V Power Port",1);
        Pair pair2_3 = new Pair("SATA Power Port",2);
        Pair pair2_4 = new Pair("Molex Connector",1);
        Pair pair2_5 = new Pair("PCI Express Connector",1);
        Pair pair2_6 = new Pair("PCI Floppy Drive Connector",1);



        Port port2 = new Port();
        port2.add(pair2_1);
        port2.add(pair2_2);
        port2.add(pair2_3);
        port2.add(pair2_4);
        port2.add(pair2_5);
        port2.add(pair2_6);
        Assert.assertEquals(INITIAL_AVAILABLE_COUNT,componentDAO.findAllByAvailablePorts(port2).size());
    }

    @Test
    public void testRequiredPorts(){

        Pair pair7_1 = new Pair("PCI Express x16 2.0",1);
        Port port = new Port();
        port.add(pair7_1);

        ArrayList<Component> components = componentDAO.findAllByRequiredPorts(port);
        Assert.assertEquals(INITIAL_REQUIRED_COUNT,components.size());

    }

    @Test
    public void testDeleteByRequiredPorts(){
        Pair p = new Pair("PCI Express x16 2.0",1);
        Port port = new Port();
        port.add(p);

        componentDAO.deleteByRequiredPorts(port);
        Assert.assertEquals(0,componentDAO.findAllByRequiredPorts(port).size());
        Assert.assertEquals(INITIAL_COMPONENTS_COUNT-2,componentDAO.findAll().size());

    }

    @Test
    public void testDeleteByAvailablePorts(){

        Pair pair2_1 = new Pair("ATX Power Port",1);
        Pair pair2_2 = new Pair("ATX 12V Power Port",1);
        Pair pair2_3 = new Pair("SATA Power Port",2);
        Pair pair2_4 = new Pair("Molex Connector",1);
        Pair pair2_5 = new Pair("PCI Express Connector",1);
        Pair pair2_6 = new Pair("PCI Floppy Drive Connector",1);



        Port port2 = new Port();
        port2.add(pair2_1);
        port2.add(pair2_2);
        port2.add(pair2_3);
        port2.add(pair2_4);
        port2.add(pair2_5);
        port2.add(pair2_6);
        componentDAO.deleteByAvailablePorts(port2);
        Assert.assertEquals(0,componentDAO.findAllByAvailablePorts(port2).size());
        Assert.assertEquals(INITIAL_COMPONENTS_COUNT-1,componentDAO.findAll().size());
    }

    @Test
    public void testDeleteByManufacturer(){
        Assert.assertEquals(2,componentDAO.findByManufacturer("Sharkoon").size());
        componentDAO.deleteByManufacturer("Sharkoon");
        Assert.assertEquals(0,componentDAO.findByManufacturer("Sharkoon").size());
        Assert.assertEquals(INITIAL_COMPONENTS_COUNT-2,componentDAO.findAll().size());

    }

    @Test
    public void ComponentDelete(){
        Component com1 = new Component();
        componentDAO.save(com1);
        Assert.assertEquals(INITIAL_COMPONENTS_COUNT+1,componentDAO.findAll().size());
        componentDAO.delete(com1);
        Assert.assertEquals(INITIAL_COMPONENTS_COUNT,componentDAO.findAll().size());
        componentDAO.delete("Turbo-X PSU Value III Series 550 W");
        Assert.assertEquals(INITIAL_COMPONENTS_COUNT-1,componentDAO.findAll().size());
        componentDAO.delete(4191);
        Assert.assertEquals(INITIAL_COMPONENTS_COUNT-2,componentDAO.findAll().size());
    }

    @Test
    public void SynthesisDeleteAndSave(){
        Synthesis s1 = new Synthesis();
        synthesisDAO.save(s1);
        Assert.assertEquals(INITIAL_SYNTHESIS_COUNT+1,synthesisDAO.findAll().size());
        synthesisDAO.delete(s1);

        Assert.assertEquals(INITIAL_SYNTHESIS_COUNT,synthesisDAO.findAll().size());
        Synthesis s2 = new Synthesis();
        s2.setNumberOfRatings(2);
        synthesisDAO.save(s2);
        Assert.assertEquals(1,synthesisDAO.findAllByNumberOfRatings(2).size());
        synthesisDAO.deleteAllByNumberOfRatings(2);
        Assert.assertEquals(0,synthesisDAO.findAllByNumberOfRatings(2).size());
        Assert.assertEquals(INITIAL_SYNTHESIS_COUNT,synthesisDAO.findAll().size());

        Synthesis s3 = new Synthesis();
        s3.setSubRating(5.0,new Customer());
        s3.setSubRating(5.0,new Customer());
        synthesisDAO.save(s3);
        Assert.assertEquals(1,synthesisDAO.findAllByRating(5.0).size());
        synthesisDAO.deleteAllByRating(5.0);
        Assert.assertEquals(0,synthesisDAO.findAllByRating(5.0).size());
        Assert.assertEquals(INITIAL_SYNTHESIS_COUNT,synthesisDAO.findAll().size());

        synthesisDAO.delete("Synthesis1");
        Assert.assertEquals(INITIAL_SYNTHESIS_COUNT-1,synthesisDAO.findAll().size());
        synthesisDAO.delete(9485);
        Assert.assertEquals(INITIAL_SYNTHESIS_COUNT-2,synthesisDAO.findAll().size());
    }
}
