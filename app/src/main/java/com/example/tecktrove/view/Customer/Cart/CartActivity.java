package com.example.tecktrove.view.Customer.Cart;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tecktrove.R;
import com.example.tecktrove.dao.Initializer;
import com.example.tecktrove.domain.OrderLine;
import com.example.tecktrove.domain.ProductType;
import com.example.tecktrove.memorydao.ComponentDAOMemory;
import com.example.tecktrove.memorydao.MemoryInitializer;
import com.example.tecktrove.dao.ComponentDAO;
import com.example.tecktrove.util.Money;
import com.example.tecktrove.util.Pair;
import com.example.tecktrove.view.CartProductAdapter;
import com.example.tecktrove.view.Customer.HomeScreen.HomeScreenActivity;
import com.example.tecktrove.view.Product.ProductActivity;
import com.example.tecktrove.view.ProductAdapter;
import com.example.tecktrove.view.SharedViewModel;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class CartActivity extends AppCompatActivity implements CartView, CartProductAdapter.OnCartProductClickListener{
    private RecyclerView recyclerView;

    private Initializer init;

    private ComponentDAO componentDAO;


        private CartProductAdapter productAdapter;


        private CartPresenter presenter;


        private SharedViewModel sharedViewModel;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            setTheme(R.style.Base_Theme_TeckTrove);
            super.onCreate(savedInstanceState);
            super.setContentView(R.layout.cart);

            recyclerView = findViewById(R.id.recyclerView);
            init = new MemoryInitializer();
            componentDAO = new ComponentDAOMemory();

            sharedViewModel = new ViewModelProvider(this).get(SharedViewModel.class);

            ArrayList<ProductType> items = getSelectedItems();
            GridLayoutManager layoutManager = new GridLayoutManager(this, 1);
            recyclerView.setLayoutManager(layoutManager);
            productAdapter = new CartProductAdapter((sharedViewModel.getCustomer().getCart()), this);
            recyclerView.setAdapter(productAdapter);

            presenter = new CartPresenter(this);
            TabLayout tabLayout = findViewById(R.id.CustomerHomePageTabLayout);

            ShowTotal();

            tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
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
                            break;
                        case 3:
                            break;
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








        //sample data
        private ArrayList<ProductType> getSelectedItems() {
            ArrayList<ProductType> items = new ArrayList<ProductType>();
            items.add(componentDAO.find("AMD CPU Ryzen 3 3200G"));
            items.add(componentDAO.find("Turbo-X PSU Value III Series 550 W"));
            items.add(componentDAO.find("Gigabyte Motherboard A520I AC"));
            return items;
        }



        @Override
        public void onCartProductClick(ProductType product) {
            Log.d("Category Clicked", product.getName());
            Intent intent = new Intent(this, ProductActivity.class);
            intent.putExtra("modelNo",product.getModelNo() );
            startActivity(intent);
        }

        @Override
        public void home() {
            Log.d("Cart", "HomeScreenActivity");
            Intent intent = new Intent(CartActivity.this, HomeScreenActivity.class);
            startActivity(intent);
        }

    @Override
    public void cart() {

    }

    @Override
        public void ShowTotal(){
            Money total = Money.euros(0);
            for (OrderLine p : sharedViewModel.getCustomer().getCart()){
                total= total.plus(p.getProductType().getPrice().times(p.getQuantity()));
            }
            ((TextView) findViewById(R.id.sum)).setText("Total: "+total.toString());
        }
}
