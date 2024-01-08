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
import com.example.tecktrove.domain.ProductType;
import com.example.tecktrove.memorydao.ComponentDAOMemory;
import com.example.tecktrove.memorydao.MemoryInitializer;
import com.example.tecktrove.memorydao.OrderDAOMemory;
import com.example.tecktrove.view.OrderAdapter;
import com.example.tecktrove.view.ProductAdapter;
import com.example.tecktrove.view.SharedViewModel;

import java.util.ArrayList;

public class OrderHistoryActivity extends AppCompatActivity implements OrderHistoryView, OrderAdapter.OnOrderClickListener {
    private RecyclerView recyclerView;

    private Initializer init;

    private OrderDAO orderDAO;

    protected Order order ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.Base_Theme_TeckTrove);
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.order_istory);

        recyclerView = findViewById(R.id.Order_container);
        init = new MemoryInitializer();
        orderDAO = new OrderDAOMemory();
        SharedViewModel sharedViewModel = new ViewModelProvider(this).get(SharedViewModel.class);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,1);
        recyclerView.setLayoutManager(gridLayoutManager);
        OrderAdapter adapter = new OrderAdapter(new ArrayList<Order>(orderDAO.findByCustomer(sharedViewModel.getCustomer())),this);
        recyclerView.setAdapter(adapter);

    }


    @Override
    public void onOrderClick(Order Order) {
        SharedViewModel.setOrder(order);
        Intent intent = new Intent(this,OrderActivity.class);
        startActivity(intent);
    }
}
