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
import com.example.tecktrove.domain.Synthesis;

import java.util.ArrayList;

public class OrderSynthesisAdapter extends RecyclerView.Adapter<OrderSynthesisAdapter.OrderSynthesisViewHolder>{

    private ArrayList<Synthesis> synthesis;
    private OrderSynthesisAdapter.OnPublishClickListener onPublishClickListener;

    public interface OnPublishClickListener {
        void onPublishClickListener(Synthesis synthesis);
    }

    public OrderSynthesisAdapter(ArrayList<Synthesis> synthesis, OrderSynthesisAdapter.OnPublishClickListener onPublishClickListener) {
        this.synthesis = synthesis;
        this.onPublishClickListener = onPublishClickListener;
    }

    @Override
    public OrderSynthesisAdapter.OrderSynthesisViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.upload_item, parent, false);
        return new OrderSynthesisAdapter.OrderSynthesisViewHolder(view);
    }

    @Override
    public void onBindViewHolder(OrderSynthesisAdapter.OrderSynthesisViewHolder holder, int position) {
        int ProductPosition = position;

        // Bind data to the ViewHolder for the first product in the row
        Synthesis synthesisI = synthesis.get(ProductPosition);
        holder.bindProduct(synthesisI);
    }

    @Override
    public int getItemCount() {
        return synthesis.size();
    }

    class OrderSynthesisViewHolder extends RecyclerView.ViewHolder {

        TextView productNameTextView, productQuantityTextView, productPriceTextView;
        ImageView productImageView;

        public OrderSynthesisViewHolder(View itemView) {
            super(itemView);
            productNameTextView = itemView.findViewById(R.id.productName1);
            productImageView = itemView.findViewById(R.id.productImage1);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int adapterPosition = getAdapterPosition();
                    if (adapterPosition != RecyclerView.NO_POSITION) {

                        int clickedProductIndex = adapterPosition;

                        if (clickedProductIndex < synthesis.size()) {
                            Synthesis clickedProduct = synthesis.get(clickedProductIndex);
                            onPublishClickListener.onPublishClickListener(clickedProduct);
                        }
                    }
                }
            });
        }

        // Helper method to bind product data to the views
        void bindProduct(Synthesis product) {
            productNameTextView = itemView.findViewById(R.id.productName1);
            productImageView = itemView.findViewById(R.id.productImage1);
            productQuantityTextView = itemView.findViewById(R.id.upload_item_cart_quantity);
            productPriceTextView = itemView.findViewById(R.id.upload_product_price);

            productNameTextView.setText(product.getName());
            productQuantityTextView.setText(String.valueOf(product.getQuantity()));
            productPriceTextView.setText(product.getPrice().toString());
        }
    }
}
