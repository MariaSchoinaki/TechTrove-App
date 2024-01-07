package com.example.tecktrove.view.Employer.Product.AddProduct;

public class AddProductViewStub implements AddProductView{


    private int timesHomeScreen = 0;
    private int timesShowingMessage = 0;
    private String name, price, manufacturer, description, available_ports, required_ports, modelNo;

    @Override
    public void goToHomeScreen() {
        timesHomeScreen++;
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
        return price;
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
        return modelNo;
    }

    @Override
    public String getAvailablePorts() {
        return available_ports;
    }

    @Override
    public String getRequiredPorts() {
        return required_ports;
    }

    @Override
    public int getQuantity() {
        return 0;
    }

    public int getTimesHomeScreen() {
        return timesHomeScreen;
    }

    public int getTimesShowingMessage() {
        return timesShowingMessage;
    }

    public void setName(String name){ this.name = name;}

    public void setAvailable_ports(String available_ports) {
        this.available_ports = available_ports;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setRequired_ports(String required_ports) {
        this.required_ports = required_ports;
    }

    public void setModelNo(String modelNo) {
        this.modelNo = modelNo;
    }
}
