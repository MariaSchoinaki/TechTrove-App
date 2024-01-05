package com.example.tecktrove.view.Synthesis;

import android.app.AlertDialog;
import android.os.Bundle;
import android.util.Log;
import android.util.Pair;

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
import com.example.tecktrove.view.Authentication.SignUp.SignUpActivity;
import com.example.tecktrove.view.CartProductAdapter;
import com.example.tecktrove.view.CategoryAdapter;
import com.example.tecktrove.view.ProductAdapter;

import java.util.ArrayList;

public class SynthesisActivity extends AppCompatActivity implements SynthesisView, CategoryAdapter.OnCategoryClickListener, ProductAdapter.OnProductClickListener {
    private RecyclerView recyclerView1;
    private RecyclerView recyclerView2;
    private Initializer init;

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

        GridLayoutManager layoutManager = new GridLayoutManager(this, 1);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,recyclerView1.HORIZONTAL,false);

        recyclerView1.setLayoutManager(linearLayoutManager);
        recyclerView2.setLayoutManager(layoutManager);

        init = new MemoryInitializer();
        componentDAO = new ComponentDAOMemory();

        productAdapter = new ProductAdapter(new ArrayList<ProductType>(componentDAO.findAll()), this);
        categoryAdapter = new CategoryAdapter(generateCategories(),this);

        recyclerView1.setAdapter(categoryAdapter);
        recyclerView2.setAdapter(productAdapter);

        synthesis = new Synthesis();

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
        categories.add("synthesis");
        return categories;
    }



    @Override
    public void onProductClick(ProductType product) {
        compatibilityCheck((Component)product);

    }

    @Override
    public void onCategoryClick(String category) {


    }


    public void showErrorMessage(String title, String msg) {
        new AlertDialog.Builder(SynthesisActivity.this)
                .setCancelable(true)
                .setTitle(title)
                .setMessage(msg)
                .setPositiveButton(R.string.ok, null).create().show();
    }

    private void compatibilityCheck(Component component){
    if(this.synthesis.getComponentList().size()>0){
        int compatible = 0;
        for(Component comp: this.synthesis.getComponentList()){
            if (component.getRequiredPorts().getPorts().size()==0){
                compatible++;

            }else{
                for(com.example.tecktrove.util.Pair<String,Integer>pair: comp.getAvailablePorts().getPorts()){
                    for (com.example.tecktrove.util.Pair<String,Integer>pair1: component.getRequiredPorts().getPorts()){
                        if (pair.equals(pair1)){
                            compatible++;
                        }
                    }

                }
            }
        }
        if(compatible>0){
            showErrorMessage("Προσοχή!","Το προϊόν θα αποθηκευτεί στην σύνθεση!");
            synthesis.add(component);
        }else {
            showErrorMessage("Προσοχή!","Το προϊόν δεν ειναι συμβατό με την σύνθεση!");
        }
    }else{
        showErrorMessage("Προσοχή!","Το προϊόν θα αποθηκευτεί στην σύνθεση!");
        synthesis.add(component);
    }
    }
}
