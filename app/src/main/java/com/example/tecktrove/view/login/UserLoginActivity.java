package com.example.tecktrove.view.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.tecktrove.R;
import com.example.tecktrove.view.SignUp.SignUpActivity;

public class UserLoginActivity extends AppCompatActivity implements UserLoginView{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_user_login);
        UserLoginPresenter presenter = new UserLoginPresenter(this);

        findViewById(R.id.txtSignUp).setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                presenter.onSignUp();

            }
        });
    }

    @Override
    public void signUp(){
        Intent intent = new Intent(UserLoginActivity.this, SignUpActivity.class);
        startActivity(intent);
    }
}
