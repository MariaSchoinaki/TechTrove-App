package com.example.tecktrove.view.Authentication.StartScreen;

public class StartScreenPresenter {
    private StartScreenView view;

    public StartScreenPresenter(StartScreenView view){
        this.view = view;
    }

    void onLogIn(){
        view.logInForm();
    }

    void onSignUp(){
        view.signUpForm();
    }
}
