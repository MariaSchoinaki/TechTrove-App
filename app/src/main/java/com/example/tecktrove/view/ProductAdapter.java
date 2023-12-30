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
            holder.bindProduct(firstProduct, firstProductPosition);
        }

        // Bind data to the ViewHolder for the second product in the row
        if (secondProductPosition < productList.size()) {
            ProductType secondProduct = productList.get(secondProductPosition);
            holder.bindProduct(secondProduct, secondProductPosition);
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
        void bindProduct(ProductType product, int position) {
            if (position % 2 == 0) {
                // Even position, use views for the second product
                productNameTextView = itemView.findViewById(R.id.productName2);
                productImageView = itemView.findViewById(R.id.productImage2);
            } else {
                // Odd position, use views for the first product
                productNameTextView = itemView.findViewById(R.id.productName1);
                productImageView = itemView.findViewById(R.id.productImage1);
            }
            productNameTextView.setText(product.getName());
            String s = product.getImg();
            //productImageView.setImageResource(R.drawable.s);
            // You can add more bindings here based on your product data
        }
    }
}
