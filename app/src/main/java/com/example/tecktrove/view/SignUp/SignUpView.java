package com.example.tecktrove.view.SignUp;

import com.example.tecktrove.contacts.Email;
import com.example.tecktrove.contacts.Telephone;

public interface SignUpView {

    void logIn();

    String getUsername();

    String getPassword();

    String fullName();

    String getEmail();

    String getTelephone();


    void signUp();

    void showErrorMessage(String error, String s);
}
