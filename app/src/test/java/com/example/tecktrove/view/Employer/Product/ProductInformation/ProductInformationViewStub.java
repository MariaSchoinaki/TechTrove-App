package com.example.tecktrove.view.Employer.Product.ProductInformation;

import com.example.tecktrove.domain.Component;
import com.example.tecktrove.util.Money;
import com.example.tecktrove.util.Port;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class ProductInformationViewStub implements ProductView{

    private int timesShowInfoOfProduct = 0;
    private int quantity;
    private int timesShowInfoOfSynthesi = 0;
    private int timesExited = 0;
    private int timesShowingMessage = 0;
    private int modelNo;
    private String name, description, manufacturer;
    private Port availablePorts, requiredPorts;
    private Money price;
    private double rating;

    @Override
    public void showProductInfo(int modelNo, Money price, String name, String description, String manufacturer, Port availablePorts, Port requiredPorts, int quantity) {
        timesShowInfoOfProduct++;
        this.quantity = quantity;
        this.name = name;
        this.modelNo = modelNo;
        this.description = description;
        this.manufacturer = manufacturer;
        this.availablePorts = availablePorts;
        this.requiredPorts = requiredPorts;
        this.price = price;
    }

    @Override
    public void showSynthesisInfo(int modelNo, String name, String price, ArrayList<Component> components, double rating) {
        timesShowInfoOfSynthesi++;
        this.modelNo = modelNo;
        this.name = name;
        this.price = Money.euros(new BigDecimal(Double.valueOf(price.replace("€", "").trim())));
        this.rating = rating;
    }

    @Override
    public void ChangeComponentInfo(Component component) {

    }

    @Override
    public void onExit() {
        timesExited++;
    }

    @Override
    public int getQuantity() {
        return quantity;
    }

    @Override
    public void showMessage(String title, String msg) {
        timesShowingMessage++;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getPrice() {
        return price.toString();
    }

    @Override
    public String getManufacturer() {
        return manufacturer;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public String getModelNo() {
        return String.valueOf(modelNo);
    }

    @Override
    public String getAvailablePorts() {
        return availablePorts.getPorts().stream().map(Object::toString).collect(Collectors.joining(", "));
    }

    @Override
    public String getRequiredPorts() {
        return requiredPorts.getPorts().stream().map(Object::toString).collect(Collectors.joining(", "));
    }

    public int getTimesExited() {
        return timesExited;
    }

    public int getTimesShowingMessage() {
        return timesShowingMessage;
    }

    public int getTimesShowInfoOfSynthesi() {
        return timesShowInfoOfSynthesi;
    }

    public int getTimesShowInfoOfProduct() {
        return timesShowInfoOfProduct;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setModelNo(int modelNo) {
        this.modelNo = modelNo;
    }

    public void setAvailablePorts(Port availablePorts) {
        this.availablePorts = availablePorts;
    }
}
