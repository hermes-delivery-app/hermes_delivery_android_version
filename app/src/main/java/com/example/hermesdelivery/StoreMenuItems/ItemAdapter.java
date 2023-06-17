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
import com.example.hermesdelivery.Interfaces.RecyclerViewIntarface;
import com.example.hermesdelivery.R;

import java.util.List;

public class ItemAdapter  extends RecyclerView.Adapter<ItemAdapter.ItemViewHolder> {
    private final RecyclerViewIntarface recyclerViewIntarface;
    Context context;
    List<Item> items;

    public ItemAdapter(RecyclerViewIntarface recyclerViewIntarface, Context context, List<Item> items) {
        this.recyclerViewIntarface = recyclerViewIntarface;
        this.context=context;
        this.items = items;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ItemViewHolder(LayoutInflater.from(context).inflate(R.layout.item_view,parent,false), recyclerViewIntarface);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        holder.itemNameTV.setText(items.get(position).getName());
        holder.itemInfoTV.setText(items.get(position).getDescription());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {
        public TextView itemNameTV;
        public TextView itemInfoTV;

        public ItemViewHolder(@NonNull View itemView, RecyclerViewIntarface recyclerViewIntarface) {
            super(itemView);
            itemNameTV = itemView.findViewById(R.id.item_name_text_view);
            itemInfoTV = itemView.findViewById(R.id.item_info_text_view);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(ItemAdapter.this.recyclerViewIntarface !=null){
                        int pos = getAdapterPosition();
                        if(pos != RecyclerView.NO_POSITION){
                            ItemAdapter.this.recyclerViewIntarface.onItemClick(pos);
                        }
                    }
                }
            });
        }
    }
}

