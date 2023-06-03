package com.example.hermesdelivery;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button signUp = findViewById( R.id.signup_button ) ;
        signUp.setOnClickListener( this::btnSignUpClick ) ;

        findViewById(R.id.signin_button)
                .setOnClickListener(this::btnSignInClick);
        findViewById(R.id.auth_main_button)
                .setOnClickListener(this::btnAuthMainClick);

        findViewById(R.id.store_page_button)
                .setOnClickListener(this::btnStoreClick);

    }
    private void btnSignUpClick( View v ) {
        Intent signupIntent = new Intent(
                MainActivity.this,
                SignUp.class ) ;
        startActivity( signupIntent ) ;
    }
    private void btnSignInClick( View v ) {
        Intent signInIntent = new Intent(
                MainActivity.this,
                SignIn.class ) ;
        startActivity( signInIntent ) ;
    }
    private void btnAuthMainClick( View v ) {
        Intent authMainIntent = new Intent(
                MainActivity.this,
                AuthorizationMain.class ) ;
        startActivity( authMainIntent ) ;
    }

    private void btnStoreClick( View v ) {
        Intent storeIntent = new Intent(
                MainActivity.this,
                StorePage.class ) ;
        startActivity( storeIntent ) ;
    }


}