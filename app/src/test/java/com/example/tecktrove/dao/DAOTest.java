package com.example.tecktrove.dao;


import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNull;

import com.example.tecktrove.contacts.Email;
import com.example.tecktrove.contacts.Telephone;
import com.example.tecktrove.domain.Component;
import com.example.tecktrove.domain.Customer;
import com.example.tecktrove.domain.Employer;
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
    private OrderLineDAO orderLineDAO;
    private SynthesisDAO synthesisDAO;


    private static final int INITIAL_COMPONENTS_COUNT = 16;
    private static final int INITIAL_AVAILABLE_COUNT = 0;

    private static final int INITIAL_REQUIRED_COUNT = 0;
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
        orderLineDAO = new OrderLineDAO();
    }

    @Test
    public void CustomerCheckFindAll(){
        Assert.assertEquals(3, customerDAO.findAll().size());
        Assert.assertTrue(customerDAO.findAll().contains(new Customer(5673, "george", "ok123456", "George", "Johnson", new Email("klap@yahoo.com"), new Telephone("6898909678"), new ArrayList<Synthesis>(), new ArrayList<ProductType>())));
    }

    @Test
    public void CustomerCheckFindByUsernameAndPassword(){
        Assert.assertEquals("Maria", customerDAO.findCustomerByUsernameAndPassword("maria5", "31m@ria5").getName());
        Assert.assertNull(customerDAO.findCustomerByUsernameAndPassword("abcd","ljhg7yhb"));
        Assert.assertEquals(new Customer(2598, "chris", "chr!s598", "Christos", "Papaioanou", new Email("papaio54@gmail.com"), new Telephone("6985369825"), new ArrayList<Synthesis>(), new ArrayList<ProductType>()), customerDAO.findCustomerByUsernameAndPassword("chris","chr!s598"));
    }

    @Test
    public void CustomerCheckFindById(){
        Assert.assertEquals(new Customer(2598, "chris", "chr!s598", "Christos", "Papaioanou", new Email("papaio54@gmail.com"), new Telephone("6985369825"), new ArrayList<Synthesis>(), new ArrayList<ProductType>()), customerDAO.findCustomerByID(2598));
        Assert.assertNull(customerDAO.findCustomerByID(4));
    }

    @Test
    public void CustomerCheckSave(){
        customerDAO.save(new Customer(34, "leon", "leon2001", "leonidas","fragkias", new Email("leon@gmail.com"), new Telephone("6972342376"), new ArrayList<Synthesis>(),new ArrayList<ProductType>()));
        Assert.assertEquals(4, customerDAO.findAll().size());
    }

    @Test
    public void CustomerCheckDelete(){
        customerDAO.delete(new Customer(7859, "maria5", "31m@ria5", "Maria", "Papadaki", new Email("papadaki27@gmail.com"), new Telephone("6984596936"), new ArrayList<Synthesis>(), new ArrayList<ProductType>()));
        Assert.assertEquals(2, customerDAO.findAll().size());
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
        Port p = new Port();
        Assert.assertEquals(new ArrayList<Component>(),componentDAO.findAllByRequiredPorts(p));
    }

    @Test
    public void findNonExistingAvailablePorts(){
        Port p = new Port();
        Assert.assertEquals(new ArrayList<Component>(),componentDAO.findAllByAvailablePorts(p));
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
        Synthesis s1 = new Synthesis(235456, Money.euros(1500), "Best Synthesis", new ArrayList<Component>());
        synthesisDAO.save(s1);
        Assert.assertEquals(INITIAL_SYNTHESIS_COUNT+1,synthesisDAO.findAll().size());
        Assert.assertNotNull(synthesisDAO.find(235456));
        Assert.assertNotNull(synthesisDAO.find("Best Synthesis"));
        Assert.assertTrue(synthesisDAO.findAll().contains(s1));
    }

    @Test
    public void testAvailablePorts(){

        Pair p = new Pair("HDMI",1);
        Port port = new Port();
        port.add(p);

        ArrayList<Component> components = componentDAO.findAllByAvailablePorts(port);
        Assert.assertEquals(INITIAL_AVAILABLE_COUNT,components.size());
    }

    @Test
    public void testRequiredPorts(){

        Pair p = new Pair("HDMI",1);
        Port port = new Port();
        port.add(p);

        ArrayList<Component> components = componentDAO.findAllByRequiredPorts(port);
        Assert.assertEquals(INITIAL_REQUIRED_COUNT,components.size());

    }

    @Test
    public void testDeleteByRequiredPorts(){
        Pair p = new Pair("HDMI",1);
        Port port = new Port();
        port.add(p);

        componentDAO.deleteByRequiredPorts(port);
        Assert.assertEquals(0,componentDAO.findAllByRequiredPorts(port).size());

    }

    @Test
    public void testDeleteByAvailablePorts(){
        Pair p = new Pair("HDMI",1);
        Port port = new Port();
        port.add(p);

        componentDAO.deleteByAvailablePorts(port);
        Assert.assertEquals(0,componentDAO.findAllByAvailablePorts(port).size());
    }

    @Test
    public void testDeleteByManufacturer(){
        componentDAO.deleteByManufacturer("Sharkoon");
        Assert.assertEquals(0,componentDAO.findByManufacturer("Sharkoon").size());

    }

    @Test
    public void ComponentDelete(){
        componentDAO.delete(new Component());
        componentDAO.delete("Turbo-X PSU Value III Series 550 W");
        componentDAO.delete(4191);
    }

    @Test
    public void SynthesisDelete(){
            synthesisDAO.delete(new Synthesis());
            synthesisDAO.delete("Synthesis1");
            synthesisDAO.delete(9485);
    }
}
