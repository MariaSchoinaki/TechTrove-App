package com.example.tecktrove.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tecktrove.R;
import com.example.tecktrove.domain.Order;
import com.example.tecktrove.domain.ProductType;

import java.util.ArrayList;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.OrderViewHolder>{
    private ArrayList<Order> OrderList;

    private OnOrderClickListener onOrderClickListener;

    public interface OnOrderClickListener {
        void onOrderClick(Order Order);
    }

   public OrderAdapter(ArrayList<Order> OrderList , OnOrderClickListener onOrderClickListener){
        this.OrderList=OrderList;
        this.onOrderClickListener=onOrderClickListener;
   }
    @Override
    public OrderAdapter.OrderViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.order_item, parent, false);
        return new OrderAdapter.OrderViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull OrderViewHolder holder, int position) {
        int ProductPosition = position;
        Order order = OrderList.get(ProductPosition);
        holder.bindOrder(order);
    }


    @Override
    public int getItemCount() {
        return OrderList.size();
    }


    public class OrderViewHolder extends RecyclerView.ViewHolder {

        TextView orderDateTextView;
        ImageView orderImageView;
        TextView orderPriceTextView;
        public OrderViewHolder( View itemView){
            super(itemView);
            orderImageView = itemView.findViewById(R.id.productImage1);
            orderPriceTextView = itemView.findViewById(R.id.order_price);
            orderDateTextView = itemView.findViewById(R.id.orderDate);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int adapterPosition = getAdapterPosition();
                    if (adapterPosition != RecyclerView.NO_POSITION) {

                        int clickedProductIndex = adapterPosition;

                        if (clickedProductIndex < OrderList.size()) {
                            Order clickedOreder = OrderList.get(clickedProductIndex);
                            onOrderClickListener.onOrderClick(clickedOreder);
                        }
                    }
                }
            });
        }
        void bindOrder(Order order){
            orderDateTextView = itemView.findViewById(R.id.orderDate);
            orderImageView = itemView.findViewById(R.id.productImage1);
            orderPriceTextView = itemView.findViewById(R.id.order_price);

            orderDateTextView.setText(order.getDate().toString());
            orderPriceTextView.setText(order.getTotal().toString());

        }
    }



    }

