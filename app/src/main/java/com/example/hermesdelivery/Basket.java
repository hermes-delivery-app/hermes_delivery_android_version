package com.example.hermesdelivery;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.OnBackPressedDispatcherOwner;
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
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.basket_page);

        RecyclerView recyclerView = findViewById(R.id.basket_items_recyclerview);

        List<ItemBasket> items = new ArrayList<ItemBasket>();

        items.add(new ItemBasket("Some","something", 1));
        items.add(new ItemBasket("Some","something", 1));
        items.add(new ItemBasket("Some","something", 1));
        items.add(new ItemBasket("Some","something", 1));
        items.add(new ItemBasket("Some","something", 1));
        items.add(new ItemBasket("Some","something", 1));
        items.add(new ItemBasket("Some","something", 1));
        items.add(new ItemBasket("Some","something", 1));
        items.add(new ItemBasket("Some","something", 1));
        items.add(new ItemBasket("Some","something", 1));
        items.add(new ItemBasket("Some","something", 1));
        items.add(new ItemBasket("Some","something", 1));
        items.add(new ItemBasket("Some","something", 1));
        items.add(new ItemBasket("Some","something", 1));
        items.add(new ItemBasket("Some","something", 1));
        items.add(new ItemBasket("Some","something", 1));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new ItemAdapterBasket(getApplicationContext(),items));
    }


}
