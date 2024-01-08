package com.example.tecktrove.view.Employer.HomeScreen;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.SearchView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.tecktrove.R;
import com.example.tecktrove.dao.Initializer;
import com.example.tecktrove.domain.ProductType;
import com.example.tecktrove.memorydao.ComponentDAOMemory;
import com.example.tecktrove.memorydao.MemoryInitializer;
import com.example.tecktrove.memorydao.SynthesisDAOMemory;
import com.example.tecktrove.view.CategoryAdapter;
import com.example.tecktrove.view.Employer.Product.AddProduct.AddProductActivity;
import com.example.tecktrove.view.MyAccount.MyAccountActivity;
import com.example.tecktrove.view.Employer.Product.ProductInformation.ProductActivity;
import com.example.tecktrove.view.ProductAdapter;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class HomeScreenActivity extends AppCompatActivity implements HomeScreenView, CategoryAdapter.OnCategoryClickListener, ProductAdapter.OnProductClickListener, SearchView.OnQueryTextListener, SearchView.OnCloseListener {
    private RecyclerView recyclerView;
    private CategoryAdapter categoryAdapter;
    private ProductAdapter productAdapter;
    private Initializer init;
    private HomeScreenPresenter presenter;
    private String submittedText;
    private SearchView searchListView;

    /**
     * Initializes the classes attributes
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.Base_Theme_TeckTrove);
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_home_screen_employer);

        recyclerView = findViewById(R.id.home_screen_employer_recyclerView);
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


        presenter = new HomeScreenPresenter(this, init.getCustomerDAO(), init.getEmployerDAO(), new ComponentDAOMemory(), new SynthesisDAOMemory());

        TabLayout tabLayout = findViewById(R.id.home_screen_employer_tabs);

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
                        presenter.onAddProduct();
                        break;
                    case 2:
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

        findViewById(R.id.home_screen_employer_back_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.onBack();
            }
        });

        searchListView = (SearchView) findViewById(R.id.home_screen_employer_search_bar);
        searchListView.setIconifiedByDefault(false);
        searchListView.setOnQueryTextListener(this);
    }

    /**
     * Puts in an ArrayList the categories of the eshop products
     * @return the catogories
     */
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
        categories.add("synthesis");
        return categories;
    }

    /**
     * Displays the clicked categories products
     * @param category
     */
    @Override
    public void onCategoryClick(String category) {
        if(category.equals("box")) {
            presenter.onDisplayProducts("case tower");
        }else if(category.equals("disk")) {
            presenter.onDisplayProducts("disk ssd");
        }else {
            presenter.onDisplayProducts(category);
        }
    }

    /**
     * Displayes the products
     * @param products the products
     */
    @Override
    public void displayProducts(ArrayList<ProductType> products) {
        updateUI(products);
    }

    /**
     * Navigates the user to the home screen
     */
    @Override
    public void goToHome() {
        Intent intent = new Intent(this, HomeScreenActivity.class);
        startActivity(intent);
    }

    /**
     * Navigates the user to the my account
     */
    @Override
    public void goToMyAccount() {
        Intent intent = new Intent(this, MyAccountActivity.class);
        startActivity(intent);
    }

    /**
     * Navigates the app to the add product form
     */
    @Override
    public void goToAddProduct() {
        Intent intent = new Intent(this, AddProductActivity.class);
        startActivity(intent);
    }

    /**
     * Goes on the previous page
     */
    @Override
    public void goBack() {
        recyclerView.setAdapter(categoryAdapter);
    }

    /**
     * If the search is empty show the categories
     * @param text
     * @return
     */
    public boolean onQueryTextChange(String text)
    {
        if (text.isEmpty()) {
            recyclerView.setAdapter(categoryAdapter);
        }
        return true;
    }

    /**
     * When search input is put it displays the products cooresponding to the input
     * @param query
     * @return
     */
    public boolean onQueryTextSubmit(String query) {
        presenter.onDisplayProducts(query);
        return true;
    }

    /**
     * When x is clicked it show the categories
     * @return
     */
    public boolean onClose(){
        recyclerView.setAdapter(categoryAdapter);
        return true;
    }

    /**
     * Updates the screen based on the search results
     * @param searchResults
     */
    private void updateUI(ArrayList<ProductType> searchResults) {
        if (searchResults.isEmpty()) {
            TextView noResultsTextView = findViewById(R.id.homeScreen_employer_noResultsTextView);
            noResultsTextView.setVisibility(View.VISIBLE);
            recyclerView.setVisibility(View.GONE);
        } else {
            findViewById(R.id.homeScreen_employer_noResultsTextView).setVisibility(View.GONE);
            recyclerView.setVisibility(View.VISIBLE);

            productAdapter = new ProductAdapter(searchResults, this);
            recyclerView.setAdapter(productAdapter);
        }
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
