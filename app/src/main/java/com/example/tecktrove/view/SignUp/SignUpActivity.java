package com.example.tecktrove.view.SignUp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tecktrove.R;
import com.example.tecktrove.view.login.UserLoginActivity;

public class SignUpActivity extends AppCompatActivity implements SignUpView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_user_signup);
        SignUpPresenter presenter = new SignUpPresenter(this);

        findViewById(R.id.txtSignIn).setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                presenter.onLogIn();

            }
        });
    }

    @Override
    public void logIn(){
        Intent intent = new Intent(SignUpActivity.this, UserLoginActivity.class);
        startActivity(intent);
    }
}
