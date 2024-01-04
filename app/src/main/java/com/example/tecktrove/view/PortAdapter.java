package com.example.tecktrove.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.tecktrove.R;
import com.example.tecktrove.util.Pair;
import com.example.tecktrove.util.Port;

import java.util.ArrayList;

public class PortAdapter extends RecyclerView.Adapter<PortAdapter.PortViewHolder> {

    private Port ports;

    public PortAdapter(Port ports) {
        this.ports = ports;
    }

    @Override
    public PortAdapter.PortViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_port, parent, false);
        return new PortAdapter.PortViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PortAdapter.PortViewHolder holder, int position) {
        int port = position;

        // Bind data to the ViewHolder for the first product in the row
        Pair p= ports.getPorts().get(port);
        holder.bindProduct(p);
    }

    @Override
    public int getItemCount() {
        return ports.getPorts().size();
    }

    class PortViewHolder extends RecyclerView.ViewHolder {

        TextView portName;
        TextView portNumber;

        public PortViewHolder(View itemView) {
            super(itemView);
            portName = itemView.findViewById(R.id.item_port_name);
            portNumber = itemView.findViewById(R.id.item_port_number);

        }

        // Helper method to bind product data to the views
        void bindProduct(Pair pair) {
            portName.setText(pair.getFirst());
            portNumber.setText(String.valueOf(pair.getSecond()));
        }
    }
}
