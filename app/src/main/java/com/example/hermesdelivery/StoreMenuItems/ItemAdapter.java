package com.example.hermesdelivery.StoreMenuItems;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.hermesdelivery.R;

import java.util.ArrayList;
import java.util.List;

public class ItemAdapter  extends RecyclerView.Adapter<ItemAdapter.ItemViewHolder> {

    Context context;
    List<Item> items;

    public ItemAdapter(Context context, List<Item> items) {
        this.context=context;
        this.items = items;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ItemViewHolder(LayoutInflater.from(context).inflate(R.layout.item_view,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        holder.itemNameTV.setText(items.get(position).getName());
        holder.itemInfoTV.setText(items.get(position).getDescription());
        if(items.get(position).get__v() == 0) {
            holder.itemImageTV.setImageResource(items.get(position).get__v());
        }else
            Glide.with(context).load(items.get(position).get__v()).into(holder.itemImageTV);

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {
        public ImageView itemImageTV;
        public TextView itemNameTV;
        public TextView itemInfoTV;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            itemImageTV=itemView.findViewById(R.id.item_image_view);
            itemNameTV = itemView.findViewById(R.id.item_name_text_view);
            itemInfoTV = itemView.findViewById(R.id.item_info_text_view);
        }
    }
}

