package com.example.hermesdelivery;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hermesdelivery.Interfaces.UserSignUp;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


import java.util.ArrayList;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SignUp extends AppCompatActivity {

    private final String url="http://ec2-107-23-252-231.compute-1.amazonaws.com:3000/";


    String serverResponse;
    EditText nameET;
    EditText phoneET;
    EditText passwordET;
    TextView testTV;
    Button signupBtn;
    private UserSignUp userSignUp;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up);
        //Button backBtn = findViewById(R.id.back_button);
        signupBtn= findViewById(R.id.signup_button);
        signupBtn.setOnClickListener(this::SignUpClick);
        //backBtn.setOnClickListener(this::BackClick);
        signupBtn.setEnabled(true);

        nameET = findViewById(R.id.name_edit_text);
        phoneET = findViewById(R.id.phone_number_edit_text);
        passwordET = findViewById(R.id.password_edit_text);
        testTV= findViewById(R.id.test_tv);


        /*nameET.addTextChangedListener(signupTW);
        phoneET.addTextChangedListener(signupTW);
        passwordET.addTextChangedListener(signupTW);
*/

    }
    TextWatcher signupTW = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            String string_name = nameET.getText().toString();
            String string_phone_number = phoneET.getText().toString();
            String string_password =  passwordET.getText().toString();

            signupBtn.setEnabled(!string_name.isEmpty() && !string_phone_number.isEmpty() && !string_password.isEmpty());
        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };
    private void PostSignUpRequestTest(){
        String string_name = nameET.getText().toString();
        String string_phone_number = phoneET.getText().toString();
        String string_password =  passwordET.getText().toString();
        ArrayList<UserPostInner> userPostInner = new ArrayList<>();
        UserPost userPost=new UserPost(
                string_name,
                string_phone_number,
                string_password,
                userPostInner
        );
        sendNetworkRequest(userPost);
    }
    private void sendNetworkRequest(UserPost userPost){
        /*Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        userSignUp = retrofit.create(UserSignUp.class);
       Call<UserPost> call = userSignUp.up();

        call.enqueue(new Callback<UserPost>() {
            @Override
            public void onResponse(Call<UserPost> call, retrofit2.Response<UserPost> response) {
                Toast.makeText(SignUp.this,"niiice "+ response.body(),Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<UserPost> call, Throwable t) {
                Toast.makeText(SignUp.this,"fuuuuck",Toast.LENGTH_SHORT).show();
            }
        });*/
    }
    private void PostSignUpRequest()
    {
        Gson gson = new GsonBuilder().create();

        // Create OkHttpClient instance
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

        // Create Retrofit instance
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://example.com")  // Replace with your base URL
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(httpClient.build())
                .build();

        // Create the API service
        UserSignUp apiService = retrofit.create(UserSignUp.class);

        // Variables for name, phoneNumber, and password
        String name = "John Doe";
        String phoneNumber = "+1234567890";
        String password = "secretpassword";

        // JSON payload
        String jsonPayload = "{\"name\": \"" + name + "\", \"phoneNumber\": \"" + phoneNumber + "\", \"password\": \"" + password + "\", \"existence\": {}}";
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"), jsonPayload);

        // Send the POST request
        Call<Void> call = apiService.up(requestBody);
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(SignUp.this,"niiice "+ response.body(),Toast.LENGTH_SHORT).show();
                } else {
                    Log.e("MainActivity", "Request failed with code: " + response.code());
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Log.e("MainActivity", "Request failed: " + t.getMessage());
            }
        });


        }
    private void SignUpClick(View view)
    {
       PostSignUpRequestTest();

    }


   private void BackClick(View view)
   {

   }


}
