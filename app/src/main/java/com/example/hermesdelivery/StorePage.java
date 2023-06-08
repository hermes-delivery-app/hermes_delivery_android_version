package com.example.hermesdelivery;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hermesdelivery.Interfaces.MyApi;
import com.example.hermesdelivery.StoreMenuItems.Item;
import com.example.hermesdelivery.StoreMenuItems.ItemAdapter;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class StorePage extends AppCompatActivity {
    private final String url="http://ec2-107-23-252-231.compute-1.amazonaws.com:3000/";
    private MyApi myApi;
    private RecyclerView recyclerView;
    List<Item> items;
    String serverResponse;
    TextView test;
   
        @SuppressLint("MissingInflatedId")
        @Override
        protected void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.store_page);

            ExtendedFloatingActionButton bucketFAB = findViewById(R.id.bucket_button);
            bucketFAB.setOnClickListener(this::BucketClick);
            test= findViewById(R.id.name_store_text_view);


            recyclerView = findViewById(R.id.items_recyclerview);
            items = new ArrayList<>();
            viewJsonData();

        }

   private void viewJsonData() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        myApi = retrofit.create(MyApi.class);
        Call<JSONResponse>call= myApi.itemCall();

        call.enqueue(new Callback<JSONResponse>() {
            @Override
            public void onResponse(Call<JSONResponse> call, retrofit2.Response<JSONResponse> response) {
                JSONResponse jsonResponse = response.body();
                items = new ArrayList<>(Arrays.asList(jsonResponse.getItems()));

                PutDataIntoRecyclerView(items);
            }

            @Override
            public void onFailure(Call<JSONResponse> call, Throwable t) {

            }
        });

    }

    private void PutDataIntoRecyclerView(List<Item> items) {

            ItemAdapter adapter = new ItemAdapter(this, items);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            recyclerView.setAdapter(adapter);
        }

        private void BucketClick(View view){
            Intent PageSignUpIntent = new Intent(
                    StorePage.this,
                    Basket.class ) ;
            startActivity( PageSignUpIntent ) ;
        }

}
