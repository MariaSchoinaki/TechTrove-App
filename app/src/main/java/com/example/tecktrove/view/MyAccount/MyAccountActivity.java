package com.example.tecktrove.view.MyAccount;

import android.app.AlertDialog;
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

import com.example.tecktrove.R;
import com.example.tecktrove.dao.Initializer;
import com.example.tecktrove.memorydao.MemoryInitializer;
import com.example.tecktrove.view.Authentication.SignUp.SignUpActivity;
import com.example.tecktrove.view.SharedViewModel;

public class MyAccountActivity extends AppCompatActivity implements MyAccountView{

    private MyAccountPresenter presenter;
    private SharedViewModel sharedViewModel;
    private boolean isEmployer;
    private PopupWindow popupWindow;
    private View contentView;
    private Initializer init;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.Base_Theme_TeckTrove);
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_my_account);

        init = new MemoryInitializer();

        presenter = new MyAccountPresenter(this, init.getCustomerDAO(), init.getEmployerDAO());
        sharedViewModel = new ViewModelProvider(this).get(SharedViewModel.class);

        isEmployer = sharedViewModel.isEmployer();


        Button showPopupButton = findViewById(R.id.my_account_change_button);
        showPopupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopup();
            }
        });

        popupWindow = new PopupWindow(this);
        contentView = getLayoutInflater().inflate(R.layout.activity_my_account_change_characteristics, null);
        popupWindow.setContentView(contentView);

        popupWindow.setWidth(700);
        popupWindow.setHeight(1200);
        popupWindow.setInputMethodMode(PopupWindow.INPUT_METHOD_NEEDED);
        popupWindow.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);
        popupWindow.setFocusable(true);
        popupWindow.setOutsideTouchable(true);



        //View popupView = LayoutInflater.from(this).inflate(R.layout.activity_my_account, null);
        //popupWindow = new PopupWindow(popupView, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, true);

        // Set up the close button inside the popup
        ImageButton closeButton = contentView.findViewById(R.id.my_acount_exit_button);
        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.dismiss();
            }
        });

        contentView.findViewById(R.id.my_account_save_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                presenter.setInfo(((EditText) findViewById(R.id.my_account_full_name)).getText().toString().trim(),
                        ((EditText) findViewById(R.id.my_account_email)).getText().toString().trim(),
                        ((EditText) findViewById(R.id.my_account_mobile)).getText().toString().trim(),
                        ((EditText) findViewById(R.id.my_account_username)).getText().toString().trim(),
                        ((EditText) findViewById(R.id.my_account_password)).getText().toString().trim(),
                        ((EditText) findViewById(R.id.my_account_confirm_password)).getText().toString().trim(), sharedViewModel.isEmployer());
                presenter.onSaveChanges();
            }
        });


        String fullname = sharedViewModel.getCustomer().getName() + " " + sharedViewModel.getCustomer().getLastName();
        String username = sharedViewModel.getCustomer().getUsername();
        String password = sharedViewModel.getCustomer().getPassword();
        String email = sharedViewModel.getCustomer().getEmail().toString();
        String phone = sharedViewModel.getCustomer().getTelephone().toString();
        ((EditText) findViewById(R.id.my_account_full_name)).setText(fullname);
        ((EditText) findViewById(R.id.my_account_email)).setText(email);
        ((EditText) findViewById(R.id.my_account_username)).setText(username);
        ((EditText) findViewById(R.id.my_account_password)).setText(password);
        ((EditText) findViewById(R.id.my_account_mobile)).setText(phone);

    }


    private void showPopup() {
        // Show the popup at a specific location (you can adjust this)
        popupWindow.showAtLocation(contentView, Gravity.CENTER, 0, 50);
    }

    @Override
    public void logout() {

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
