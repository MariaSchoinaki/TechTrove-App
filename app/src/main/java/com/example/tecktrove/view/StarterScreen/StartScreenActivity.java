package com.example.tecktrove.view.StarterScreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.tecktrove.R;
import com.example.tecktrove.view.SignUp.SignUpActivity;
import com.example.tecktrove.view.login.LogInActivity;

public class StartScreenActivity extends AppCompatActivity implements StartScreenView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.Theme_TeckTrove_status_bar);
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_start_screen);

        StartScreenPresenter presenter = new StartScreenPresenter(this);
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

    public void logInForm() {
        Intent intent = new Intent(StartScreenActivity.this, LogInActivity.class);
        startActivity(intent);
    }

    public void signUpForm() {
        Intent intent = new Intent(StartScreenActivity.this, SignUpActivity.class);
        startActivity(intent);
    }

    //protected void onStart()
}