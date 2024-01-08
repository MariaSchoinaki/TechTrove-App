package com.example.tecktrove.view.Employer.Product.AddProduct;

public interface AddProductView {

    /**
     * Helps return the navigation back to home screen
     */
    void goToHomeScreen();

    /**
     * Shows a pop up window with a customized message
     *
     * @param title the title of the window
     * @param msg   the text of the window
     */
    void showMessage(String title, String msg);

    /**
     * Gets the name
     *
     * @return name as a String
     */
    String getName();

    /**
     * Gets the price
     *
     * @return the price as a String
     */
    String getPrice();

    /**
     * Gets the manufacturer
     *
     * @return the manufacturer as a String
     */
    String getManufacturer();

    /**
     * Gets the description
     *
     * @return the description as a String
     */
    String getDescription();

    /**
     * Gets the model number
     *
     * @return the model number as a String
     */
    String getModelNo();

    /**
     * Gets the available ports
     *
     * @return the available ports as a String
     */
    String getAvailablePorts();

    /**
     * Gets the required ports
     *
     * @return the required ports as a String
     */
    String getRequiredPorts();

    /**
     * Gets the quantity
     *
     * @return the quantity as an Integer
     */
    int getQuantity();
}
