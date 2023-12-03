package com.example.tecktrove.domain;

import android.telecom.TelecomManager;

public class Order {
    private Date date;
    private Money total;
    private int cardNumber;
    private Telephone telephone;
    private Mail email;

    public Date getDate(){
        return this.date;
    }

   public Money getTotal(){
        return this.total;
    }

   public int getCardNumber(){
        return this.cardNumber;
    }

   public Telephone getTelephone(){
        return this.telephone;
    }

    public Mail getEmail() {
        return email;
    }

    void setDate(Date date) {
        this.date = date;
    }

    void setCardNumber(int cardNumber) {
        this.cardNumber = cardNumber;
    }

    void setTelephone(Telephone telephone) {
        this.telephone = telephone;
    }

    void setEmail(Mail email) {
        this.email = email;
    }


}
