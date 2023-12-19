package com.example.tecktrove.view.LogIn;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.tecktrove.R;
import com.example.tecktrove.view.SignUp.SignUpActivity;
import com.example.tecktrove.view.StartScreen.StartScreenActivity;

public class LogInActivity extends AppCompatActivity implements LogInView {

    LogInPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.Base_Theme_TeckTrove);
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_user_login);

        presenter = new LogInPresenter(this);
        findViewById(R.id.txtSignUp).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                presenter.onSignUp();
            }
        });
    }

    public void signUp(){
        Intent intent = new Intent(LogInActivity.this, SignUpActivity.class);
        startActivity(intent);
    }

    @Override
    public void onStart(){
        super.onStart();
        findViewById(R.id.btnLogIn).setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                presenter.startProcess();
            }
        });
    }

    @Override
    public String getUsername() {
        return ((EditText)findViewById(R.id.logIn_username)).getText().toString().trim();
    }

    @Override
    public String getPassword() {
        return ((EditText)findViewById(R.id.logIn_password)).getText().toString().trim();
    }

    @Override
    public void showErrorMessage(String title, String msg) {
        new AlertDialog.Builder(LogInActivity.this)
                .setCancelable(true)
                .setTitle(title)
                .setMessage(msg)
                .setPositiveButton(R.string.ok, null).create().show();
    }

    @Override
    public void login(){
        Intent intent = new Intent(LogInActivity.this, SignUpActivity.class);
        startActivity(intent);
    }
}
