package com.example.tecktrove.view.LogIn;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Switch;

import com.example.tecktrove.R;
import com.example.tecktrove.dao.CustomerDAO;
import com.example.tecktrove.memorydao.CustomerDAOMemory;
import com.example.tecktrove.memorydao.EmployerDAOMemory;
import com.example.tecktrove.memorydao.MemoryInitializer;
import com.example.tecktrove.view.HomeScreen.HomeScreenActivity;
import com.example.tecktrove.view.HomeScreen.HomeScreenView;
import com.example.tecktrove.view.SignUp.SignUpActivity;

public class LogInActivity extends AppCompatActivity implements LogInView {

    LogInPresenter presenter;
    MemoryInitializer init;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.Base_Theme_TeckTrove);
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_user_login);

        init = new MemoryInitializer();
        presenter = new LogInPresenter(this,init.getCustomerDAO(), init.getEmployerDAO());
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
    public boolean isEmployer(){
        return ((Switch)findViewById(R.id.login_isEmployer)).isChecked();
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
        Intent intent = new Intent(this, HomeScreenActivity.class);
        intent.putExtra("user_id", presenter.getUserName());
        startActivity(intent);
    }
}
