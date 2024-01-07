package com.example.tecktrove.view.Customer.Purchase;

import com.example.tecktrove.domain.Customer;
public interface PurchaseView {

    /**
     * Stores and presents the order details
     *
     * @param customer
     */
    void placeOrder(Customer customer);

    /**
     * Gets the full name
     *
     * @return the full name as a String
     */
    String getFullName();

    /**
     * Gets the email
     *
     * @return the email as a String
     */
    String getEmail();

    /**
     * Gets the telephone
     *
     * @return the telephone as a String
     */
    String getTelephone();

    /**
     * Gets the address
     *
     * @return the address as a String
     */
    String getAddress();

    /**
     * Gets the card number
     *
     * @return the card number as a String
     */
    String getCardNumber();

    /**
     * Gets the month a card expires
     *
     * @return the month a card expires as a String
     */
    String getCardMonth();

    /**
     * Gets the year a card expires
     *
     * @return the year a card expires as a String
     */
    String getCardYear();

    /**
     * Gets the cvv of a card
     *
     * @return the cvv of a card as a String
     */
    String getCardCvv();

    /**
     * Shows a pop up window with a customized message
     *
     * @param title the title of the window
     * @param msg   the text of the window
     */
    void showMessage(String title, String msg);
}
