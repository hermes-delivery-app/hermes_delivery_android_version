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
import android.widget.TextView;
import android.widget.Toast;

public class SignUp extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up);
        Button backBtn = findViewById(R.id.back_button);
        Button signinPageBtn = findViewById(R.id.signin_page_button);
        backBtn.setOnClickListener(this::BackClick);
        signinPageBtn.setOnClickListener(this::PageSignInClick);

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