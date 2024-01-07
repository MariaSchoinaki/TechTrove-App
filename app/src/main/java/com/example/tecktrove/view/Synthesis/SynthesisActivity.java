package com.example.tecktrove.view.Synthesis;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tecktrove.R;
import com.example.tecktrove.dao.ComponentDAO;
import com.example.tecktrove.dao.Initializer;
import com.example.tecktrove.dao.SynthesisDAO;
import com.example.tecktrove.domain.Component;
import com.example.tecktrove.domain.ProductType;
import com.example.tecktrove.domain.Synthesis;
import com.example.tecktrove.memorydao.ComponentDAOMemory;
import com.example.tecktrove.memorydao.MemoryInitializer;
import com.example.tecktrove.memorydao.SynthesisDAOMemory;
import com.example.tecktrove.view.Authentication.LogIn.LogInActivity;
import com.example.tecktrove.view.Authentication.SignUp.SignUpActivity;
import com.example.tecktrove.view.CartProductAdapter;
import com.example.tecktrove.view.CategoryAdapter;
import com.example.tecktrove.view.ProductAdapter;

import java.util.ArrayList;

public class SynthesisActivity extends AppCompatActivity implements SynthesisView, CategoryAdapter.OnCategoryClickListener, ProductAdapter.OnProductClickListener {
    private RecyclerView recyclerView1;
    private RecyclerView recyclerView2;
    private Initializer init;
    private SynthesisPresenter presenter;
    private ComponentDAO componentDAO;
    private CartProductAdapter CartproductAdapter;

    private SynthesisDAO synthesisDao;
    private ProductAdapter productAdapter;

    private CategoryAdapter categoryAdapter;

    private Synthesis synthesis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_synthesis);

        recyclerView1 = findViewById(R.id.recyclerView5);
        recyclerView2 = findViewById(R.id.recyclerView7);

        GridLayoutManager layoutManager = new GridLayoutManager(this, 2);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,recyclerView1.HORIZONTAL,false);

        recyclerView1.setLayoutManager(linearLayoutManager);
        recyclerView2.setLayoutManager(layoutManager);

        init = new MemoryInitializer();
        componentDAO = new ComponentDAOMemory();
        synthesisDao = new SynthesisDAOMemory();

        productAdapter = new ProductAdapter(new ArrayList<ProductType>(componentDAO.findAll()), this);
        categoryAdapter = new CategoryAdapter(generateCategories(),this);

        recyclerView1.setAdapter(categoryAdapter);
        recyclerView2.setAdapter(productAdapter);

        presenter = new SynthesisPresenter(componentDAO,synthesisDao,this);

        findViewById(R.id.completeted).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                presenter.onSynthesisDisplay();
            }
        });

    }


    private ArrayList<String> generateCategories() {
        ArrayList<String> categories = new ArrayList<>();
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
    public void onProductClick(ProductType product) {
        if(presenter.compatibilityCheck((Component)product)){
            showErrorMessage("Προσοχή!","Το προϊόν θα αποθηκευτεί στην σύνθεση!");
            presenter.saveToSynthesis((Component) product);
        }else {
            showErrorMessage("Προσοχή!","Το προϊόν δεν είναι συμβατό με την σύνθεση!");
        }

    }

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
    @Override
    public void showErrorMessage(String title, String msg) {
        new AlertDialog.Builder(SynthesisActivity.this)
                .setCancelable(true)
                .setTitle(title)
                .setMessage(msg)
                .setPositiveButton(R.string.ok, null).create().show();
    }
    @Override
    public void displayProducts(ArrayList<ProductType> products) {
        updateUI(products);
    }

    @Override
    public void updateUI(ArrayList<ProductType> searchResults) {
            productAdapter = new ProductAdapter(searchResults, this);
            recyclerView2.setAdapter(productAdapter);
    }

    @Override
    public void synthesisDisplay(){
        Intent intent = new Intent(this, SynthesisContainerActivity.class);
        startActivity(intent);
    }



}
