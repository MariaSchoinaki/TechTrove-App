package com.example.tecktrove.view.MyAccount;

public class MyAccountViewStub implements MyAccountView{

    private int timesLogedOut = 0;
    private int timesShowingMessage = 0;

    @Override
    public void logout() {
        timesLogedOut++;
    }

    @Override
    public void showMessage(String title, String msg) {
        timesShowingMessage++;
    }

    public int getTimesShowingMessage() {
        return timesShowingMessage;
    }

    public int getTimesLogedOut() {
        return timesLogedOut;
    }

}
