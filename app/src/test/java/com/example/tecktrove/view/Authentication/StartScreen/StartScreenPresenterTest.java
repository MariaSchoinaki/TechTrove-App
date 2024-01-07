package com.example.tecktrove.view.Authentication.StartScreen;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StartScreenPresenterTest {
    private StartScreenViewStub view;
    private StartScreenPresenter presenter;

    /**
     * Sets up the presenter and initializes the data
     */
    @Before
    public void setUp() {
        view = new StartScreenViewStub();
        presenter = new StartScreenPresenter(view);
    }

    /**
     * We test to see if the presenter calls the right method
     **/
    @Test
    public void testLogIn() {
        presenter.onLogIn();
        Assert.assertEquals(1, view.getTimesVisitedLogIn());
    }

    /**
     * We test to see if the presenter calls the right method
     **/
    @Test
    public void testSignUp(){
        presenter.onSignUp();
        Assert.assertEquals(1,view.getTimesVisitedSignUp());
    }
}
class StartScreenViewStub implements StartScreenView {
    int timesVisitedLogIn = 0;
    int timesVisitedSignUp = 0;

    public int getTimesVisitedLogIn(){
        return timesVisitedLogIn;
    }
    public int getTimesVisitedSignUp(){
        return timesVisitedSignUp;
    }

    @Override
    public void logInForm() {
        timesVisitedLogIn++;
    }

    @Override
    public void signUpForm() {
        timesVisitedSignUp++;
    }
}