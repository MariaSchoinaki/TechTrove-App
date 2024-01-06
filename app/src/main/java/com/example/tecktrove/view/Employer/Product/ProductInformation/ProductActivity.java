package com.example.tecktrove.view.Employer.Product.ProductInformation;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
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
import java.util.stream.Collectors;

public class ProductActivity extends AppCompatActivity implements ProductView, ProductAdapter.OnProductClickListener{

    private ProductPresenter presenter;
    private Initializer init;
    private  int quantity;
    private SharedViewModel sharedViewModel;
    private ProductAdapter componentAdapter;
    private RecyclerView recyclerViewForSynthesis;
    private RecyclerView recyclerViewForAvailablePorts, recyclerViewForRequiredPorts;
    private PortAdapter adapter;
    ViewFlipper productFlipper, ActivityFlipper;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_information_employer);

        int modelNo = getIntent().getIntExtra("modelNo", 0);
        init = new MemoryInitializer();
        presenter = new ProductPresenter(new ComponentDAOMemory(), new SynthesisDAOMemory(), this);


        sharedViewModel = new ViewModelProvider(this).get(SharedViewModel.class);
        productFlipper = findViewById(R.id.employer_product_info_view_flipper);
        ActivityFlipper = findViewById(R.id.employer_product_view_flipper);

        recyclerViewForSynthesis = findViewById(R.id.employer_product_info_recyc);

        GridLayoutManager layoutManager = new GridLayoutManager(this, 1);
        recyclerViewForSynthesis.setLayoutManager(layoutManager);

        recyclerViewForRequiredPorts = findViewById(R.id.employer_product_info_recycler_required_port);
        recyclerViewForRequiredPorts.setLayoutManager( new GridLayoutManager(this, 1));

        recyclerViewForAvailablePorts = findViewById(R.id.employer_product_info_recycler_available_port);
        recyclerViewForAvailablePorts.setLayoutManager( new GridLayoutManager(this, 1));


        presenter.setInfo(modelNo);


        findViewById(R.id.employer_product_info_change_elements).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.goToChange(modelNo);
            }
        });

        findViewById(R.id.employer_product_info_delete_product).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.onDelete(modelNo);
            }
        });

        findViewById(R.id.employer_product_info_increase_quantity).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.onIncreaseQuantity(modelNo);
            }
        });

        findViewById(R.id.employer_product_change_save_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.ChangeInfo(modelNo);
            }
        });
        findViewById(R.id.employer_product_change_exit_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ActivityFlipper.setDisplayedChild(ActivityFlipper.indexOfChild(findViewById(R.id.employer_product_info)));
                presenter.setInfo(modelNo);
            }
        });
    }

    @Override
    public void showProductInfo(int modelNo, Money price, String name, String description, String manufacturer, Port availablePorts, Port requiredPorts ,int quantity) {
        productFlipper.setDisplayedChild(productFlipper.indexOfChild(findViewById(R.id.employer_product_info_constraintLayout)));
        ((TextView) findViewById(R.id.employer_product_info_name)).setText(name);
        ((TextView) findViewById(R.id.employer_product_info_modelNo)).setText("Model Number: " + (String.valueOf(modelNo)));
        ((TextView) findViewById(R.id.employer_product_info_manufacturer)).setText("Manufacturer: " + manufacturer);
        ((TextView) findViewById(R.id.employer_product_info_description)).setText((description));
        ((TextView) findViewById(R.id.employer_product_info_price)).setText(price.toString());
        ((EditText) findViewById(R.id.employer_product_info_quantity)).setText(String.valueOf(quantity));
        PortAdapter avports = new PortAdapter(availablePorts);
        PortAdapter reqports = new PortAdapter(requiredPorts);
        recyclerViewForAvailablePorts.setAdapter(avports);
        Log.d("ProductActivity",availablePorts.toString());
        recyclerViewForAvailablePorts.setLayoutManager( new GridLayoutManager(this, 1));
        recyclerViewForRequiredPorts.setAdapter(reqports);
        recyclerViewForRequiredPorts.setLayoutManager( new GridLayoutManager(this, 1));
    }

    @Override
    public void showSynthesisInfo(int modelNo, String name, String price, ArrayList<Component> components) {
        productFlipper.setDisplayedChild(productFlipper.indexOfChild(findViewById(R.id.employer_product_info_recyc)));
        ((TextView) findViewById(R.id.employer_product_info_name)).setText(name);
        ((TextView) findViewById(R.id.employer_product_info_modelNo)).setText("Model Number: " + (String.valueOf(modelNo)));
        ((TextView) findViewById(R.id.employer_product_info_price)).setText(price.toString());
        findViewById(R.id.employer_product_info_change_elements).setVisibility(View.GONE);
        findViewById(R.id.employer_product_info_manufacturer).setVisibility(View.GONE);
        findViewById(R.id.employer_product_info_description).setVisibility(View.GONE);
        findViewById(R.id.employer_product_info_descriptionTitle).setVisibility(View.GONE);
        componentAdapter = new ProductAdapter(new ArrayList<>(components), this);
        recyclerViewForSynthesis.setAdapter(componentAdapter);
        recyclerViewForSynthesis.setLayoutManager(new GridLayoutManager(this, 1));
    }


    @Override
    public void ChangeComponentInfo(Component component) {
        ActivityFlipper.setDisplayedChild(ActivityFlipper.indexOfChild(findViewById(R.id.employer_product_change)));
        ((EditText) findViewById(R.id.employer_product_change_name)).setText(component.getName());
        ((EditText) findViewById(R.id.employer_product_change_modelNo)).setText(String.valueOf(component.getModelNo()));
        ((EditText) findViewById(R.id.employer_product_change_price)).setText(component.getPrice().toString());
        ((EditText) findViewById(R.id.employer_product_change_description)).setText(component.getDescription());
        ((EditText) findViewById(R.id.employer_product_change_manufacturer)).setText(component.getManufacturer());
        String listString = component.getAvailablePorts().getPorts().stream().map(Object::toString).collect(Collectors.joining(", "));
        ((EditText) findViewById(R.id.employer_product_change_available_ports)).setText(listString);
        listString = component.getRequiredPorts().getPorts().stream().map(Object::toString).collect(Collectors.joining(", "));
        ((EditText) findViewById(R.id.employer_product_change_required_ports)).setText(listString);
    }

    @Override
    public int getQuantity() {
        return Integer.parseInt(((EditText) findViewById(R.id.employer_product_info_quantity)).getText().toString().trim());
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
    public void onProductClick(ProductType product) {
        Intent intent = new Intent(this, ProductActivity.class);
        intent.putExtra("modelNo",product.getModelNo() );
        startActivity(intent);
    }
}