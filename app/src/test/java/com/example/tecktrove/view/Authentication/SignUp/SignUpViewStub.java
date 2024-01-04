package com.example.tecktrove.view.Authentication.SignUp;

import com.example.tecktrove.contacts.Email;
import com.example.tecktrove.contacts.Telephone;

public class SignUpViewStub implements SignUpView{
    String username;
    String password;
    String fullName;
    String telephone;
    String email;
    int message = 0;
    int timesVisitedLogIn = 0;

    boolean role;
    int signedUp = 0;
    private String confirmPassword;


    @Override
    public void logIn() {
        timesVisitedLogIn++;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getfullName() {
        return this.fullName;
    }

    @Override
    public String getEmail() {
        return this.email;
    }

    @Override
    public String getTelephone() {
        return this.telephone;
    }

    @Override
    public String getConfPassword() {
        return this.password;
    }

    @Override
    public boolean isEmployer() {
        return this.role;
    }

    @Override
    public void signUp() {
        signedUp++;
    }

    @Override
    public void showErrorMessage(String error, String s) {
            message++;
    }

    public void setUser(String username, String password,String confirmPassword,String email,String telephone,String fullName, boolean role) {
        this.role=role;
        this.username = username;
        this.password = password;
        this.fullName = fullName;
        this.telephone = telephone;
        this.email = email;
        this.confirmPassword = confirmPassword;
    }

    public int timesSignedUp() {
        return signedUp;
    }

    public int getErrorMessage() {
        return this. message;
    }


}
