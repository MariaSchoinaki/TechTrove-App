package com.example.tecktrove.view.Employer.Product.AddProduct;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.tecktrove.R;
import com.example.tecktrove.dao.Initializer;
import com.example.tecktrove.memorydao.ComponentDAOMemory;
import com.example.tecktrove.memorydao.MemoryInitializer;
import com.example.tecktrove.view.Employer.HomeScreen.HomeScreenActivity;

public class AddProductActivity extends AppCompatActivity implements AddProductView {

    private AddProductPresenter presenter;
    private Initializer init;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.employer_product_change_fragment);

        init = new MemoryInitializer();
        presenter = new AddProductPresenter(this, new ComponentDAOMemory());

        findViewById(R.id.employer_product_change_exit_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.onHomeScreen();
            }
        });

        findViewById(R.id.employer_product_change_save_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.saveProduct();
            }
        });
    }

    @Override
    public void goToHomeScreen() {
        Intent intent = new Intent(this, HomeScreenActivity.class);
        startActivity(intent);
    }

    @Override
    public void showMessage(String title, String msg) {
        new AlertDialog.Builder(AddProductActivity.this)
                .setCancelable(true)
                .setTitle(title)
                .setMessage(msg)
                .setPositiveButton(R.string.ok, null).create().show();
    }

    @Override
    public String getName() {
        return ((EditText)findViewById(R.id.employer_product_change_name)).getText().toString().trim();
    }

    @Override
    public String getPrice() {
        return ((EditText)findViewById(R.id.employer_product_change_price)).getText().toString().trim();
    }

    @Override
    public String getManufacturer() {
        return ((EditText)findViewById(R.id.employer_product_change_manufacturer)).getText().toString().trim();
    }

    @Override
    public String getDescription() {
        return ((EditText)findViewById(R.id.employer_product_change_description)).getText().toString().trim();
    }

    @Override
    public String getModelNo() {
        return ((EditText)findViewById(R.id.employer_product_change_modelNo)).getText().toString().trim();
    }

    @Override
    public String getAvailablePorts() {
        return ((EditText)findViewById(R.id.employer_product_change_available_ports)).getText().toString().trim();
    }

    @Override
    public String getRequiredPorts() {
        return ((EditText)findViewById(R.id.employer_product_change_required_ports)).getText().toString().trim();
    }

    @Override
    public int getQuantity() {
        return Integer.parseInt(((EditText) findViewById(R.id.employer_product_info_quantity)).getText().toString().trim());
    }

}
