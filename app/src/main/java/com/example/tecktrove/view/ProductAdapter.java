package com.example.tecktrove.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.tecktrove.R;
import com.example.tecktrove.domain.Component;
import com.example.tecktrove.domain.ProductType;

import java.util.ArrayList;

// ProductAdapter.java
public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {

    private ArrayList<ProductType> productList;
    private OnProductClickListener onProductClickListener;

    public interface OnProductClickListener {
        void onProductClick(ProductType product);
    }


    public ProductAdapter(ArrayList<ProductType> productList, OnProductClickListener onCategoryClickListener) {
        this.productList = productList;
        this.onProductClickListener = onCategoryClickListener;
    }


    @Override
    public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_product, parent, false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ProductViewHolder holder, int position) {
        int ProductPosition = position;

        // Bind data to the ViewHolder for the first product in the row
        ProductType Product = productList.get(ProductPosition);
        holder.bindProduct(Product);
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    class ProductViewHolder extends RecyclerView.ViewHolder {

        TextView productNameTextView;
        ImageView productImageView;

        public ProductViewHolder(View itemView) {
            super(itemView);
            productNameTextView = itemView.findViewById(R.id.productName1);
            productImageView = itemView.findViewById(R.id.productImage1);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int adapterPosition = getAdapterPosition();
                    if (adapterPosition != RecyclerView.NO_POSITION) {

                        int clickedProductIndex = adapterPosition;

                        if (clickedProductIndex < productList.size()) {
                            ProductType clickedProduct = productList.get(clickedProductIndex);
                            onProductClickListener.onProductClick(clickedProduct);
                        }
                    }
                }
            });
        }

        // Helper method to bind product data to the views
        void bindProduct(ProductType product) {
            productNameTextView = itemView.findViewById(R.id.productName1);
            productImageView = itemView.findViewById(R.id.productImage1);

            productNameTextView.setText(product.getName());
            int resId = itemView.getResources().getIdentifier("c" + String.valueOf(product.getModelNo()), "drawable", itemView.getContext().getPackageName());

            // Set the image based on the resource identifier
            if (resId != 0 && (product instanceof Component)) {
                productImageView.setImageResource(resId);
            }
        }
    }
}
