package com.example.tecktrove.view.Product;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.ViewFlipper;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tecktrove.R;
import com.example.tecktrove.dao.Initializer;
import com.example.tecktrove.domain.Component;
import com.example.tecktrove.domain.ProductType;
import com.example.tecktrove.memorydao.ComponentDAOMemory;
import com.example.tecktrove.memorydao.MemoryInitializer;
import com.example.tecktrove.memorydao.SynthesisDAOMemory;
import com.example.tecktrove.util.Money;
import com.example.tecktrove.util.Pair;
import com.example.tecktrove.util.Port;
import com.example.tecktrove.view.PortAdapter;
import com.example.tecktrove.view.ProductAdapter;
import com.example.tecktrove.view.SharedViewModel;

import java.util.ArrayList;

public class ProductActivity extends AppCompatActivity implements ProductView, ProductAdapter.OnProductClickListener{

    private ProductPresenter presenter;
    private Initializer init;
    private  int quantity = 1;
    private SharedViewModel sharedViewModel;
    private ProductAdapter componentAdapter;
    private RecyclerView recyclerViewForSynthesis;
    private RecyclerView recyclerViewForAvailablePorts, recyclerViewForRequiredPorts;
    private PortAdapter adapter;
    ViewFlipper flipper;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_information);

        int modelNo = getIntent().getIntExtra("modelNo", 0);
        init = new MemoryInitializer();
        presenter = new ProductPresenter(new ComponentDAOMemory(), new SynthesisDAOMemory(), this);


        sharedViewModel = new ViewModelProvider(this).get(SharedViewModel.class);
        flipper = findViewById(R.id.product_info_view_flipper);


        recyclerViewForSynthesis = findViewById(R.id.product_info_recyc);

        GridLayoutManager layoutManager = new GridLayoutManager(this, 1);
        recyclerViewForSynthesis.setLayoutManager(layoutManager);

        recyclerViewForRequiredPorts = findViewById(R.id.product_info_recycler_required_port);
        recyclerViewForRequiredPorts.setLayoutManager( new GridLayoutManager(this, 1));

        recyclerViewForAvailablePorts = findViewById(R.id.product_info_recycler_available_port);
        recyclerViewForAvailablePorts.setLayoutManager( new GridLayoutManager(this, 1));


        presenter.setInfo(modelNo);


        findViewById(R.id.product_info_addToCart).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.goToCart(quantity, modelNo);
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
    public void showProductInfo(int modelNo, Money price, String name, String description, String manufacturer, Port availablePorts, Port requiredPorts ,int quantity) {
        flipper.setDisplayedChild(flipper.indexOfChild(findViewById(R.id.constraintLayout)));
        ((TextView) findViewById(R.id.product_info_name)).setText(name);
        ((TextView) findViewById(R.id.product_info_modelNo)).setText("Model Number: " + (String.valueOf(modelNo)));
        ((TextView) findViewById(R.id.product_info_manufacturer)).setText("Manufacturer: " + manufacturer);
        ((TextView) findViewById(R.id.product_info_description)).setText((description));
        ((TextView) findViewById(R.id.product_info_price)).setText(price.toString());
        PortAdapter avports = new PortAdapter(availablePorts);
        PortAdapter reqports = new PortAdapter(requiredPorts);
        recyclerViewForAvailablePorts.setAdapter(avports);
        Log.d("ProductActivity",availablePorts.toString());
        recyclerViewForAvailablePorts.setLayoutManager( new GridLayoutManager(this, 1));
        recyclerViewForRequiredPorts.setAdapter(reqports);
        recyclerViewForRequiredPorts.setLayoutManager( new GridLayoutManager(this, 1));
        //flipper.showNext();
    }

    @Override
    public void showSynthesisInfo(int modelNo, String name, String price, ArrayList<Component> components) {
        flipper.setDisplayedChild(flipper.indexOfChild(findViewById(R.id.product_info_recyc)));
        ((TextView) findViewById(R.id.product_info_name)).setText(name);
        ((TextView) findViewById(R.id.product_info_modelNo)).setText("Model Number: " + (String.valueOf(modelNo)));
        ((TextView) findViewById(R.id.product_info_price)).setText(price.toString());
        findViewById(R.id.product_info_manufacturer).setVisibility(View.GONE);
        findViewById(R.id.product_info_description).setVisibility(View.GONE);
        findViewById(R.id.product_info_descriptionTitle).setVisibility(View.GONE);
        componentAdapter = new ProductAdapter(new ArrayList<>(components), this);
        recyclerViewForSynthesis.setAdapter(componentAdapter);
        recyclerViewForSynthesis.setLayoutManager(new GridLayoutManager(this, 1));
        //flipper.showPrevious();
    }


    @Override
    public void Cart(ProductType product) {
        sharedViewModel.getCustomer().addToCart(new Pair<ProductType,Integer>(product,quantity));
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


    @Override
    public void onProductClick(ProductType product) {
        Intent intent = new Intent(this, ProductActivity.class);
        intent.putExtra("modelNo",product.getModelNo() );
        startActivity(intent);
    }
}