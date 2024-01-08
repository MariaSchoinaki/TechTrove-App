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
import com.example.tecktrove.domain.Employer;
import com.example.tecktrove.domain.User;
import com.example.tecktrove.memorydao.MemoryInitializer;
import com.example.tecktrove.view.Customer.HomeScreen.HomeScreenActivity;
import com.example.tecktrove.view.SharedViewModel;
import com.example.tecktrove.view.Authentication.SignUp.SignUpActivity;

public class LogInActivity extends AppCompatActivity implements LogInView {

    LogInPresenter presenter;
    MemoryInitializer init;
    private SharedViewModel sharedViewModel;

    /**
     * Initializes the classes attributes
     * @param savedInstanceState
     */
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

    /**
     * Navigates the app to the sign up page
     */
    public void signUp(){
        Intent intent = new Intent(LogInActivity.this, SignUpActivity.class);
        startActivity(intent);
    }

    /**
     * Waits for the screen to be clicked
     */
    @Override
    public void onStart(){
        super.onStart();
        findViewById(R.id.btnLogIn).setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                presenter.startProcess();
            }
        });
    }

    /**
     * Gets the username
     *
     * @return the username a String
     */
    @Override
    public String getUsername() {
        return ((EditText)findViewById(R.id.logIn_username)).getText().toString().trim();
    }

    /**
     * Gets the password
     *
     * @return the password as a String
     */
    @Override
    public String getPassword() {
        return ((EditText)findViewById(R.id.logIn_password)).getText().toString().trim();
    }

    /**
     * Gets if the user is an employer or not
     *
     * @return  {@code true} if the user is an employer, false otherwise
     */
    @Override
    public boolean isEmployer(){
        return ((Switch)findViewById(R.id.login_isEmployer)).isChecked();
    }

    /**
     * Shows a pop up window with a customized message
     *
     * @param title the title of the window
     * @param msg   the text of the window
     */
    @Override
    public void showErrorMessage(String title, String msg) {
        new AlertDialog.Builder(LogInActivity.this)
                .setCancelable(true)
                .setTitle(title)
                .setMessage(msg)
                .setPositiveButton(R.string.ok, null).create().show();
    }

    /**
     * Navigates the user to the correct home screen
     *
     * @param user  the user trying to login
     */
    @Override
    public void login(User user){
        if(!isEmployer()){
            sharedViewModel.setSharedCustomer((Customer) user);
            sharedViewModel.setIsEmployer(false);
            Intent intent = new Intent(this, com.example.tecktrove.view.Customer.HomeScreen.HomeScreenActivity.class);
            startActivity(intent);
        }else{
            sharedViewModel.setSharedEmployer((Employer) user);
            sharedViewModel.setIsEmployer(true);
            Intent intent = new Intent(this, com.example.tecktrove.view.Employer.HomeScreen.HomeScreenActivity.class);
            startActivity(intent);
        }

    }
}
