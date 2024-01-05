package com.example.tecktrove.view.Authentication.SignUp;

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
import com.example.tecktrove.view.Authentication.LogIn.LogInActivity;
import com.example.tecktrove.view.SharedViewModel;

public class SignUpActivity extends AppCompatActivity implements SignUpView {
    SignUpPresenter presenter;
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
        super.setContentView(R.layout.activity_user_signup);

        init = new MemoryInitializer();
        presenter = new SignUpPresenter(this,init.getCustomerDAO(), init.getEmployerDAO());

        findViewById(R.id.txtSignIn).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                presenter.onLogIn();
            }
        });
        sharedViewModel = new ViewModelProvider(this).get(SharedViewModel.class);
    }

    /**
     * Waits for the screen to be clicked
     */
    @Override
    public void onStart(){
        super.onStart();
        findViewById(R.id.btnSignUp).setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                    presenter.startProcess();

            }
        });


    }

    /**
     * Navigates the app to the log in page
     */
    public void logIn(){
        Intent intent = new Intent(SignUpActivity.this, LogInActivity.class);
        startActivity(intent);
    }

    /**
     * Gets the username
     *
     * @return the username a String
     */
    @Override
    public String getUsername() {
        return ((EditText)findViewById(R.id.SignUpUsername)).getText().toString().trim();
    }

    /**
     * Gets the password
     *
     * @return the password as a String
     */
    @Override
    public String getPassword() {
        return ((EditText)findViewById(R.id.edtSignUpPassword)).getText().toString().trim();
    }

    /**
     * Gets the full name
     *
     * @return the full name as a String
     */
    @Override
    public String getfullName() {
        return ((EditText)findViewById(R.id.SignUpFullName)).getText().toString().trim();
    }

    /**
     * Gets the email
     *
     * @return the email as a String
     */
    @Override
    public String getEmail() {
        return ((EditText)findViewById(R.id.SignUpEmail)).getText().toString().trim();
    }

    /**
     * Gets the telephone
     *
     * @return the telephone as a String
     */
    @Override
    public String getTelephone() {
        return ((EditText)findViewById(R.id.edtSignUpMobile)).getText().toString().trim();
    }

    /**
     * Gets the confirmation password
     *
     * @return the confirmation password as a String
     */
    @Override
    public String getConfPassword() {
        return ((EditText)findViewById(R.id.edtSignUpConfirmPassword)).getText().toString().trim();
    }

    /**
     * Gets if the user is an employer or not
     *
     * @return  {@code true} if the user is an employer, false otherwise
     */
    @Override
    public boolean isEmployer(){
        return ((Switch)findViewById(R.id.signup_isEmployer)).isChecked();
    }

    /**
     * Shows a pop up window with a customized message
     *
     * @param title the title of the window
     * @param msg   the text of the window
     */
    public void showErrorMessage(String title, String msg) {
        new AlertDialog.Builder(SignUpActivity.this)
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
    public void signUp(User user){
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
