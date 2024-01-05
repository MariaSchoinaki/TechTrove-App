package com.example.tecktrove.view.Authentication.LogIn;

import com.example.tecktrove.domain.User;

public interface LogInView {

    /**
     * Navigates the app to the sign up page
     */
    void signUp();

    /**
     * Gets the username
     *
     * @return the username a String
     */
    String getUsername();

    /**
     * Gets the password
     *
     * @return the password as a String
     */
    String getPassword();

    /**
     * Shows a pop up window with a customized message
     *
     * @param title the title of the window
     * @param msg   the text of the window
     */
    void showErrorMessage(String title, String msg);

    /**
     * Navigates the user to the correct home screen
     *
     * @param user  the user trying to login
     */
    void login(User user);

    /**
     * Gets if the user is an employer or not
     *
     * @return  {@code true} if the user is an employer, false otherwise
     */
    boolean isEmployer();
}
