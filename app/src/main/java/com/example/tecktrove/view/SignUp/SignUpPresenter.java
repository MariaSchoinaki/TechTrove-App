package com.example.tecktrove.view.SignUp;

public class SignUpPresenter {

    SignUpView view;

    public SignUpPresenter(SignUpView view){
        this.view = view;
    }

    void onLogIn(){ view.logIn(); }
}
