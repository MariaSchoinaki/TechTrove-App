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
import java.text.SimpleDateFormat;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.OrderViewHolder>{
    private ArrayList<Order> OrderList;

    private OnOrderClickListener onOrderClickListener;

    public interface OnOrderClickListener {
        void onOrderClick(Order order);
    }

   public OrderAdapter(ArrayList<Order> OrderList , OnOrderClickListener onOrderClickListener){
        this.OrderList=OrderList;
        this.onOrderClickListener=onOrderClickListener;
   }
    @Override
    public OrderViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.order_item, parent, false);
        return new OrderViewHolder(view);
    }


    @Override
    public void onBindViewHolder(OrderViewHolder holder, int position) {
        int ProductPosition = position;
        Order order = OrderList.get(ProductPosition);
        holder.bindOrder(order);
    }


    @Override
    public int getItemCount() {
        return OrderList.size();
    }


    public class OrderViewHolder extends RecyclerView.ViewHolder {

        TextView orderDateTextView, orderNumberTextView;
        TextView orderPriceTextView;
        int clickedProductIndex;
        public OrderViewHolder( View itemView){
            super(itemView);
            orderPriceTextView = itemView.findViewById(R.id.order_price);
            orderDateTextView = itemView.findViewById(R.id.orderDate);
            orderNumberTextView = itemView.findViewById(R.id.orderNumber);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int adapterPosition = getAdapterPosition();
                    if (adapterPosition != RecyclerView.NO_POSITION) {

                        clickedProductIndex = adapterPosition;

                        if (clickedProductIndex < OrderList.size()) {
                            Order clickedOrder = OrderList.get(clickedProductIndex);
                            onOrderClickListener.onOrderClick(clickedOrder);
                        }
                    }
                }
            });
        }
        void bindOrder(Order order){
            orderDateTextView = itemView.findViewById(R.id.orderDate);
            orderNumberTextView = itemView.findViewById(R.id.orderNumber);
            orderPriceTextView = itemView.findViewById(R.id.order_price);

            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yy");
            orderDateTextView.setText(dateFormat.format(order.getDate().getJavaCalendar().getTime()));
            orderPriceTextView.setText(order.getTotal().toString());
            orderNumberTextView.setText(String.valueOf(clickedProductIndex+1));

        }
    }



    }

