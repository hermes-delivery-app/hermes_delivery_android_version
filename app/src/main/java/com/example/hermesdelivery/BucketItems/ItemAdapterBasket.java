package com.example.hermesdelivery.BucketItems;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hermesdelivery.R;
import com.example.hermesdelivery.StoreMenuItems.Item;
import com.example.hermesdelivery.StoreMenuItems.ItemViewHolder;

import java.util.List;

public class ItemAdapterBasket extends RecyclerView.Adapter<com.example.hermesdelivery.StoreMenuItems.ItemViewHolder> {

    Context context;
    List<com.example.hermesdelivery.StoreMenuItems.Item> items;

    public ItemAdapterBasket(Context context, List<Item> items) {
        this.context=context;
        this.items = items;
    }

    @NonNull
    @Override
    public com.example.hermesdelivery.StoreMenuItems.ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new com.example.hermesdelivery.StoreMenuItems.ItemViewHolder(LayoutInflater.from(context).inflate(R.layout.item_view,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        holder.itemNameTV.setText(items.get(position).getName());
        holder.itemInfoTV.setText(items.get(position).getDescription());
        holder.itemImageTV.setImageResource(items.get(position).getImage());

    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
