package com.example.tecktrove.view.Product;

import com.example.tecktrove.domain.Component;
import com.example.tecktrove.domain.Customer;
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
     * Adds to cart of the customer the product
     * @param product the product
     */
    void Cart(ProductType product);

    /**
     * Increases the quantity of the product
     */
    void increaseQuantity();

    /**
     * Decreases the quantity of the product
     */
    void decreaseQuantity();

    /**
     * Show a custome message
     *
     * @param title the title of the window
     * @param msg   the message of the window
     */
    void showMessage(String title, String msg);

    /**
     * Navigates the app to the home screen
     */
    void goToHome();

    /**
     * Shows the rating stars if show is true
     * @param show  a boolean value
     */
    void showRating(boolean show);
}
