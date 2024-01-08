package com.example.tecktrove.view.Customer.Synthesis;

import com.example.tecktrove.domain.ProductType;
import com.example.tecktrove.view.Synthesis.SynthesisView;

import java.util.ArrayList;

public class SynthesisViewStub implements SynthesisView {
    private int message = 0;

    private int timesShownCategory =0;

    private int timesShowedSynthesis=0;

    private int home =0;

    private int saved = 0;

    private int Myaccount = 0;

    private int Cart =0;


    int numberOfProducts;



    @Override
    public void showErrorMessage(String title, String msg) {
        message++;
    }

    @Override
    public void displayProducts(ArrayList<ProductType> products) {
        numberOfProducts = products.size();
        timesShownCategory++;


    }

    @Override
    public void synthesisDisplay() {
        timesShowedSynthesis++;

    }

    @Override
    public void home() {
        home++;
    }

    @Override
    public void Cart() {
        Cart++;
    }

    @Override
    public void Saved() {
        saved++;
    }

    @Override
    public void MyAcount() {
        Myaccount++;
    }

    public int getSaved() {
        return saved;
    }

    public int getCart() {
        return Cart;
    }

    public int getHome() {
        return home;
    }

    public int getMyaccount() {
        return Myaccount;
    }
}
