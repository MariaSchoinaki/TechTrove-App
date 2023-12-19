package com.example.tecktrove.domain;

import com.example.tecktrove.contacts.Telephone;
import com.example.tecktrove.contacts.Email;
import java.util.Date;
import com.example.tecktrove.util.Money;
import com.example.tecktrove.util.SystemDate;
import com.example.tecktrove.util.SimpleCalendar;

import java.util.ArrayList;

public class Order {
    private SimpleCalendar date;
    private Money total;
    private int cardNumber;
    private Telephone telephone;
    private Email email;
    private ArrayList<OrderLine> orderLines;
    private Customer customer;
    private int id;
    public Order(){}

    /**
     * Constructor of Order
     *
     * @param date         the date that order was placed as Date type
     * @param cardNumber   the card number of user as Integer
     * @param telephone    the telephone number of the user as telephone number form
     * @param email        the email address of the user as email Mail type
     * @param orderLines   the elements of each order
     */
    public Order(SimpleCalendar date, int cardNumber, Telephone telephone, Email email, ArrayList<OrderLine>orderLines){
        this.date=date;
        this.cardNumber=cardNumber;
        this.telephone=telephone;
        this.orderLines=orderLines;
        this.email=email;
        setTotal();
    }

    /**
     * Gets the date of the order's placement
     *
     * @return the placement date
     */
    public SimpleCalendar getDate(){
        return this.date;
    }

    /**
     * Gets the final price of the order that user has to pay
     *
     * @return the total
     */
    public Money getTotal(){
        return this.total;
    }

    /**
     * Gets the card number associated with the customer that placed the order
     *
     * @return the cardNumber
     */
    public int getCardNumber(){
        return this.cardNumber;
    }

    /**
     * Gets the telephone number associated with the customer that placed the order
     *
     * @return the telephoneNumber
     */
    public Telephone getTelephone(){
        return this.telephone;
    }

    /**
     * Gets the email address associated with the customer that placed the order
     *
     * @return the email
     */
    public Email getEmail() {
        return this.email;
    }

    /**
     * Gets the list of products that an order has
     *
     * @return the oerderlines
     */
    public ArrayList<OrderLine> getOrderLines() {
        return this.orderLines;
    }

    /**
     * Sets the date of order's placement
     *
     * @param date the date that the order was placed
     */
    public void setDate(SimpleCalendar date) {
        this.date = date;
    }

    /**
     * Sets the card number of the order's customer
     *
     * @param cardNumber the customer's card number
     */
    public void setCardNumber(int cardNumber) {
        this.cardNumber = cardNumber;
    }

    /**
     * Sets the telephone  number of the order's customer
     *
     * @param telephone the customer's telephone number
     */
    public void setTelephone(Telephone telephone) {
        this.telephone = telephone;
    }

    /**
     * Sets the email address of the order's customer
     *
     * @param email the customer's email address
     */
    public void setEmail(Email email) {
        this.email = email;
    }

    /**
     * Sets the order line list of the order
     *
     * @param  orderLines the items of each order
     */
    public void setOrderLines(ArrayList<OrderLine> orderLines) {
        this.orderLines = orderLines;
        setTotal();
    }

    /**
     * Sets total price for each order
     */
    private void setTotal(){
        this.total = Money.euros(0);
        for (OrderLine o: this.orderLines){
            this.total = this.total.plus(o.getSubTotal());
        }
    }

     public void addOrderLine(OrderLine orderLine) {
        this.orderLines.add(orderLine);
        setTotal();
     }

     public void removeOrderline(OrderLine orderLine){
        this.orderLines.remove(orderLine);
        setTotal();
     }

     public void setCustomer(Customer customer){
        this.customer = customer;
     }

     public Customer getCustomer(){
        return this.customer;
     }

     public void setId(int id){ this.id = id;}
     public int getId(){ return this.id; }
}
