package com.example.tecktrove.view.StarterScreen;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.tecktrove.R;

public class StartScreenActivity extends AppCompatActivity implements StarterScreenView{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_start_screen);
        StarterScreenPresenter presenter = new StarterScreenPresenter(this);
        findViewById(R.id.login_button).setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                presenter.onLogIn();

            }
        });

        findViewById(R.id.signup_button).setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                presenter.onSignUp();

            }
        });

    }

    @Override
    public void logInForm() {

    }

    @Override
    public void signUpForm() {

    }

    //protected void onStart()
}