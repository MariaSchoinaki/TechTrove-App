package com.example.tecktrove.view.SignUp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tecktrove.R;
import com.example.tecktrove.view.login.LogInActivity;

import android.util.Log;

public class SignUpActivity extends AppCompatActivity implements SignUpView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_user_signup);
        Log.d("gi", "onCreate");
        SignUpPresenter presenter = new SignUpPresenter(this);

        findViewById(R.id.txtSignIn).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Log.d("gi", "txtSignIn clicked");
                presenter.onLogIn();

            }
        });
    }


    public void logIn(){
        Log.d("gi", "logIn");
        Intent intent = new Intent(SignUpActivity.this, LogInActivity.class);
        startActivity(intent);
    }
}
