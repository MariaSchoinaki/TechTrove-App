package com.example.tecktrove.view.StarterScreen;

public class StarterScreenPresenter {
    private StarterScreenView view;


    public StarterScreenPresenter(StarterScreenView view){
        this.view = view;
    }

    void onLogIn(){
        view.logInForm();
    }

    void onSignUp(){
        view.signUpForm();
    }
}
