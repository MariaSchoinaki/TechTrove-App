package com.example.tecktrove.view.HomeScreen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.tecktrove.R;
import com.example.tecktrove.domain.Component;
import com.example.tecktrove.domain.OrderLine;
import com.example.tecktrove.domain.ProductType;
import com.example.tecktrove.util.Money;
import com.example.tecktrove.util.Port;
import com.example.tecktrove.view.ProductAdapter;

import java.math.BigDecimal;
import java.util.ArrayList;

public class HomeScreenActivity extends AppCompatActivity implements HomeScreenView{

    private RecyclerView recyclerView;
    private ProductAdapter productAdapter;

    public HomeScreenActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.Base_Theme_TeckTrove);
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.home);

        recyclerView = findViewById(R.id.recyclerView);

        // Sample product list (replace with your actual product data)
        ArrayList<ProductType> productList = generateSampleProducts();

        // Initialize the adapter with the product list
        productAdapter = new ProductAdapter(productList);

        // Set the layout manager and adapter to the RecyclerView
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(productAdapter);

        HomeScreenPresenter presenter = new HomeScreenPresenter(this);
    }

    private ArrayList<ProductType> generateSampleProducts() {
        // Create and return a list of sample products
        // Replace this with your actual product data retrieval logic
        ArrayList<ProductType> productList = new ArrayList<ProductType>();
        productList.add(new Component(235456, Money.euros(BigDecimal.valueOf(30.5)) , "AMD Ryzen 7", "Επεξεργαστής 8 Πυρήνων για Socket AM4 σε Κουτί", "AMD", new Port(), new Port(), 10 ));
        productList.add(new Component(12345, Money.euros(BigDecimal.valueOf(20)) , "Ryzen 7 5800 X", "Επεξεργαστής", "AMD", new Port(), new Port() ,5));
        productList.add(new Component(32345, Money.euros(BigDecimal.valueOf(20)) , "Ryzen 7 5800 X", "Επεξεργαστής", "AMD", new Port(), new Port() ,5));
        productList.add(new Component(42345, Money.euros(BigDecimal.valueOf(20)) , "Ryzen 7 5800 X", "Επεξεργαστής", "AMD", new Port(), new Port() ,5));
        productList.add(new Component(62345, Money.euros(BigDecimal.valueOf(20)) , "Ryzen 7 5800 X", "Επεξεργαστής", "AMD", new Port(), new Port() ,5));
        productList.add(new Component(72345, Money.euros(BigDecimal.valueOf(20)) , "Ryzen 7 5800 X", "Επεξεργαστής", "AMD", new Port(), new Port() ,5));
        productList.add(new Component(02345, Money.euros(BigDecimal.valueOf(20)) , "Ryzen 7 5800 X", "Επεξεργαστής", "AMD", new Port(), new Port() ,5));
        productList.add(new Component(62345, Money.euros(BigDecimal.valueOf(20)) , "Ryzen 7 5800 X", "Επεξεργαστής", "AMD", new Port(), new Port() ,5));

        return productList;
    }

}