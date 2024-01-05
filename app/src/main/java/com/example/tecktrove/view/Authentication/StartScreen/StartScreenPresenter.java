package com.example.tecktrove.view.Authentication.StartScreen;

public class StartScreenPresenter {
    private StartScreenView view;

    /**
     * Constructor of the presenter
     * @param view
     */
    public StartScreenPresenter(StartScreenView view){
        this.view = view;
    }

    /**
     * Navigates the app to the login page
     */
    void onLogIn(){
        view.logInForm();
    }

    /**
     * Navigatesthe app to the sign up page
     */
    void onSignUp(){
        view.signUpForm();
    }
}
