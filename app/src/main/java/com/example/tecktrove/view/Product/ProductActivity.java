package com.example.tecktrove.view.Product;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.tecktrove.R;
import com.example.tecktrove.dao.Initializer;
import com.example.tecktrove.domain.ProductType;
import com.example.tecktrove.memorydao.MemoryInitializer;
import com.example.tecktrove.util.Money;
import com.example.tecktrove.util.Port;
import com.example.tecktrove.view.SharedViewModel;

public class ProductActivity extends AppCompatActivity implements ProductView{

    private ProductPresenter presenter;
    private Initializer init;
    private  int quantity;
    private SharedViewModel sharedViewModel;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_information);

        int modelNo = getIntent().getIntExtra("modelNo", 0);
        init = new MemoryInitializer();
        presenter = new ProductPresenter(init.getComponentDAO(),this);

        presenter.setInfo(modelNo);

        sharedViewModel = new ViewModelProvider(this).get(SharedViewModel.class);



        findViewById(R.id.product_info_addToCart).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.goToCart(quantity);
            }
        });

        findViewById(R.id.product_info_decrease).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.onDecreaseQuantity();
            }
        });

        findViewById(R.id.product_info_increase).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.onIncreaseQuantity();
            }
        });
    }

    @Override
    public void showInfo(int modelNo, Money price, String name, String description, String manufacturer, Port availablePorts, Port requiredPorts ,int quantity) {
        ((TextView) findViewById(R.id.product_info_name)).setText(name);
        ((TextView) findViewById(R.id.product_info_modelNo)).setText("Model Number: " + (String.valueOf(modelNo)));
        ((TextView) findViewById(R.id.product_info_manufacturer)).setText("Manufacturer: " + manufacturer);
        ((TextView) findViewById(R.id.product_info_description)).setText((description));
        ((TextView) findViewById(R.id.product_info_price)).setText(price.toString());

    }

    @Override
    public void Cart(ProductType product) {
        product.setQuantityOnCart(quantity);
        sharedViewModel.getCustomer().addToCart(product);
        showMessage("Success", "Added to cart!");

    }

    @Override
    public void increaseQuantity() {
        quantity++;
        ((TextView) findViewById(R.id.product_info_quantity)).setText(String.valueOf(quantity));
    }

    @Override
    public void decreaseQuantity() {
        if (quantity > 0) {
            quantity--;

            ((TextView) findViewById(R.id.product_info_quantity)).setText(String.valueOf(quantity));
        }
    }

    @Override
    public void showMessage(String title, String msg) {
        new AlertDialog.Builder(ProductActivity.this)
                .setCancelable(true)
                .setTitle(title)
                .setMessage(msg)
                .setPositiveButton(R.string.ok, null).create().show();
    }



}