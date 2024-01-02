package com.example.tecktrove.view.LogIn;

import com.example.tecktrove.domain.User;

public interface LogInView {

    void signUp();

    String getUsername();

    String getPassword();

    void showErrorMessage(String title, String msg);

    void login(User user);

    boolean isEmployer();
}
