package com.example.tecktrove.view.Employer.Product.AddProduct;

public interface AddProductView {

    void goToHomeScreen();

    void showMessage(String title, String msg);

    String getName();
    String getPrice();
    String getManufacturer();
    String getDescription();
    String getModelNo();
    String getAvailablePorts();
    String getRequiredPorts();
    int getQuantity();
}
