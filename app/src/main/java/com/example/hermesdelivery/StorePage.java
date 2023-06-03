package com.example.hermesdelivery;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class StorePage extends AppCompatActivity {

    FloatingActionButton bucketButton;
    ExtendedFloatingActionButton extendedFloatingActionButton;

        @Override
        protected void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.store_page);

            //floating button
            //bucketButton = findViewById(R.id.bucket_button);

            RecyclerView recyclerView = findViewById(R.id.items_recyclerview);

            List<Item> items = new ArrayList<Item>();

            items.add(new Item("Some","something", 1));
            items.add(new Item("Some","something", 1));
            items.add(new Item("Some","something", 1));
            items.add(new Item("Some","something", 1));
            items.add(new Item("Some","something", 1));
            items.add(new Item("Some","something", 1));
            items.add(new Item("Some","something", 1));
            items.add(new Item("Some","something", 1));
            items.add(new Item("Some","something", 1));
            items.add(new Item("Some","something", 1));
            items.add(new Item("Some","something", 1));
            items.add(new Item("Some","something", 1));
            items.add(new Item("Some","something", 1));
            items.add(new Item("Some","something", 1));
            items.add(new Item("Some","something", 1));
            items.add(new Item("Some","something", 1));
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            recyclerView.setAdapter(new ItemAdapter(getApplicationContext(),items));
        }

}
