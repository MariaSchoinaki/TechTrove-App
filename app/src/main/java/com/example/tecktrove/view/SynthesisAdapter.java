package com.example.tecktrove.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tecktrove.R;
import com.example.tecktrove.domain.OrderLine;

import java.util.ArrayList;

public class SynthesisAdapter extends CartProductAdapter{
    public SynthesisAdapter(ArrayList<OrderLine> productList, OnCartProductClickListener onCategoryClickListener) {
        super(productList, onCategoryClickListener);
    }

    @Override
    public CartProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.upload_item, parent, false);
        return new CartProductViewHolder(view);
    }
}
