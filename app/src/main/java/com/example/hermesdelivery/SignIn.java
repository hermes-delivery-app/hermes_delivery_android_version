package com.example.hermesdelivery;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.os.VibratorManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class SignIn extends AppCompatActivity {
    private final String URL="http://ec2-54-221-143-51.compute-1.amazonaws.com:3000/api";
    String url = "http://ec2-107-23-252-231.compute-1.amazonaws.com:3000/users";// фальш сервер
    EditText phoneET;
    EditText passwordET;

    TextView testTV;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_in);
        Button backBtn = findViewById(R.id.back_button);
        Button signupPageBtn = findViewById(R.id.signup_page_button);
        Button signinBtnClick = findViewById(R.id.signin_l_button);

        backBtn.setOnClickListener(this::BackClick);
        signupPageBtn.setOnClickListener(this::PageSignUpClick);
        signinBtnClick.setOnClickListener(this::SignInClick);

        phoneET = findViewById(R.id.phone_number_edit_text);
        passwordET = findViewById(R.id.password_edit_text);
        testTV= findViewById(R.id.test_tv);

    }

    private void PostLoginData(){
        String string_phone_number = phoneET.getText().toString();
        String string_password = passwordET.getText().toString();

        if( string_phone_number.isEmpty() ) {
            Toast.makeText( this, "Enter name", Toast.LENGTH_SHORT ).show();
            phoneET.requestFocus();
            return;
        }
        if( string_password.isEmpty() ) {
            Toast.makeText( this, "Enter name", Toast.LENGTH_SHORT ).show();
            passwordET.requestFocus();
            return;
        }
        new Thread(new Runnable() {
            @Override
            public void run() {
                RequestBody postBody = new FormBody.Builder()
                        .add("phoneNumber", string_phone_number)
                        .add("password", string_password)
                        .build();
                Request request = new Request.Builder()
                        .url(url)
                        .post(postBody)
                        .build();
                OkHttpClient client = new OkHttpClient();
                //Call call = client.newCall(request);

                //Response response = null;

                try(okhttp3.Response response = client.newCall(request).execute()){
                    //response = call.execute();
                    String serverResponse = response.body().string();
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            //testTV.setText(serverResponse);
                        }
                    });
                    //testTV.setText("Got it");
                }catch(IOException error){
                    error.printStackTrace();
                }
            }
        }).start();
    }
    private void GetLoginData(){

    }
    private void SignInClick(View view){
        new Thread(new Runnable() {
            @Override
            public void run() {

                Request request = new Request.Builder()
                        .url(url)
                        .build();
                OkHttpClient client = new OkHttpClient();
                client.newCall(request).enqueue(new Callback() {
                    @Override
                    public void onFailure(@NonNull Call call, @NonNull IOException e) {
                        e.printStackTrace();
                    }

                    @Override
                    public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                        if(response.isSuccessful()){
                            String myResponse = response.body().string();
                            SignIn.this.runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    testTV.setText(myResponse);
                                }
                            });
                        }
                    }
                });

            }
        });
    }
    private void PageSignUpClick(View view)
    {
        Intent PageSignUpIntent = new Intent(
                SignIn.this,
                SignUp.class ) ;
        startActivity( PageSignUpIntent ) ;
    }
    private void BackClick(View view)
    {

    }






}