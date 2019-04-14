package com.example.group7_w2019_mad3125_fp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
    }

    public void signupBtn (View view){
        Intent signupIntent = new Intent(WelcomeActivity.this,SignUpActivity.class);
        startActivity(signupIntent);
    }

    public void loginBtn (View view){
        Intent loginIntent = new Intent(WelcomeActivity.this,LoginActivity.class);
        startActivity(loginIntent);
    }
}
