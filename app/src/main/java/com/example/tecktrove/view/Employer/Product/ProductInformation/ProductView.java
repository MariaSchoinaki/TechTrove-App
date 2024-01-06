package com.example.tecktrove.view.Employer.Product.ProductInformation;

import com.example.tecktrove.domain.Component;
import com.example.tecktrove.domain.ProductType;
import com.example.tecktrove.util.Money;
import com.example.tecktrove.util.Port;

import java.util.ArrayList;

public interface ProductView {

    void showProductInfo(int modelNo, Money price, String name, String description, String manufacturer, Port availablePorts, Port requiredPorts, int quantity);

    void showSynthesisInfo(int modelNo,String name, String price, ArrayList<Component> components);

    void ChangeComponentInfo(Component component);

    int getQuantity();
    void showMessage(String title, String msg);

    String getName();
    String getPrice();
    String getManufacturer();
    String getDescription();
    String getModelNo();
    String getAvailablePorts();
    String getRequiredPorts();
}
