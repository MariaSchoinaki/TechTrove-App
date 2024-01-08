package com.example.tecktrove.view.MyAccount;

public interface MyAccountView {

    /**
     * Terminates app and navigates to start screen
     */
    void logout();

    /**
     * Shows a custom message
     *
     * @param title the title of the window
     * @param msg   the message of the window
     */
    void showMessage(String title, String msg);

    /**
     * Navigates the app to the order history screen
     */
    void history();
}
