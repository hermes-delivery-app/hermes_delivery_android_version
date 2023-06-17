package com.example.hermesdelivery.Interfaces;

import com.example.hermesdelivery.UserPost;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface UserSignUp {
    @POST("auth/signup")
    Call<Void> up(@Body RequestBody requestBody);
}
