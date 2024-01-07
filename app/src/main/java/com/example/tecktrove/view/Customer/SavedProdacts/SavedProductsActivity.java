package com.example.tecktrove.view.Customer.SavedProdacts;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tecktrove.R;
import com.example.tecktrove.domain.ProductType;
import com.example.tecktrove.view.Customer.Cart.CartActivity;
import com.example.tecktrove.view.Employer.HomeScreen.HomeScreenActivity;
import com.example.tecktrove.view.MyAccount.MyAccountActivity;
import com.example.tecktrove.view.Product.ProductActivity;
import com.example.tecktrove.view.ProductAdapter;
import com.example.tecktrove.view.SharedViewModel;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class SavedProductsActivity extends AppCompatActivity implements SavedProductView, ProductAdapter.OnProductClickListener {
    private SharedViewModel sharedViewModel;

    private ProductAdapter productAdapter;

    private RecyclerView recyclerView;
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.Base_Theme_TeckTrove);
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.saved);

        recyclerView = findViewById(R.id.saved_cpntainer);
        GridLayoutManager manager = new GridLayoutManager(this,2);
        sharedViewModel = new SharedViewModel();
        recyclerView.setLayoutManager(manager);
        productAdapter = new ProductAdapter(new ArrayList<ProductType>(sharedViewModel.getCustomer().getSavedSynthesis()),this);
        recyclerView.setAdapter(productAdapter);
        TabLayout tabLayout = findViewById(R.id.CustomerHomePageTabLayout);

        SavedProductsPresenter presenter = new SavedProductsPresenter(this);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
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
                        presenter.onMyAccount();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                // Handle tab unselection
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                // Handle tab reselection
            }
        });


    }

    @Override
    public void onProductClick(ProductType product) {
        Intent intent = new Intent(this, ProductActivity.class);
        startActivity(intent);
    }

    @Override
    public void Home(){
        Intent intent = new Intent(this, HomeScreenActivity.class);
        startActivity(intent);
    }

    @Override
    public void Cart(){
        Intent intent = new Intent(this, CartActivity.class);
        startActivity(intent);
    }

    @Override
    public void MyAccount(){
        Intent intent = new Intent(this, MyAccountActivity.class);
        startActivity(intent);

    }

    @Override
    public void Saved(){
        Intent intent = new Intent(this, SavedProductsActivity.class);
        startActivity(intent);
    }
}
