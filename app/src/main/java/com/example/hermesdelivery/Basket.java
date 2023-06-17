package com.example.hermesdelivery;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hermesdelivery.BucketItems.ItemAdapterBasket;
import com.example.hermesdelivery.BucketItems.ItemBasket;
import com.example.hermesdelivery.StoreMenuItems.Item;
import com.example.hermesdelivery.StoreMenuItems.ItemAdapter;

import java.util.ArrayList;
import java.util.List;

public class Basket extends AppCompatActivity {

    private RecyclerView recyclerView;
    List<ItemBasket> items;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.basket_page);

        recyclerView = findViewById(R.id.basket_items_recyclerview);

       items = new ArrayList<ItemBasket>();

    }
    private void viewJsonData() {

    }

    private void PutDataIntoRecyclerView(List<ItemBasket> items) {

        ItemAdapterBasket adapter = new ItemAdapterBasket( this, items);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }

}
