package com.example.tecktrove.view.StarterScreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.tecktrove.R;
import com.example.tecktrove.view.SignUp.SignUpActivity;
import com.example.tecktrove.view.SignUp.SignUpPresenter;
import com.example.tecktrove.view.login.UserLoginActivity;
import android.util.Log;

public class StartScreenActivity extends AppCompatActivity implements StarterScreenView{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_start_screen);

        Log.d("StartScreenActivity", "txtSignIn clicked");
        StarterScreenPresenter presenter = new StarterScreenPresenter(this);
        findViewById(R.id.login_button).setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                Log.d("StartScreenActivity", "txtSignIn 32");
                presenter.onLogIn();

            }
        });

        findViewById(R.id.signup_button).setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                Log.d("StartScreenActivity", "txtSignIn 42");
                presenter.onSignUp();

            }
        });

    }


    public void logInForm() {
        Log.d("StartScreenActivity", "txtSignIn 52");
        Intent intent = new Intent(StartScreenActivity.this, UserLoginActivity.class);
        startActivity(intent);
    }


    public void signUpForm() {
        Log.d("StartScreenActivity", "txtSignIn 62");
        Intent intent = new Intent(StartScreenActivity.this, SignUpActivity.class);
        startActivity(intent);
    }

    //protected void onStart()
}