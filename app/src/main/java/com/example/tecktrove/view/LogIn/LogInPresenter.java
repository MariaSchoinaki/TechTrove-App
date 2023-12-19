package com.example.tecktrove.view.LogIn;

public class LogInPresenter {
    LogInView view;

    public LogInPresenter(LogInView view){
        this.view = view;
    }

    void onSignUp(){
        view.signUp();
    }
}
