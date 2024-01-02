package com.example.tecktrove.view.cart;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tecktrove.R;
import com.example.tecktrove.dao.Initializer;
import com.example.tecktrove.domain.Component;
import com.example.tecktrove.domain.ProductType;
import com.example.tecktrove.memorydao.ComponentDAOMemory;
import com.example.tecktrove.memorydao.MemoryInitializer;
import com.example.tecktrove.view.HomeScreen.HomeScreenActivity;
import com.example.tecktrove.dao.ComponentDAO;
import com.example.tecktrove.view.ProductAdapter;

import java.util.ArrayList;

public class CartActivity extends AppCompatActivity implements CartView{
    private RecyclerView recyclerView;
    private ProductAdapter productAdapter;
    private Initializer init;

    private ComponentDAO componentDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.Base_Theme_TeckTrove);
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.cart);

        recyclerView = findViewById(R.id.recyclerView);
        init = new MemoryInitializer();
        componentDAO = new ComponentDAOMemory();

        ArrayList<ProductType> items = getSelectedItems();
        GridLayoutManager layoutManager = new GridLayoutManager(this, 1);
        recyclerView.setLayoutManager(layoutManager);
        productAdapter = new ProductAdapter(new ArrayList<ProductType>(componentDAO.findAll()));
        recyclerView.setAdapter(productAdapter);




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
    public void cart() {

    }
}
