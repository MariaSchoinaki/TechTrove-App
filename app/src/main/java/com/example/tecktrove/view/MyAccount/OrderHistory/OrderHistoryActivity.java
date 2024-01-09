package com.example.tecktrove.view.MyAccount.OrderHistory;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tecktrove.R;
import com.example.tecktrove.dao.Initializer;
import com.example.tecktrove.dao.OrderDAO;
import com.example.tecktrove.domain.Order;
import com.example.tecktrove.memorydao.MemoryInitializer;
import com.example.tecktrove.memorydao.OrderDAOMemory;
import com.example.tecktrove.view.Customer.Cart.CartActivity;
import com.example.tecktrove.view.Customer.HomeScreen.HomeScreenActivity;
import com.example.tecktrove.view.Customer.SavedProducts.SavedProductsActivity;
import com.example.tecktrove.view.MyAccount.MyAccountActivity;
import com.example.tecktrove.view.OrderAdapter;
import com.example.tecktrove.view.SharedViewModel;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class OrderHistoryActivity extends AppCompatActivity implements OrderHistoryView, OrderAdapter.OnOrderClickListener {
    private RecyclerView recyclerView;

    private Initializer init;

    private OrderDAO orderDAO;
    private OrderHistoryPresenter presenter;

    protected Order order ;

    /**
     * Initializes the classes attributes
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.Base_Theme_TeckTrove);
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.order_history);

        recyclerView = findViewById(R.id.Order_container);
        init = new MemoryInitializer();
        orderDAO = new OrderDAOMemory();
        SharedViewModel sharedViewModel = new ViewModelProvider(this).get(SharedViewModel.class);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,1);
        recyclerView.setLayoutManager(gridLayoutManager);
        OrderAdapter adapter = new OrderAdapter(new ArrayList<Order>(orderDAO.findByCustomer(sharedViewModel.getCustomer())),this);
        recyclerView.setAdapter(adapter);
        presenter = new OrderHistoryPresenter(this);

        TabLayout tabLayout = findViewById(R.id.OrderHomePageTabLayout);

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
                        break;
                    case 1:
                        presenter.onCart();
                        break;
                    case 2:
                        presenter.onSaved();
                        break;
                    case 3:
                        presenter.onMyAcount();
                        break;
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
     * Navigates app to order information screen
     *
     * @param order
     */
    @Override
    public void onOrderClick(Order order) {
        Intent intent = new Intent(this, OrderActivity.class);
        intent.putExtra("orderid", order.getId());
        startActivity(intent);
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
