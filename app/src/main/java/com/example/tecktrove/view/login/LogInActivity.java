package com.example.tecktrove.view.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.tecktrove.R;
import com.example.tecktrove.view.SignUp.SignUpActivity;

public class LogInActivity extends AppCompatActivity implements LogInView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.Theme_TeckTrove_status_bar);
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_user_login);

        LogInPresenter presenter = new LogInPresenter(this);

        findViewById(R.id.txtSignUp).setOnClickListener(view -> {
            presenter.onSignUp();

        });
    }

    public void signUp(){
        Intent intent = new Intent(LogInActivity.this, SignUpActivity.class);
        startActivity(intent);
    }
}
