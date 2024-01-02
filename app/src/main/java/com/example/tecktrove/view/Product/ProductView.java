package com.example.tecktrove.view.Product;

import com.example.tecktrove.domain.ProductType;
import com.example.tecktrove.util.Money;
import com.example.tecktrove.util.Port;

public interface ProductView {

    void showInfo(int modelNo, Money price, String name, String description, String manufacturer, Port availablePorts, Port requiredPorts, int quantity);

    void Cart(ProductType product);

    void increaseQuantity();
    void decreaseQuantity();
    void showMessage(String title, String msg);
}
