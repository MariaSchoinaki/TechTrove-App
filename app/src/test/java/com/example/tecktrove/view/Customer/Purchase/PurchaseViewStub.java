package com.example.tecktrove.view.Customer.Purchase;

public class PurchaseViewStub implements PurchaseView {

    private int timesShowingMessage = 0;
    private String fullname, email, telephone, address, card_number, card_month, card_year, card_cvv;
    private int id;

    @Override
    public void order() {
        timesShowingMessage++;
    }

    @Override
    public void showMessage(String title, String msg) {
        timesShowingMessage++;
    }

    @Override
    public String getFullName() { return fullname; }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public String getTelephone() {
        return telephone;
    }

    @Override
    public String getAddress() {
        return address;
    }

    @Override
    public String getCardNumber() {
        return card_number;
    }

    @Override
    public String getCardMonth() {
        return card_month;
    }

    @Override
    public String getCardYear() {
        return card_year;
    }

    @Override
    public String getCardCvv() {
        return card_cvv;
    }

    public int getTimesShowingMessage() {
        return timesShowingMessage;
    }

    public void setFullName(String name){ this.fullname = name;}

    public void setEmail(String email) { this.email = email; }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCardNumber(String card_number) {
        this.card_number = card_number;
    }

    public void setCardMonth(String month) {
        this.card_month = month;
    }

    public void setCardYear(String year) {
        this.card_year = year;
    }

    public void setCardCvv(String cvv) {
        this.card_cvv = cvv;
    }

    public void setOrderID(int id) { this.id = id;}
}
