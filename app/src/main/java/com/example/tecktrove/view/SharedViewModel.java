package com.example.tecktrove.view;

import androidx.lifecycle.ViewModel;

import com.example.tecktrove.domain.Component;
import com.example.tecktrove.domain.Customer;
import com.example.tecktrove.domain.Employer;
import com.example.tecktrove.domain.Order;
import com.example.tecktrove.domain.ProductType;
import com.example.tecktrove.domain.Synthesis;

import java.net.CookieManager;
import java.util.ArrayList;

public class SharedViewModel extends ViewModel {
    private static Customer customer;
    private static boolean isEmployer;
    private static Employer employer;

    private static Order order;

    private static Synthesis synthesis;

    public Customer getCustomer() {
        return customer;
    }

    public void setSharedCustomer(Customer customer) {
        this.customer = customer;
    }

    public boolean isEmployer(){
        return isEmployer;
    }

    public void setSharedEmployer(Employer employer){ this.employer = employer;}

    public Employer getEmployer(){return this.employer;}
    public void setIsEmployer(boolean isEmployer){this.isEmployer = isEmployer;}
    public void clear(){
        customer = null;
        employer = null;
        isEmployer = false;
        synthesis = null;
    }

    public void setSharedSynthesis(Synthesis synthesiss){
        synthesis=synthesiss;
    }
    public ArrayList<Component> getComponentsFromSynthesis() {
        return synthesis.getComponentList();
    }

    public static void setOrder(Order order) {
        SharedViewModel.order = order;
    }

    public static Order getOrder(){
        return order;
    }

    public static Synthesis getSynthesis() {
        return synthesis;
    }
}
