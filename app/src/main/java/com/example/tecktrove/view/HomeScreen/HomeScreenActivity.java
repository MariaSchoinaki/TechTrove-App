package com.example.tecktrove.view.HomeScreen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.tecktrove.R;
import com.example.tecktrove.dao.Initializer;
import com.example.tecktrove.domain.Component;
import com.example.tecktrove.domain.OrderLine;
import com.example.tecktrove.domain.ProductType;
import com.example.tecktrove.memorydao.MemoryInitializer;
import com.example.tecktrove.util.Money;
import com.example.tecktrove.util.Port;
import com.example.tecktrove.view.CategoryAdapter;
import com.example.tecktrove.view.ProductAdapter;

import java.math.BigDecimal;
import java.util.ArrayList;

public class HomeScreenActivity extends AppCompatActivity implements HomeScreenView, CategoryAdapter.OnCategoryClickListener{

    private RecyclerView recyclerView;
    private CategoryAdapter categoryAdapter;
    private ProductAdapter productAdapter;
    private Initializer init;
    private HomeScreenPresenter presenter;

    public HomeScreenActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.Base_Theme_TeckTrove);
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.home);

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
        switch (category){
            case "all":
                presenter.onAll();
                break;
            case "ram":
                presenter.onRam();
                break;
            case "cpu":
                presenter.onCpu();
                break;
            case "box":
                presenter.onBox();
                break;
            case "motherboard":
                presenter.onMotherboard();
                break;
            case "vga":
                presenter.onVga();
                break;
            case "disk":
                presenter.onDisk();
                break;
            case "cooler":
                presenter.onCooler();
                break;
            case "trofodotiko":
                presenter.ontrofodotiko();
                break;
        }
    }

    @Override
    public void All() {
        productAdapter = new ProductAdapter(new ArrayList<ProductType>(init.getComponentDAO().findAll()));
        recyclerView.setAdapter(productAdapter);
    }

    @Override
    public void Ram() {

    }

    @Override
    public void Cpu() {

    }

    @Override
    public void Box() {

    }

    @Override
    public void Motherboard() {

    }

    @Override
    public void Vga() {

    }

    @Override
    public void Disk() {

    }

    @Override
    public void Cooler() {

    }

    @Override
    public void trofodotiko() {

    }
}