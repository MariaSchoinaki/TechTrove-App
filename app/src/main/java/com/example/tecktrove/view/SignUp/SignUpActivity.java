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
import com.example.tecktrove.view.HomeScreen.HomeScreenActivity;
import com.example.tecktrove.view.LogIn.LogInActivity;
import com.example.tecktrove.view.StartScreen.StartScreenActivity;

public class SignUpActivity extends AppCompatActivity implements SignUpView {
    SignUpPresenter presenter;
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
        findViewById(R.id.btnSignUp).setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                    presenter.startProcess();

            }
        });


    }

    public void logIn(){
        Intent intent = new Intent(SignUpActivity.this, LogInActivity.class);
        startActivity(intent);
    }


    @Override
    public String getUsername() {
        return ((EditText)findViewById(R.id.SignUpUsername)).getText().toString().trim();
    }

    @Override
    public String getPassword() {
        return ((EditText)findViewById(R.id.edtSignUpPassword)).getText().toString().trim();
    }

    @Override
    public String getfullName() {
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

    @Override
    public String getConfPassword() {
        return ((EditText)findViewById(R.id.edtSignUpConfirmPassword)).getText().toString().trim();
    }
    @Override
    public boolean isEmployer(){
        return ((Switch)findViewById(R.id.signup_isEmployer)).isChecked();
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
        Intent intent = new Intent(SignUpActivity.this, HomeScreenActivity.class);
        startActivity(intent);
    }
}
