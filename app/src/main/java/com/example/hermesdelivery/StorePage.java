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

import com.example.hermesdelivery.StoreMenuItems.Item;
import com.example.hermesdelivery.StoreMenuItems.ItemAdapter;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class StorePage extends AppCompatActivity {
    private final String url="http://ec2-107-23-252-231.compute-1.amazonaws.com:3000/items";
    String serverResponse;
    TextView test;
        @SuppressLint("MissingInflatedId")
        @Override
        protected void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.store_page);

            ExtendedFloatingActionButton bucketFAB = findViewById(R.id.bucket_button);
            bucketFAB.setOnClickListener(this::BucketClick);

            GetListOfItems();

            Gson gson = new Gson();
            Type listType = new TypeToken<List<Item>>(){}.getType();

            RecyclerView recyclerView = findViewById(R.id.items_recyclerview);


            List<Item> items = gson.fromJson(serverResponse,listType);



            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            recyclerView.setAdapter(new ItemAdapter(getApplicationContext(),items));
        }

        private void GetListOfItems(){
            new Thread(new Runnable() {
                @Override
                public void run() {

                    Request request = new Request.Builder()
                            .url(url)
                            .build();
                    OkHttpClient client = new OkHttpClient();
                    OkHttpClient.Builder builder = new OkHttpClient.Builder();
                    client = builder.build();
                    //Call call = client.newCall(request);

                    //Response response = null;

                    try(Response response = client.newCall(request).execute()){
                        //response = call.execute();
                        serverResponse = response.body().string();
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {

                            }
                        });
                    }catch(IOException error){
                        error.printStackTrace();
                    }
                }
            }).start();
        }
        private void BucketClick(View view){
            Intent PageSignUpIntent = new Intent(
                    StorePage.this,
                    Basket.class ) ;
            startActivity( PageSignUpIntent ) ;
        }

}
