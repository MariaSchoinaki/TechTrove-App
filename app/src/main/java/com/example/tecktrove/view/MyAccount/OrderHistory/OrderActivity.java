package com.example.tecktrove.view.MyAccount.OrderHistory;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tecktrove.R;
import com.example.tecktrove.domain.Component;
import com.example.tecktrove.domain.Order;
import com.example.tecktrove.domain.OrderLine;
import com.example.tecktrove.domain.ProductType;
import com.example.tecktrove.domain.Synthesis;
import com.example.tecktrove.memorydao.MemoryInitializer;
import com.example.tecktrove.memorydao.OrderDAOMemory;
import com.example.tecktrove.view.CartProductAdapter;
import com.example.tecktrove.view.OrderAdapter;
import com.example.tecktrove.view.ProductAdapter;
import com.example.tecktrove.view.SharedViewModel;
import com.example.tecktrove.view.SynthesisAdapter;

import java.util.ArrayList;

public class OrderActivity extends OrderHistoryActivity implements OrderView, CartProductAdapter.OnCartProductClickListener,ProductAdapter.OnProductClickListener {
    private RecyclerView recyclerView1;
    private RecyclerView recyclerView2;

    private SharedViewModel sharedViewModel;
    MemoryInitializer init;

    OrderDAOMemory orderDAO;



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
        ArrayList<OrderLine> syntheses = new ArrayList<OrderLine>();
        ArrayList<ProductType> components = new ArrayList<ProductType>();
        int orderid = getIntent().getIntExtra("orderid", 0);
        Order order = orderDAO.find(orderid);
        Log.d("Orderrrrrrr", String.valueOf(orderid));
        for(OrderLine orderLine : order.getOrderLines()){
            if(orderLine.getProductType().getClass().equals(Synthesis.class)){
                syntheses.add(orderLine);
            }else {
                components.add(orderLine.getProductType());
            }
        }

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,2);
        GridLayoutManager gridLayoutManager2 = new GridLayoutManager(this,1);
        recyclerView1.setLayoutManager(gridLayoutManager);
        recyclerView2.setLayoutManager(gridLayoutManager2);
        SynthesisAdapter adapter = new SynthesisAdapter(syntheses,this);
        ProductAdapter adapter1 = new ProductAdapter(components,this);
        recyclerView2.setAdapter(adapter1);
        recyclerView1.setAdapter(adapter);



    }



    @Override
    public void onCartProductClick(ProductType product) {

    }

    @Override
    public void onProductClick(ProductType product) {

    }
}
