package com.example.tecktrove.view.Authentication.SignUp;

import com.example.tecktrove.contacts.Email;
import com.example.tecktrove.contacts.Telephone;

public interface SignUpView {

    void logIn();

    String getUsername();

    String getPassword();

    String getfullName();

    String getEmail();

    String getTelephone();

    String getConfPassword();

    boolean isEmployer();

    void signUp();

    void showErrorMessage(String error, String s);
}
