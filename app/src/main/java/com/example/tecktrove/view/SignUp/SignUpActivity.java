package com.example.tecktrove.view.SignUp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Switch;

import com.example.tecktrove.R;
import com.example.tecktrove.memorydao.MemoryInitializer;
import com.example.tecktrove.view.LogIn.LogInActivity;
import com.example.tecktrove.view.LogIn.LogInPresenter;
import com.example.tecktrove.view.StartScreen.StartScreenActivity;

import java.util.ArrayList;

public class SignUpActivity extends AppCompatActivity implements SignUpView {
    SignUpPresenter presenter;
    ArrayList<String> info = new ArrayList<String>();
    MemoryInitializer init;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.Base_Theme_TeckTrove);
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_user_signup);

        init = new MemoryInitializer();
        presenter = new SignUpPresenter(this,init.getCustomerDAO(), init.getEmployerDAO());

        findViewById(R.id.txtSignIn).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                presenter.onLogIn();
            }
        });
    }


    @Override
    public void onStart(){
        super.onStart();
        findViewById(R.id.signup_button).setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                    presenter.startProcess(info);

            }
        });


    }

    public void logIn(){
        Intent intent = new Intent(SignUpActivity.this, LogInActivity.class);
        startActivity(intent);
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
    public String fullName() {
        return ((EditText)findViewById(R.id.SignUpFullName)).getText().toString().trim();
    }

    @Override
    public String getEmail() {
        return ((EditText)findViewById(R.id.SignUpEmail)).getText().toString().trim();
    }

    @Override
    public String getTelephone() {
        return ((EditText)findViewById(R.id.edtSignUpMobile)).getText().toString().trim();
    }


    public void showErrorMessage(String title, String msg) {
        new AlertDialog.Builder(SignUpActivity.this)
                .setCancelable(true)
                .setTitle(title)
                .setMessage(msg)
                .setPositiveButton(R.string.ok, null).create().show();
    }

    @Override
    public void signUp(){
        Intent intent = new Intent(SignUpActivity.this, StartScreenActivity.class);
        startActivity(intent);
    }
}
