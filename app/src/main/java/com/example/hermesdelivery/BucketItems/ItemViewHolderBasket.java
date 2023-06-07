package com.example.hermesdelivery.BucketItems;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hermesdelivery.R;

public class ItemViewHolderBasket extends RecyclerView.ViewHolder {
    ImageView itemImageTV;
    TextView itemNameTV;
    TextView itemInfoTV;

    Button addItemBtn;
    public ItemViewHolderBasket(@NonNull View view){
        super(view);
        itemImageTV=view.findViewById(R.id.item_image_view);
        itemNameTV = view.findViewById(R.id.item_name_text_view);
        itemInfoTV = view.findViewById(R.id.item_info_text_view);
        addItemBtn = view.findViewById(R.id.add_item_button);
        addItemBtn.setOnClickListener(this::AddItemClick);
    }

    private void AddItemClick(View view){

    }



}
