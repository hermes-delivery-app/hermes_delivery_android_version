package com.example.hermesdelivery.BucketItems;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hermesdelivery.R;

import java.util.List;

public class ItemAdapterBasket extends RecyclerView.Adapter<ItemViewHolderBasket> {

    Context context;
    List<ItemBasket> items;

    public ItemAdapterBasket(Context context, List<ItemBasket> items) {
        this.context=context;
        this.items = items;
    }

    @NonNull
    @Override
    public ItemViewHolderBasket onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ItemViewHolderBasket(LayoutInflater.from(context).inflate(R.layout.item_view,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolderBasket holder, int position) {
        holder.itemNameTV.setText(items.get(position).getName());
        holder.itemInfoTV.setText(items.get(position).getDescription());
        holder.itemImageTV.setImageResource(items.get(position).get__v());

    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
