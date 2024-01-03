package com.example.tecktrove.view.Authentication.LogIn;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Switch;

import com.example.tecktrove.R;
import com.example.tecktrove.domain.Customer;
import com.example.tecktrove.domain.User;
import com.example.tecktrove.memorydao.MemoryInitializer;
import com.example.tecktrove.view.Customer.HomeScreen.HomeScreenActivity;
import com.example.tecktrove.view.SharedViewModel;
import com.example.tecktrove.view.Authentication.SignUp.SignUpActivity;

public class LogInActivity extends AppCompatActivity implements LogInView {

    LogInPresenter presenter;
    MemoryInitializer init;
    private SharedViewModel sharedViewModel;

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

        sharedViewModel = new ViewModelProvider(this).get(SharedViewModel.class);
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
    public void login(User user){
        if(!isEmployer()){
            sharedViewModel.setSharedCustomer((Customer) user);
        }
        Intent intent = new Intent(this, HomeScreenActivity.class);
        intent.putExtra("user_id", presenter.getUserName());
        startActivity(intent);
    }
}
