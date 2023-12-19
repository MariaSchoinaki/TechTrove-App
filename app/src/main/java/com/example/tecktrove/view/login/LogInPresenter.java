package com.example.tecktrove.view.login;

public class LogInPresenter {

    LogInView view;

    public LogInPresenter(LogInView view){
        this.view = view;
    }

    void onSignUp(){
        view.signUp();
    }
}
