package com.example.tecktrove.view.Employer.HomeScreen;

import com.example.tecktrove.domain.ProductType;

import java.util.ArrayList;

public interface HomeScreenView {


    void displayProducts(ArrayList<ProductType> products);

    void goToHome();

    void goToMyAccount();

    void goToAddProduct();

    void goBack();
}
