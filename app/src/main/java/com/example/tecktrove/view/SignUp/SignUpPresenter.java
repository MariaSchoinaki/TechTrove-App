package com.example.tecktrove.view.SignUp;

import com.example.tecktrove.view.login.UserLoginView;

public class SignUpPresenter {

    SignUpView view;

    public SignUpPresenter(SignUpView view){
        this.view = view;
    }

    void onLogIn(){ view.logIn(); }
}
