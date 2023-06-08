package com.example.hermesdelivery.Interfaces;

import com.example.hermesdelivery.JSONResponse;
import com.example.hermesdelivery.StoreMenuItems.Item;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MyApi {
    @GET("items")
    Call<JSONResponse> itemCall();
}
