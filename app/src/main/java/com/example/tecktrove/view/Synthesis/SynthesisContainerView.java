package com.example.tecktrove.view.Synthesis;

public interface SynthesisContainerView {
    /**
     * Shows a custom message
     *
     * @param title the title of the window
     * @param msg   the message of the window
     */
    void showErrorMessage(String title, String msg);

    /**
     * Checks if a synthesis is completed and adds it to cart
     */
    void completeSynthesis();

    /**
     * Calls showErrorMessage to display a message to customer
     */
    void save();

    /**
     * Gets the name
     *
     * @return the name as a String
     */
    String getName();
    /**
     * Show home
     */
    void home();
    /**
     * Show cart
     */
    void cart();
    /**
     * Show saved
     */
    void saved();
    /**
     * Show Myacount
     */
    void Myacount();
}
