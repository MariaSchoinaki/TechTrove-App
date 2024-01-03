package com.example.tecktrove.view.MyAccount;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.ViewFlipper;

import com.example.tecktrove.R;
import com.example.tecktrove.dao.Initializer;
import com.example.tecktrove.domain.User;
import com.example.tecktrove.memorydao.MemoryInitializer;
import com.example.tecktrove.view.Authentication.SignUp.SignUpActivity;
import com.example.tecktrove.view.Authentication.StartScreen.StartScreenActivity;
import com.example.tecktrove.view.SharedViewModel;

public class MyAccountActivity extends AppCompatActivity implements MyAccountView{

    private MyAccountPresenter presenter;
    private SharedViewModel sharedViewModel;
    private boolean isEmployer;
    private Initializer init;
    private View mainLayout;
    private View changeLayout;
    ViewFlipper flipper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.Base_Theme_TeckTrove);
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_my_account);

        init = new MemoryInitializer();

        presenter = new MyAccountPresenter(this, init.getCustomerDAO(), init.getEmployerDAO());
        sharedViewModel = new ViewModelProvider(this).get(SharedViewModel.class);

        isEmployer = sharedViewModel.isEmployer();

        flipper = findViewById(R.id.my_account_view_flipper);

        findViewById(R.id.my_account_change_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                flipper.showNext();
            }
        });

        findViewById(R.id.my_acount_exit_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                flipper.showPrevious();
            }
        });
        findViewById(R.id.my_account_save_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                presenter.setInfo(((EditText) findViewById(R.id.my_account_full_name)).getText().toString().trim(),
                        ((EditText) findViewById(R.id.my_account_email)).getText().toString().trim(),
                        ((EditText) findViewById(R.id.my_account_mobile)).getText().toString().trim(),
                        ((EditText) findViewById(R.id.my_account_username)).getText().toString().trim(),
                        ((EditText) findViewById(R.id.my_account_password)).getText().toString().trim(),
                        ((EditText) findViewById(R.id.my_account_confirm_password)).getText().toString().trim(), sharedViewModel.isEmployer());
                if(sharedViewModel.isEmployer()){
                    presenter.onSaveChanges((User) sharedViewModel.getEmployer());
                }else{
                    presenter.onSaveChanges((User) sharedViewModel.getCustomer());
                }
            }
        });

        findViewById(R.id.my_account_logout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.onLogout();
            }
        });

        findViewById(R.id.my_account_delete_account).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.onDeleteAccount();
            }
        });

        String fullname, username, password, email, phone;
        if(sharedViewModel.isEmployer()){
            fullname = sharedViewModel.getEmployer().getName() + " " + sharedViewModel.getEmployer().getLastName();
            username = sharedViewModel.getEmployer().getUsername();
            password = sharedViewModel.getEmployer().getPassword();
            email = sharedViewModel.getEmployer().getEmail().getEmail();
            phone = sharedViewModel.getEmployer().getTelephone().getTelephone();
        }else {
            fullname = sharedViewModel.getCustomer().getName() + " " + sharedViewModel.getCustomer().getLastName();
            username = sharedViewModel.getCustomer().getUsername();
            password = sharedViewModel.getCustomer().getPassword();
            email = sharedViewModel.getCustomer().getEmail().getEmail();
            phone = sharedViewModel.getCustomer().getTelephone().getTelephone();
        }
        ((TextView) findViewById(R.id.my_account_name)).setText(fullname);
        ((EditText) findViewById(R.id.my_account_full_name)).setText(fullname);
        ((EditText) findViewById(R.id.my_account_email)).setText(email);
        ((EditText) findViewById(R.id.my_account_username)).setText(username);
        ((EditText) findViewById(R.id.my_account_password)).setText(password);
        ((EditText) findViewById(R.id.my_account_mobile)).setText(phone);
    }


    @Override
    public void logout() {
        Intent intent = new Intent(this, StartScreenActivity.class);
        startActivity(intent);
    }

    @Override
    public void showMessage(String title, String msg) {
        new AlertDialog.Builder(MyAccountActivity.this)
                .setCancelable(true)
                .setTitle(title)
                .setMessage(msg)
                .setPositiveButton(R.string.ok, null).create().show();
    }
}
