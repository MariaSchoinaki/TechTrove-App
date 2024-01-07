package com.example.tecktrove.view.Customer.Purchase;

import com.example.tecktrove.contacts.Email;
import com.example.tecktrove.contacts.Telephone;
import com.example.tecktrove.dao.OrderDAO;
import com.example.tecktrove.dao.CustomerDAO;
import com.example.tecktrove.domain.Order;
import com.example.tecktrove.domain.Customer;
import com.example.tecktrove.domain.Employer;
import com.example.tecktrove.domain.OrderLine;
import com.example.tecktrove.domain.ProductType;
import com.example.tecktrove.domain.Synthesis;
import com.example.tecktrove.util.Pair;
import com.example.tecktrove.util.SimpleCalendar;
import com.example.tecktrove.view.SharedViewModel;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class PurchasePresenter {

    private PurchaseView view;

    private OrderDAO orders;

    private CustomerDAO customers;

    /**
     * Constructor of the presenter
     * @param view          purchase view
     * @param orders        order dao
     * @param customers     customer dao
     */
    public PurchasePresenter(PurchaseView view, OrderDAO orders, CustomerDAO customers){
        this.view = view;
        this.orders = orders;
        this.customers = customers;
    }

    /**
     * Checks if the given from the user values, are following
     * some of the basic rules, such as the card number must be 16 digits
     */
    public void placeOrder(){
        String fullname = view.getFullName();
        String email = view.getEmail();
        String telephone = view.getTelephone();
        String address = view.getAddress();
        String cardNumber = view.getCardNumber();
        String cardMonth = view.getCardMonth();
        String cardYear = view.getCardYear();
        String cardCvv = view.getCardCvv();

        if(fullname.equals("") || email.equals("") || telephone.equals("") || address.equals("") || cardNumber.equals("") || cardMonth.equals("") || cardYear.equals("") || cardCvv.equals("")) {
            view.showMessage("Error", "Please fill all the fields.");
        }
        else if(!(email.contains("@") && (email.contains(".com") || email.contains(".gr")))){
            view.showMessage("Error", "Please write a valid email.");
        }
        else if(telephone.length() != 10){
            view.showMessage("Error", "Please write a valid phone number.");
        }
        boolean is_digit = true;
        for (int i = 0; i < cardNumber.length(); i++)
            if (!Character.isDigit(cardNumber.charAt(i))) is_digit = false;

        if(cardNumber.length() != 16 || !is_digit){
            view.showMessage("Error", "Please write a valid card number.");
        }

        for (int i = 0; i < cardMonth.length(); i++)
            if (!Character.isDigit(cardMonth.charAt(i))) is_digit = false;

        if(cardMonth.length() != 2 || !is_digit){
            view.showMessage("Error", "Please write a valid card month.");
        }

        for (int i = 0; i < cardYear.length(); i++)
            if (!Character.isDigit(cardYear.charAt(i))) is_digit = false;

        if(cardYear.length() != 4 || !is_digit){
            view.showMessage("Error", "Please write a valid card year.");
        }

        for (int i = 0; i < cardCvv.length(); i++)
            if (!Character.isDigit(cardCvv.charAt(i))) is_digit = false;

        if(cardCvv.length() != 3 || !is_digit){
            view.showMessage("Error", "Please write a valid card cvv.");
        }

        SharedViewModel sharedViewModel = new SharedViewModel();
        Customer customer = sharedViewModel.getCustomer();


        //LocalDateTime now = LocalDateTime.now();
        //Order order = new Order(new SimpleCalendar(2023, 12, 12), cardNumber, telephone, email, ArrayList< OrderLine > orderLines)
        //orders.save(order);
        //view.placeOrder(customer);
    }
}
