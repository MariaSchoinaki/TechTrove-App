package com.example.tecktrove.view.LogIn;

public interface LogInView {

    void signUp();

    String getUsername();

    String getPassword();

    void showErrorMessage(String title, String msg);

    void login();

    boolean isEmployer();
}
