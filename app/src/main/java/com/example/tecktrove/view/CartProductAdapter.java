package com.example.tecktrove.view;

import static android.app.PendingIntent.getActivity;
import static androidx.core.content.ContextCompat.startActivity;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tecktrove.util.Pair;
import com.example.tecktrove.R;
import com.example.tecktrove.domain.ProductType;
import com.example.tecktrove.view.Customer.Cart.CartActivity;
import java.util.ArrayList;

public class CartProductAdapter extends RecyclerView.Adapter<CartProductAdapter.CartProductViewHolder>{

    private ArrayList<Pair<ProductType,Integer>> productList;
    private CartProductAdapter.OnCartProductClickListener onProductClickListener;

    public interface OnCartProductClickListener {
        void onCartProductClick(ProductType product);
    }
    public CartProductAdapter(ArrayList<Pair<ProductType,Integer>> productList, OnCartProductClickListener onCategoryClickListener) {
        this.productList = productList;
        this.onProductClickListener = onCategoryClickListener;

    }

    @Override
    public CartProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cart_product, parent, false);
        return new CartProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CartProductViewHolder holder, int position) {
        int ProductPosition = position;

        // Bind data to the ViewHolder for the first product in the row
        ProductType Product = productList.get(ProductPosition).getFirst();
        SharedViewModel viewModel = new SharedViewModel();
        holder.bindProduct(Product);
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }



    class CartProductViewHolder extends RecyclerView.ViewHolder {
        TextView productPriceView;
        TextView productQuantityView;

        TextView productNameTextView;
        ImageView productImageView;


        public CartProductViewHolder(View itemView) {
            super(itemView);
            productPriceView = itemView.findViewById(R.id.product_price);
            productQuantityView = itemView.findViewById(R.id.item_cart_quantity);
            productNameTextView = itemView.findViewById(R.id.productName1);
            productImageView = itemView.findViewById(R.id.productImage1);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    int adapterPosition = getAdapterPosition();
                    if (adapterPosition != RecyclerView.NO_POSITION) {

                        int clickedProductIndex = adapterPosition;

                        if (clickedProductIndex < productList.size()) {
                            ProductType clickedProduct = productList.get(clickedProductIndex).getFirst();
                            onProductClickListener.onCartProductClick(clickedProduct);
                        }
                    }
                }
            });
        



        }
        


        void bindProduct(ProductType product) {

            productNameTextView = itemView.findViewById(R.id.productName1);
            productImageView = itemView.findViewById(R.id.productImage1);
            productPriceView = itemView.findViewById(R.id.product_price);
            productQuantityView = itemView.findViewById(R.id.item_cart_quantity);

            SharedViewModel sharedViewModel = new SharedViewModel();

            productPriceView.setText(product.getPrice().toString());
            productNameTextView.setText(product.getName());
            int i = sharedViewModel.getCustomer().getCart().indexOf(sharedViewModel.getCustomer().getProductFromCart(product.getModelNo()));
            productQuantityView.setText("x"+sharedViewModel.getCustomer().getCart().get(i).getSecond());

            itemView.findViewById(R.id.remove_button).setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {
                    SharedViewModel sharedViewModel = new SharedViewModel();
                    sharedViewModel.getCustomer().getCart().remove(sharedViewModel.getCustomer().getProductFromCart(product.getModelNo()));

                    Intent intent = new Intent(view.getContext(), CartActivity.class);
                    startActivity(view.getContext(),intent,null);
                }
            });


        }
    }
}
