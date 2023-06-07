package com.example.hermesdelivery;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
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
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import retrofit2.http.Url;

public class SignUp extends AppCompatActivity {

    private final String url="http://ec2-107-23-252-231.compute-1.amazonaws.com:3000/auth/signup";



    EditText nameET;
    EditText phoneET;
    EditText passwordET;
    TextView testTV;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up);
        Button backBtn = findViewById(R.id.back_button);
        Button signinPageBtn = findViewById(R.id.signin_page_button);
        Button signupBtn = findViewById(R.id.signup_button);
        signupBtn.setOnClickListener(this::SignUpClick);
        backBtn.setOnClickListener(this::BackClick);
        signinPageBtn.setOnClickListener(this::PageSignInClick);


        nameET = findViewById(R.id.name_edit_text);
        phoneET = findViewById(R.id.phone_number_edit_text);
        passwordET = findViewById(R.id.password_edit_text);
        testTV= findViewById(R.id.test_tv);


    }
    private void SignUpClick(View view)
    {
        String string_name = nameET.getText().toString();
        String string_phone_number = phoneET.getText().toString();
        String string_password = passwordET.getText().toString();

        if( string_name.isEmpty() ) {
            Toast.makeText( this, "Enter name", Toast.LENGTH_SHORT ).show();
            nameET.requestFocus();
            return;
        }
        new Thread(new Runnable() {
            @Override
            public void run() {
                RequestBody postBody = new FormBody.Builder()
                        .add("name", string_name)
                        .add("password", string_password)
                        .add("phoneNumber", string_phone_number)
                        .build();
                Request request = new Request.Builder()
                        .url(url)
                        .post(postBody)
                        .build();
                OkHttpClient client = new OkHttpClient();
                OkHttpClient.Builder builder = new OkHttpClient.Builder();
                client = builder.build();
                //Call call = client.newCall(request);

                //Response response = null;

                try(Response response = client.newCall(request).execute()){
                    //response = call.execute();
                    String serverResponse = response.body().string();
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            testTV.setText(serverResponse);
                        }
                    });
                }catch(IOException error){
                    error.printStackTrace();
                }
            }
        }).start();

    }

   private void PageSignInClick(View view)
   {
       Intent PageSignInIntent = new Intent(
               SignUp.this,
               SignIn.class ) ;
       startActivity( PageSignInIntent ) ;
   }
   private void BackClick(View view)
   {

   }


}