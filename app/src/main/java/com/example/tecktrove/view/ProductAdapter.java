package com.example.tecktrove.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.tecktrove.R;
import com.example.tecktrove.domain.ProductType;

import java.util.ArrayList;

// ProductAdapter.java
public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {

    private ArrayList<ProductType> productList; // Assume you have a Product class

    public ProductAdapter(ArrayList<ProductType> productList) {
        this.productList = productList;
    }


    @Override
    public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_product, parent, false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ProductViewHolder holder, int position) {
        int firstProductPosition = position * 2;
        int secondProductPosition = firstProductPosition + 1;

        // Bind data to the ViewHolder for the first product in the row
        if (firstProductPosition < productList.size()) {
            ProductType firstProduct = productList.get(firstProductPosition);
            holder.bindProduct(firstProduct);
        }

        // Bind data to the ViewHolder for the second product in the row
        if (secondProductPosition < productList.size()) {
            ProductType secondProduct = productList.get(secondProductPosition);
            holder.bindProduct(secondProduct);
        }
    }

    @Override
    public int getItemCount() {
        return (int) Math.ceil(productList.size() / 2.0);
    }

    static class ProductViewHolder extends RecyclerView.ViewHolder {

        TextView productNameTextView;
        ImageView productImageView;

        public ProductViewHolder(View itemView) {
            super(itemView);
            productNameTextView = itemView.findViewById(R.id.productName1);
            productImageView = itemView.findViewById(R.id.productImage1);
        }

        // Helper method to bind product data to the views
        void bindProduct(ProductType product) {
            productNameTextView.setText(product.getName());
            //productImageView.setImageResource(product.getProductImage());
            // You can add more bindings here based on your product data
        }
    }
}
