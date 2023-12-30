package com.example.tecktrove.view;

import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.tecktrove.R;
import com.example.tecktrove.domain.ProductType;

import java.util.ArrayList;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder> {

    private ArrayList<String> categoryList;
    private OnCategoryClickListener onCategoryClickListener;

    public interface OnCategoryClickListener {
        void onCategoryClick(String category);
    }


    public CategoryAdapter(ArrayList<String> categoryList,OnCategoryClickListener onCategoryClickListener) {
        this.categoryList = categoryList;
        this.onCategoryClickListener = onCategoryClickListener;
    }


    @Override
    public CategoryViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_product, parent, false);

        return new CategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder( CategoryViewHolder holder, int position) {

        int CategoryPosition = position;
        String Category = categoryList.get(CategoryPosition);
        holder.bindCategory(Category);

    }

    @Override
    public int getItemCount() {
        Log.d("CategoryAdapter", "count");
        return categoryList.size();
    }

    public class CategoryViewHolder extends RecyclerView.ViewHolder {
        TextView categoryName;
        ImageView categoryImage;

        public CategoryViewHolder( View itemView) {
            super(itemView);
            categoryName = itemView.findViewById(R.id.productName1);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Get the clicked category based on the adapter position
                    int adapterPosition = getAdapterPosition();
                    if (adapterPosition != RecyclerView.NO_POSITION) {
                        // Calculate the correct clicked category index based on the position

                        int clickedCategoryIndex = adapterPosition;

                        // Check if the clicked position is within the bounds of the category list
                        if (clickedCategoryIndex < categoryList.size()) {
                            String clickedCategory = categoryList.get(clickedCategoryIndex);
                            // Notify the click listener with the clicked category
                            onCategoryClickListener.onCategoryClick(clickedCategory);
                        }
                    }
                }
            });
        }

        void bindCategory(String category) {
                    // Odd position, use views for the first product
            categoryName = itemView.findViewById(R.id.productName1);
            categoryImage = itemView.findViewById(R.id.productImage1);

            categoryName.setText(category);
            int resId = itemView.getResources().getIdentifier(category.toLowerCase(), "drawable", itemView.getContext().getPackageName());

            // Set the image based on the resource identifier
            if (resId != 0) {
                categoryImage.setImageResource(resId);
            }




            // You can add click listeners or other bindings here if needed
        }
    }
}
