package com.example.tecktrove.view.MyAccount.OrderHistory;

import android.content.Intent;
import android.os.Bundle;

import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tecktrove.R;
import com.example.tecktrove.domain.Order;
import com.example.tecktrove.domain.OrderLine;
import com.example.tecktrove.domain.ProductType;
import com.example.tecktrove.domain.Synthesis;
import com.example.tecktrove.memorydao.MemoryInitializer;
import com.example.tecktrove.memorydao.OrderDAOMemory;
import com.example.tecktrove.view.Customer.Cart.CartActivity;
import com.example.tecktrove.view.Customer.HomeScreen.HomeScreenActivity;
import com.example.tecktrove.view.Customer.SavedProducts.SavedProductsActivity;
import com.example.tecktrove.view.MyAccount.MyAccountActivity;
import com.example.tecktrove.view.OrderSynthesisAdapter;
import com.example.tecktrove.view.Product.ProductActivity;
import com.example.tecktrove.view.ProductAdapter;
import com.example.tecktrove.view.SharedViewModel;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class OrderActivity extends OrderHistoryActivity implements ProductAdapter.OnProductClickListener, OrderSynthesisAdapter.OnPublishClickListener , OrderView {
    private RecyclerView recyclerView1;
    private RecyclerView recyclerView2;

    private SharedViewModel sharedViewModel;
    MemoryInitializer init;

    OrderDAOMemory orderDAO;


    /**
     * Initializes the classes attributes
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.Base_Theme_TeckTrove);
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.order_details);

        recyclerView1 = findViewById(R.id.component_container);
        recyclerView2 = findViewById(R.id.SynthesisContainer);

        sharedViewModel = new ViewModelProvider(this).get(SharedViewModel.class);

        init = new MemoryInitializer();
        orderDAO = new OrderDAOMemory();
        ArrayList<Synthesis> syntheses = new ArrayList<Synthesis>();
        ArrayList<ProductType> components = new ArrayList<ProductType>();
        int orderid = getIntent().getIntExtra("orderid", 0);
        Order order = orderDAO.find(orderid);
        for(OrderLine orderLine : order.getOrderLines()){
            if(orderLine.getProductType() instanceof Synthesis){
                syntheses.add((Synthesis) orderLine.getProductType());
            }else {
                components.add(orderLine.getProductType());
            }
        }

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,1);
        GridLayoutManager gridLayoutManager2 = new GridLayoutManager(this,2);
        recyclerView1.setLayoutManager(gridLayoutManager);
        recyclerView2.setLayoutManager(gridLayoutManager2);
        OrderSynthesisAdapter adapter = new OrderSynthesisAdapter(syntheses,this);
        ProductAdapter adapter1 = new ProductAdapter(components,this);
        recyclerView2.setAdapter(adapter1);
        recyclerView1.setAdapter(adapter);
        TabLayout tabLayout = findViewById(R.id.OrderHomePageTabLayout);

        OrderPresenter presenter = new OrderPresenter(this);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            /**navigate through tabs
             *
             */
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                // Handle tab selection
                int position = tab.getPosition();
                switch (position) {
                    case 0:
                        presenter.onHome();
                    case 1:
                        presenter.onCart();
                    case 2:

                        presenter.onSaved();
                    case 3:
                        presenter.onMyAcount();
                        // Add cases for other tabs as needed
                }
            }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                presenter.onCart();
            }
        });

    }

    /**
     * Navigates the user to the product information page of the product they clicked
     *
     * @param product
     */
    @Override
    public void onProductClick(ProductType product) {
        Intent intent = new Intent(this, ProductActivity.class);
        intent.putExtra("modelNo", product.getModelNo());
        startActivity(intent);
    }

    /**
     * Sets publish state
     *
     * @param synthesis
     */
    @Override
    public void onPublishClickListener(Synthesis synthesis) {
        synthesis.setPublishState(true);
    }

    /**
     * navigate to home
     */
    @Override
    public void home() {
        Intent intent = new Intent(this, HomeScreenActivity.class);
        startActivity(intent);
    }

    /**
     * navigate to cart
     */
    @Override
    public void cart() {
        Intent intent = new Intent(this, CartActivity.class);
        startActivity(intent);
    }

    /**
     * navigate to Saved
     */
    @Override
    public void Saved() {
        Intent intent = new Intent(this, SavedProductsActivity.class);
        startActivity(intent);
    }

    /**
     * navigate to MyAcount
     */
    @Override
    public void MyAcount() {
        Intent intent = new Intent(this, MyAccountActivity.class);
        startActivity(intent);
    }
}
