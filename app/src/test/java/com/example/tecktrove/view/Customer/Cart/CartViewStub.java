package com.example.tecktrove.view.Customer.Cart;

import com.example.tecktrove.util.Money;

import java.math.BigDecimal;
import java.util.Currency;

public class CartViewStub implements CartView {
    int onHome=0;
    int onCart=0;
    int onSaved = 0;
    int purchase =0;
    int onMyacount =0;
    Money Total;


    @Override
    public void home() {
        onHome++;
    }

    @Override
    public void cart() {
        onCart++;

    }

    @Override
    public void ShowTotal() {
        //Money calcTotal= new Money(BigDecimal.TEN, Money.euros("EUR"));
        //this.Total= calcTotal;
    }

    @Override
    public void Purchase() {
        purchase++;
    }

    @Override
    public void Saved() {
        onSaved++;
    }

    @Override
    public void Myacount() {
        onMyacount++;
    }

    public int getOnCart() {
        return onCart;
    }

    public int getOnHome(){
        return onHome;
    }

    public int getOnMyacount() {
        return onMyacount;
    }

    public int getOnSaved() {
        return onSaved;
    }

    public int getPurchase() {
        return purchase;
    }
}
