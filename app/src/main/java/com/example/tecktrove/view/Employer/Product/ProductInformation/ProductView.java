package com.example.tecktrove.view.Employer.Product.ProductInformation;

import com.example.tecktrove.domain.Component;
import com.example.tecktrove.domain.ProductType;
import com.example.tecktrove.util.Money;
import com.example.tecktrove.util.Port;

import java.util.ArrayList;

public interface ProductView {

    /**
     * Displays the Component's information
     *
     * @param modelNo           the model number
     * @param price             the price
     * @param name              the name
     * @param description       the description
     * @param manufacturer      the manufacturer
     * @param availablePorts    the available ports
     * @param requiredPorts     the required ports
     * @param quantity          the quantity
     */
    void showProductInfo(int modelNo, Money price, String name, String description, String manufacturer, Port availablePorts, Port requiredPorts, int quantity);

    /**
     * Displays the synthesis information
     *
     * @param modelNo       the model number
     * @param name          the name
     * @param price         the price
     * @param components    the components
     * @param rating        the rating
     */
    void showSynthesisInfo(int modelNo,String name, String price, ArrayList<Component> components, double rating);

    /**
     * Changes the components information
     *
     * @param component the component
     */
    void ChangeComponentInfo(Component component);

    /**
     * Navigates the user to exit
     */
    void onExit();

    /**
     * Gets the quantity set by the user
     *
     * @return the quantity
     */
    int getQuantity();

    /**
     * Shows a custom message
     *
     * @param title the title of the window
     * @param msg   the message of the window
     */
    void showMessage(String title, String msg);

    /**
     * Gets the name set by the user
     *
     * @return the name
     */
    String getName();

    /**
     * Gets the price set by the user
     *
     * @return the price
     */
    String getPrice();

    /**
     * Gets the manufacturer set by the user
     *
     * @return the manufacturer
     */
    String getManufacturer();

    /**
     * Gets the description set by the user
     *
     * @return the description
     */
    String getDescription();

    /**
     * Gets the model number set by the user
     *
     * @return the model number
     */
    String getModelNo();

    /**
     * Gets the available ports set by the user
     *
     * @return the available ports
     */
    String getAvailablePorts();

    /**
     * Gets the required ports set by the user
     *
     * @return the required ports
     */
    String getRequiredPorts();
}
