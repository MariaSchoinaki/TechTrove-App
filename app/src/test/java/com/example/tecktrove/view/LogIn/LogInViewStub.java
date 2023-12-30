package com.example.tecktrove.view.LogIn;

public class LogInViewStub implements LogInView {

    String username;
    String password;

    int message = 0;
    int timesVisitedSignUp = 0;
    boolean role; int logedIn = 0;


    public void setUser(String username,String password,boolean role){
        this.role=role; //true -> is employer
        this.username = username;
        this.password = password;
    }

    @Override
    public void signUp() {
        timesVisitedSignUp++;
    }

    public int timesLogedIn(){
        return logedIn;
    }

    public int getTimesVisitedSignUp(){
        return timesVisitedSignUp;
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
    public void showErrorMessage(String title, String msg) {
        message++;
    }

    public int getErrorMessage(){
        return message;
    }

    @Override
    public void login() {
        logedIn++;
    }

    @Override
    public boolean isEmployer() {
        return role;
    }
}
