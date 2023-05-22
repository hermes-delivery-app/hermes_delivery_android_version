package com.example.hermesdelivery;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import android.widget.Button;
import android.widget.Toast;

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


}