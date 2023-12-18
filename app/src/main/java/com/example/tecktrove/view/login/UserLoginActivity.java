package com.example.tecktrove.view.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.tecktrove.R;
import com.example.tecktrove.view.SignUp.SignUpActivity;
import android.util.Log;


public class UserLoginActivity extends AppCompatActivity implements UserLoginView{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_user_login);

        Log.d("UserLoginActivity", "onCreate");

        UserLoginPresenter presenter = new UserLoginPresenter(this);

        findViewById(R.id.txtSignUp).setOnClickListener(view -> {
            Log.d("UserLoginActivity", "txtSignUp clicked");
            presenter.onSignUp();

        });
    }


    public void signUp(){
        Log.d("UserLoginActivity", "signUp");
        Intent intent = new Intent(UserLoginActivity.this, SignUpActivity.class);
        startActivity(intent);
    }
}
