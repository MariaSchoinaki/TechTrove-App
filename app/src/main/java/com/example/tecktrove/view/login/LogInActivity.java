package com.example.tecktrove.view.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.tecktrove.R;
import com.example.tecktrove.view.SignUp.SignUpActivity;
import android.util.Log;


public class LogInActivity extends AppCompatActivity implements LogInView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_user_login);

        Log.d("LogInActivity", "onCreate");

        LogInPresenter presenter = new LogInPresenter(this);

        findViewById(R.id.txtSignUp).setOnClickListener(view -> {
            Log.d("LogInActivity", "txtSignUp clicked");
            presenter.onSignUp();

        });
    }


    public void signUp(){
        Log.d("LogInActivity", "signUp");
        Intent intent = new Intent(LogInActivity.this, SignUpActivity.class);
        startActivity(intent);
    }
}
