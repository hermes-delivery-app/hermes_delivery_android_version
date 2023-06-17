package com.example.hermesdelivery.BucketItems;

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
import com.example.hermesdelivery.StoreMenuItems.Item;
import com.example.hermesdelivery.StoreMenuItems.ItemAdapter;

import java.util.List;

public class ItemAdapterBasket extends RecyclerView.Adapter<ItemAdapterBasket.ItemViewHolderBasket> {

    Context context;
    List<ItemBasket> items;

    public ItemAdapterBasket(Context context, List<ItemBasket> items) {
        this.context=context;
        this.items = items;
    }

    @NonNull
    @Override
    public ItemViewHolderBasket onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ItemAdapterBasket.ItemViewHolderBasket(LayoutInflater.from(context).inflate(R.layout.item_view_basket,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolderBasket holder, int position) {
        holder.itemNameTV.setText(items.get(position).getName());
        holder.itemInfoTV.setText(items.get(position).getDescription());
        if(items.get(position).get__v() == 0) {
            holder.itemImageTV.setImageResource(items.get(position).get__v());
        }else
            Glide.with(context).load(items.get(position).get__v()).into(holder.itemImageTV);

    }

    @Override
    public int getItemCount() {
        return 0;
    }


    public class ItemViewHolderBasket extends RecyclerView.ViewHolder {
        public ImageView itemImageTV;
        public TextView itemNameTV;
        public TextView itemInfoTV;

        public ItemViewHolderBasket(@NonNull View itemView) {
            super(itemView);
            itemImageTV=itemView.findViewById(R.id.item_image_basket_view);
            itemNameTV = itemView.findViewById(R.id.item_name_basket_text_view);
            itemInfoTV = itemView.findViewById(R.id.item_info_basket_text_view);
        }
    }
}
