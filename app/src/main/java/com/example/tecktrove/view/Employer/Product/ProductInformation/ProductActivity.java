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
import com.example.tecktrove.view.Employer.HomeScreen.HomeScreenActivity;
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


    /**
     * Initializes the classes attributes
     * @param savedInstanceState
     */
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
                ActivityFlipper.setDisplayedChild(ActivityFlipper.indexOfChild(findViewById(R.id.employer_product_info)));
                presenter.setInfo(Integer.parseInt(getModelNo()));
            }
        });
        findViewById(R.id.employer_product_change_exit_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ActivityFlipper.setDisplayedChild(ActivityFlipper.indexOfChild(findViewById(R.id.employer_product_info)));
                presenter.setInfo(modelNo);
            }
        });

        findViewById(R.id.employer_product_info_exit_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.goToHomeScreen();
            }
        });
    }

    /**
     * Displays the Component's information
     *
     * @param modelNo           the model number
     * @param price             the price
     * @param name              the name
     * @param description       the description
     * @param manufacturer      the manufacturer
     * @param availablePorts    the available ports
     * @param requiredPorts     the required ports
     * @param quantity          the quantity
     */
    @Override
    public void showProductInfo(int modelNo, Money price, String name, String description, String manufacturer, Port availablePorts, Port requiredPorts ,int quantity) {
        productFlipper.setDisplayedChild(productFlipper.indexOfChild(findViewById(R.id.employer_product_info_constraintLayout)));
        ((TextView) findViewById(R.id.employer_product_info_name)).setText(name);
        ((TextView) findViewById(R.id.employer_product_info_modelNo)).setText("Κωδικός Προϊόντος: " + (String.valueOf(modelNo)));
        ((TextView) findViewById(R.id.employer_product_info_manufacturer)).setText("Κατασκευαστής: " + manufacturer);
        ((TextView) findViewById(R.id.employer_product_info_description)).setText((description));
        ((TextView) findViewById(R.id.employer_product_info_price)).setText(price.toString());
        ((TextView) findViewById(R.id.product_info_employer_quantity_number)).setText("Η συνολική ποσότητα στο κατάστημα είναι: " + String.valueOf(quantity));
        findViewById(R.id.product_info_employer_rating_number).setVisibility(View.GONE);
        findViewById(R.id.product_info_employer_rating_star).setVisibility(View.GONE);
        PortAdapter avports = new PortAdapter(availablePorts);
        PortAdapter reqports = new PortAdapter(requiredPorts);
        recyclerViewForAvailablePorts.setAdapter(avports);
        Log.d("ProductActivity",availablePorts.toString());
        recyclerViewForAvailablePorts.setLayoutManager( new GridLayoutManager(this, 1));
        recyclerViewForRequiredPorts.setAdapter(reqports);
        recyclerViewForRequiredPorts.setLayoutManager( new GridLayoutManager(this, 1));
    }

    /**
     * Displays the synthesis information
     *
     * @param modelNo       the model number
     * @param name          the name
     * @param price         the price
     * @param components    the components
     * @param rating        the rating
     */
    @Override
    public void showSynthesisInfo(int modelNo, String name, String price, ArrayList<Component> components, double rating) {
        productFlipper.setDisplayedChild(productFlipper.indexOfChild(findViewById(R.id.employer_product_info_recyc)));
        ((TextView) findViewById(R.id.employer_product_info_name)).setText(name);
        ((TextView) findViewById(R.id.employer_product_info_modelNo)).setText("Model Number: " + (String.valueOf(modelNo)));
        ((TextView) findViewById(R.id.employer_product_info_price)).setText(price.toString());
        ((TextView) findViewById(R.id.product_info_employer_rating_number)).setText(String.valueOf(rating));
        findViewById(R.id.employer_product_info_change_elements).setVisibility(View.GONE);
        findViewById(R.id.employer_product_info_manufacturer).setVisibility(View.GONE);
        findViewById(R.id.employer_product_info_description).setVisibility(View.GONE);
        findViewById(R.id.employer_product_info_descriptionTitle).setVisibility(View.GONE);
        componentAdapter = new ProductAdapter(new ArrayList<>(components), this);
        recyclerViewForSynthesis.setAdapter(componentAdapter);
        recyclerViewForSynthesis.setLayoutManager(new GridLayoutManager(this, 1));
    }


    /**
     * Changes the components information
     *
     * @param component the component
     */
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

    /**
     * Navigates the user to exit
     */
    @Override
    public void onExit() {
        Intent intent = new Intent(this, HomeScreenActivity.class);
        startActivity(intent);
    }

    /**
     * Gets the quantity set by the user
     *
     * @return the quantity
     */
    @Override
    public int getQuantity() {
        return Integer.parseInt(((EditText) findViewById(R.id.employer_product_info_quantity)).getText().toString().trim());
    }

    /**
     * Shows a custom message
     *
     * @param title the title of the window
     * @param msg   the message of the window
     */
    @Override
    public void showMessage(String title, String msg) {
        new AlertDialog.Builder(ProductActivity.this)
                .setCancelable(true)
                .setTitle(title)
                .setMessage(msg)
                .setPositiveButton(R.string.ok, null).create().show();
    }

    /**
     * Gets the name set by the user
     *
     * @return the name
     */
    @Override
    public String getName() {
        return ((EditText)findViewById(R.id.employer_product_change_name)).getText().toString().trim();
    }

    /**
     * Gets the price set by the user
     *
     * @return the price
     */
    @Override
    public String getPrice() {
        return ((EditText)findViewById(R.id.employer_product_change_price)).getText().toString().trim();
    }

    /**
     * Gets the manufacturer set by the user
     *
     * @return the manufacturer
     */
    @Override
    public String getManufacturer() {
        return ((EditText)findViewById(R.id.employer_product_change_manufacturer)).getText().toString().trim();
    }

    /**
     * Gets the description set by the user
     *
     * @return the description
     */
    @Override
    public String getDescription() {
        return ((EditText)findViewById(R.id.employer_product_change_description)).getText().toString().trim();
    }

    /**
     * Gets the model number set by the user
     *
     * @return the model number
     */
    @Override
    public String getModelNo() {
        return ((EditText)findViewById(R.id.employer_product_change_modelNo)).getText().toString().trim();
    }

    /**
     * Gets the available ports set by the user
     *
     * @return the available ports
     */
    @Override
    public String getAvailablePorts() {
        return ((EditText)findViewById(R.id.employer_product_change_available_ports)).getText().toString().trim();
    }

    /**
     * Gets the required ports set by the user
     *
     * @return the required ports
     */
    @Override
    public String getRequiredPorts() {
        return ((EditText)findViewById(R.id.employer_product_change_required_ports)).getText().toString().trim();
    }

    /**
     * Navigates the user to the product information of the product clicked
     * @param product   the clicke product
     */
    @Override
    public void onProductClick(ProductType product) {
        Intent intent = new Intent(this, ProductActivity.class);
        intent.putExtra("modelNo",product.getModelNo() );
        startActivity(intent);
    }
}