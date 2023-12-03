package com.example.tecktrove.domain;

import android.telecom.TelecomManager;

import com.example.tecktrove.contacts.Telephone;

import java.util.ArrayList;

public class Order {
    private Date date;
    private Money total;
    private int cardNumber;
    private Telephone telephone;
    private Mail email;
    private ArrayList<OrderLine> orderLines;
    public Order(){}

    /**
     * Constructor of Order
     *
     * @param date         the date that order was placed as Date type
     * @param total        the total customer charge as Money type
     * @param cardNumber   the card number of user as Integer
     * @param telephone    the telephone number of the user as telephone number form
     * @param email        the email address of the user as email Mail type
     * @param orderLines   the elements of each order
     */

    public Order(Date date, Money total, int cardNumber, Telephone telephone, Mail email, ArrayList<OrderLine>orderLines){
        this.date=date;
        this.total=total;
        this.cardNumber=cardNumber;
        this.telephone=telephone;
        this.orderLines=orderLines;
    }

    /**
     * Gets the date of the order's placement
     *
     * @return the placement date
     */
    public Date getDate(){
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
    public Mail getEmail() {
        return email;
    }
    /**
     * Sets the date of order's placement
     *
     * @param date the date that the order was placed
     */
    void setDate(Date date) {
        this.date = date;
    }
    /**
     * Sets the card number of the order's customer
     *
     * @param cardNumber the customer's card number
     */
    void setCardNumber(int cardNumber) {
        this.cardNumber = cardNumber;
    }
    /**
     * Sets the telephone  number of the order's customer
     *
     * @param telephone the customer's telephone number
     */
    void setTelephone(Telephone telephone) {
        this.telephone = telephone;
    }
    /**
     * Sets the email address of the order's customer
     *
     * @param email the customer's email address
     */
    void setEmail(Mail email) {
        this.email = email;
    }
    /**
     * Sets the order line list of the order
     *
     * @param  orderLines the items of each order
     */
    public void setOrderLines(ArrayList<OrderLine> orderLines) {
        this.orderLines = orderLines;
    }
}
