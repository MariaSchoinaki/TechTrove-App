package com.example.tecktrove.view.Product;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewFlipper;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tecktrove.R;
import com.example.tecktrove.dao.Initializer;
import com.example.tecktrove.domain.Component;
import com.example.tecktrove.domain.Customer;
import com.example.tecktrove.domain.OrderLine;
import com.example.tecktrove.domain.ProductType;
import com.example.tecktrove.memorydao.ComponentDAOMemory;
import com.example.tecktrove.memorydao.MemoryInitializer;
import com.example.tecktrove.memorydao.SynthesisDAOMemory;
import com.example.tecktrove.util.Money;
import com.example.tecktrove.util.Pair;
import com.example.tecktrove.util.Port;
import com.example.tecktrove.view.Customer.HomeScreen.HomeScreenActivity;
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



    /**
     * Initializes the classes attributes
     * @param savedInstanceState
     */
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


        presenter.setInfo(modelNo, sharedViewModel.getCustomer());


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
        findViewById(R.id.product_info_exit_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.onExit();
            }
        });
        findViewById(R.id.very_bad_rating).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.setRating(modelNo, 1, sharedViewModel.getCustomer());
            }
        });
        findViewById(R.id.bad_rating).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.setRating(modelNo, 2, sharedViewModel.getCustomer());
            }
        });
        findViewById(R.id.meh_rating).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.setRating(modelNo, 3, sharedViewModel.getCustomer());
            }
        });
        findViewById(R.id.good_rating).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.setRating(modelNo, 4, sharedViewModel.getCustomer());
            }
        });
        findViewById(R.id.very_good_rating).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.setRating(modelNo, 5, sharedViewModel.getCustomer());
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
        flipper.setDisplayedChild(flipper.indexOfChild(findViewById(R.id.constraintLayout)));
        ((TextView) findViewById(R.id.product_info_name)).setText(name);
        ((TextView) findViewById(R.id.product_info_modelNo)).setText("Model Number: " + (String.valueOf(modelNo)));
        ((TextView) findViewById(R.id.product_info_manufacturer)).setText("Manufacturer: " + manufacturer);
        ((TextView) findViewById(R.id.product_info_description)).setText((description));
        ((TextView) findViewById(R.id.product_info_price)).setText(price.toString());
        int resId = findViewById(R.id.constraintLayout).getResources().getIdentifier("c" + String.valueOf(modelNo), "drawable", findViewById(R.id.constraintLayout).getContext().getPackageName());
        ((ImageView) findViewById(R.id.product_info_img)).setImageResource(resId);
        findViewById(R.id.product_info_rating_number).setVisibility(View.GONE);
        findViewById(R.id.product_info_rating_star).setVisibility(View.GONE);
        findViewById(R.id.rating_layout).setVisibility(View.GONE);
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
        flipper.setDisplayedChild(flipper.indexOfChild(findViewById(R.id.product_info_recyc)));
        ((TextView) findViewById(R.id.product_info_name)).setText(name);
        ((TextView) findViewById(R.id.product_info_modelNo)).setText("Model Number: " + (String.valueOf(modelNo)));
        ((TextView) findViewById(R.id.product_info_price)).setText(price.toString());
        ((TextView) findViewById(R.id.product_info_rating_number)).setText(String.valueOf(rating));
        findViewById(R.id.product_info_manufacturer).setVisibility(View.GONE);
        findViewById(R.id.product_info_description).setVisibility(View.GONE);
        findViewById(R.id.product_info_descriptionTitle).setVisibility(View.GONE);
        componentAdapter = new ProductAdapter(new ArrayList<>(components), this);
        recyclerViewForSynthesis.setAdapter(componentAdapter);
        recyclerViewForSynthesis.setLayoutManager(new GridLayoutManager(this, 1));
    }

    /**
     * Shows the rating stars if show is true
     * @param show  a boolean value
     */
    public void showRating(boolean show){
        if(show){
            findViewById(R.id.rating_layout).setVisibility(View.VISIBLE);
        }else {
            findViewById(R.id.rating_layout).setVisibility(View.GONE);
        }
    }

    /**
     * Adds to cart of the customer the product
     * @param product the product
     */
    @Override
    public void Cart(ProductType product) {
        sharedViewModel.getCustomer().addToCart(new OrderLine(quantity,product));
        showMessage("Success", "Added to cart!");

    }

    /**
     * Increases the quantity of the product
     */
    @Override
    public void increaseQuantity() {
        quantity++;
        ((TextView) findViewById(R.id.product_info_quantity)).setText(String.valueOf(quantity));
    }

    /**
     * Decreases the quantity of the product
     */
    @Override
    public void decreaseQuantity() {
        if (quantity > 0) {
            quantity--;

            ((TextView) findViewById(R.id.product_info_quantity)).setText(String.valueOf(quantity));
        }
    }

    /**
     * Show a custome message
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
     * Navigates the app to the home screen
     */
    @Override
    public void goToHome() {
        Intent intent = new Intent(this, HomeScreenActivity.class);
        startActivity(intent);
    }

    /**
     * Navigates the user to the product information page of the product they clicked
     * @param product
     */
    @Override
    public void onProductClick(ProductType product) {
        Intent intent = new Intent(this, ProductActivity.class);
        intent.putExtra("modelNo",product.getModelNo() );
        startActivity(intent);
    }
}