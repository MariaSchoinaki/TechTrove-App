package com.example.tecktrove.view.login;

public class UserLoginPresenter {

    UserLoginView view;

    public UserLoginPresenter(UserLoginView view){
        this.view = view;
    }

    void onSignUp(){
        view.signUp();
    }
}
