package com.example.tecktrove.view.Customer.HomeScreen;

import com.example.tecktrove.domain.ProductType;

import java.util.ArrayList;

public interface HomeScreenView {

    void displayProducts(ArrayList<ProductType> products);

    void Cart();
    void goToHome();
    void goToMyAccount();

    void diySynthesis();
}
