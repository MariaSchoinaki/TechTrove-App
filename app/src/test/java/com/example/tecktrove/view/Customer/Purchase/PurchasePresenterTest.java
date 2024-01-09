package com.example.tecktrove.view.Customer.Purchase;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;

import com.example.tecktrove.contacts.Email;
import com.example.tecktrove.contacts.Telephone;
import com.example.tecktrove.dao.CustomerDAO;
import com.example.tecktrove.dao.OrderDAO;
import com.example.tecktrove.dao.Initializer;
import com.example.tecktrove.domain.Customer;
import com.example.tecktrove.domain.OrderLine;
import com.example.tecktrove.domain.Synthesis;
import com.example.tecktrove.memorydao.ComponentDAOMemory;
import com.example.tecktrove.memorydao.OrderDAOMemory;
import com.example.tecktrove.memorydao.MemoryInitializer;
import com.example.tecktrove.view.Employer.Product.AddProduct.AddProductPresenter;
import com.example.tecktrove.view.Employer.Product.AddProduct.AddProductViewStub;
import com.example.tecktrove.view.SharedViewModel;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class PurchasePresenterTest {
    private PurchaseViewStub view;
    private PurchasePresenter presenter;
    private OrderDAO orderDAO;
    private Customer customer;

    /**
     * Sets up the presenter and initializes the data
     */
    @Before
    public void setUp(){
        Initializer init = new MemoryInitializer();
        init.prepareData();

        view = new PurchaseViewStub();
        orderDAO = new OrderDAOMemory();
        customer = new Customer(5673, "george", "ok123456", "George", "Johnson", new Email("klap@yahoo.com"), new Telephone("6898909678"), new ArrayList<Synthesis>(), new ArrayList<OrderLine>());
        presenter = new PurchasePresenter(view, orderDAO, customer);
    }

    /**
     * Tests place order functionality
     */
    @Test
    public void testPlaceOrder(){
        Assert.assertEquals(0, view.getTimesShowingMessage());
        view.order();
        Assert.assertEquals(1, view.getTimesShowingMessage());

        view.setFullName("Maria Papa");
        view.setEmail("papa12@gmail.com");
        view.setTelephone("6988457815");
        view.setAddress("Patision 13");
        view.setCardNumber("1111111111111111");
        view.setCardMonth("12");
        view.setCardYear("27");
        view.setCardCvv("658");
        view.setOrderID(1234);
        presenter.placeOrder();
        Assert.assertEquals(2, view.getTimesShowingMessage());

        Assert.assertNotNull(orderDAO.find(1234));
    }
}
