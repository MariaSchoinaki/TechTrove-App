package com.example.tecktrove.view.Customer.HomeScreen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.SearchView;
import android.widget.TextView;

import com.example.tecktrove.R;
import com.example.tecktrove.dao.Initializer;
import com.example.tecktrove.domain.Component;
import com.example.tecktrove.domain.ProductType;
import com.example.tecktrove.memorydao.MemoryInitializer;
import com.example.tecktrove.view.CategoryAdapter;
import com.example.tecktrove.view.MyAccount.MyAccountActivity;
import com.example.tecktrove.view.Product.ProductActivity;
import com.example.tecktrove.view.ProductAdapter;
import com.example.tecktrove.view.Customer.Cart.CartActivity;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class HomeScreenActivity extends AppCompatActivity implements HomeScreenView, CategoryAdapter.OnCategoryClickListener, ProductAdapter.OnProductClickListener, SearchView.OnQueryTextListener, SearchView.OnCloseListener{

    private RecyclerView recyclerView;
    private CategoryAdapter categoryAdapter;
    private ProductAdapter productAdapter;
    private Initializer init;
    private HomeScreenPresenter presenter;
    private String submittedText;
    private SearchView searchListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.Base_Theme_TeckTrove);
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_home_screen_customer);

        recyclerView = findViewById(R.id.recyclerView);
        init = new MemoryInitializer();


        // Sample product list (replace with your actual product data)
        ArrayList<String> categoryList = generateCategories();
        GridLayoutManager layoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(layoutManager);
        // Initialize the adapter with the product list
        categoryAdapter = new CategoryAdapter(new ArrayList<String>(categoryList), this);

        // Set the layout manager and adapter to the RecyclerView
        //recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(categoryAdapter);


        presenter = new HomeScreenPresenter(this, init.getCustomerDAO(), init.getEmployerDAO());

        TabLayout tabLayout = findViewById(R.id.CustomerHomePageTabLayout);

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
                        break;
                    case 3:
                        presenter.onMyAccount();
                        break;
                    // Add cases for other tabs as needed
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

        searchListView = (SearchView) findViewById(R.id.home_screen_search_bar);
        searchListView.setIconifiedByDefault(false);
        searchListView.setOnQueryTextListener(this);
    }

    private ArrayList<String> generateCategories() {
        ArrayList<String> categories = new ArrayList<>();
        categories.add("all");
        categories.add("box");
        categories.add("cpu");
        categories.add("motherboard");
        categories.add("ram");
        categories.add("vga");
        categories.add("disk");
        categories.add("trofodotiko");
        categories.add("cooler");
        return categories;
    }

    @Override
    public void onCategoryClick(String category) {
        // Handle the clicked category here
        Log.d("Category Clicked", category);
        if(category.equals("all")) {
            presenter.onAll();
        }else if(category.equals("box")) {
            presenter.onDisplayProducts("case tower");
        }else if(category.equals("disk")) {
            presenter.onDisplayProducts("disk ssd");
        }else {
            presenter.onDisplayProducts(category);
        }

    }

    @Override
    public void All() {
        productAdapter = new ProductAdapter(new ArrayList<ProductType>(init.getComponentDAO().findAll()),this);
        recyclerView.setAdapter(productAdapter);
    }

    @Override
    public void displayProducts(String filter) {
        searchComponents(filter);
    }

    @Override
    public void Cart() {
        Log.d("HomeScreenActivity", "Cart");
        Intent intent = new Intent(HomeScreenActivity.this, CartActivity.class);
        startActivity(intent);
    }

    @Override
    public void goToHome() {
        Intent intent = new Intent(this, HomeScreenActivity.class);
        startActivity(intent);
    }

    @Override
    public void goToMyAccount() {
        Intent intent = new Intent(this, MyAccountActivity.class);
        startActivity(intent);
    }

    public boolean onQueryTextChange(String text)
    {
        if (text.isEmpty()) {
            // The query is empty, meaning the "X" button was clicked
            Log.d("SearchView", "SearchView closed (X button clicked)");
            // Perform any additional actions here
            recyclerView.setAdapter(categoryAdapter);
        }
        return true;
    }


    public boolean onQueryTextSubmit(String query) {
        submittedText = query;
        searchComponents(submittedText);
        Log.d("SearchView", "Query submitted: " + query);
        return true;
    }

    public boolean onClose(){
        recyclerView.setAdapter(categoryAdapter);
        return true;
    }

    private void searchComponents(String query) {
        ArrayList<Component> searchResults = new ArrayList<>();
        ArrayList<Component> allComponents = init.getComponentDAO().findAll();

        String[] queries = query.split(" ");


        for (Component component : allComponents) {
            for(String q : queries){
                if (component.getName().toLowerCase().contains(q.toLowerCase()) ||
                        (String.valueOf(component.getModelNo())).equals(q.toLowerCase())) {
                    searchResults.add(component);
                }
            }
        }

        updateUI(searchResults);
    }

    private void updateUI(ArrayList<Component> searchResults) {
        if (searchResults.isEmpty()) {
            TextView noResultsTextView = findViewById(R.id.homeScreen_noResultsTextView);
            noResultsTextView.setVisibility(View.VISIBLE);
            recyclerView.setVisibility(View.GONE);
        } else {
            findViewById(R.id.homeScreen_noResultsTextView).setVisibility(View.GONE);
            recyclerView.setVisibility(View.VISIBLE);

            productAdapter = new ProductAdapter(new ArrayList<ProductType>(searchResults), this);
            recyclerView.setAdapter(productAdapter);
        }
    }

    @Override
    public void onProductClick(ProductType product) {
        Intent intent = new Intent(this, ProductActivity.class);
        intent.putExtra("modelNo",product.getModelNo() );
        startActivity(intent);
    }

}

