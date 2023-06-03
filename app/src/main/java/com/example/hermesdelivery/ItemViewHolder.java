package com.example.hermesdelivery;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ItemViewHolder extends RecyclerView.ViewHolder {
    ImageView itemImageTV;
    TextView itemNameTV;
    TextView itemInfoTV;
    Button addItemBtn;
    public ItemViewHolder(@NonNull View view){
        super(view);
        itemImageTV=view.findViewById(R.id.item_image_view);
        itemNameTV = view.findViewById(R.id.item_name_text_view);
        itemInfoTV = view.findViewById(R.id.item_info_text_view);

    }

}
