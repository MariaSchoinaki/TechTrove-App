package com.example.tecktrove.view.Authentication.SignUp;

import com.example.tecktrove.contacts.Email;
import com.example.tecktrove.contacts.Telephone;
import com.example.tecktrove.domain.User;

public interface SignUpView {

    /**
     * Navigates the app to the log in page
     */
    void logIn();

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
     * Gets the full name
     *
     * @return the full name as a String
     */
    String getfullName();

    /**
     * Gets the email
     *
     * @return the email as a String
     */
    String getEmail();

    /**
     * Gets the telephone
     *
     * @return the telephone as a String
     */
    String getTelephone();

    /**
     * Gets the confirmation password
     *
     * @return the confirmation password as a String
     */
    String getConfPassword();

    /**
     * Gets if the user is an employer or not
     *
     * @return  {@code true} if the user is an employer, false otherwise
     */
    boolean isEmployer();

    /**
     * Navigates the user to the correct home screen
     *
     * @param user  the user trying to login
     */
    void signUp(User user);

    /**
     * Shows a pop up window with a customized message
     *
     * @param title the title of the window
     * @param msg   the text of the window
     */
    void showErrorMessage(String error, String s);
}
