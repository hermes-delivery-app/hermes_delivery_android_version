package com.example.hermesdelivery;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class AuthorizationMain extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.authorization_main);
        Button facebookLoginBtn = findViewById(R.id.facebook_login_button);
        facebookLoginBtn.setOnClickListener(this::FBLoginClick);
        Button signUpPageBtn = findViewById(R.id.signup_page_button);
        signUpPageBtn.setOnClickListener(this::PageSignUpClick);
        TextView signInPageBtn = findViewById(R.id.signin_page_button);
        signInPageBtn.setOnClickListener(this::PageSignInClick);
    }
    private void PageSignInClick(View view)
    {
        Intent PageSignInIntent = new Intent(AuthorizationMain.this,
                SignIn.class);
        startActivity(PageSignInIntent);
    }

    private void PageSignUpClick(View view)
    {
        Intent PageSignUpIntent = new Intent(
                AuthorizationMain.this,
                SignUp.class ) ;
        startActivity( PageSignUpIntent ) ;
    }
    private void FBLoginClick(View view)
    {
        Toast.makeText(this,"Open Facebook login",Toast.LENGTH_SHORT).show();
    }

}
