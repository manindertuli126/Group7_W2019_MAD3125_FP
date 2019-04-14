package com.example.group7_w2019_mad3125_fp;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity {

    private TextView signUser;
    private TextView signPassword;
    private TextView signEmail;
    private TextView signAddress;
    private SharedPreferences sharedPreferences;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("New User Register");

        signUser = findViewById(R.id.signUserName);
        signPassword = findViewById(R.id.signPassword);
        signEmail = findViewById(R.id.signEmail);
        signAddress = findViewById(R.id.signAddress);
        sharedPreferences = getSharedPreferences("UserData",MODE_PRIVATE);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent myIntent = new Intent(getApplicationContext(), WelcomeActivity.class);
        startActivityForResult(myIntent, 0);
        return true;
    }

    public void welcomeBtn (View view){
        String username = signUser.getText().toString();
        String password = signPassword.getText().toString();
        String email = signEmail.getText().toString();
        String address = signAddress.getText().toString();
        if( username.length()!=0 && password.length()!=0 && email.length()!=0 && address.length()!=0){
            if(username.length()>5){
                if(password.length()>6){
                    if(email.matches(emailPattern)){
                        if(address.length()>5){
                            SharedPreferences.Editor editSignUpData = sharedPreferences.edit();
                            editSignUpData.putString("SignUpUsername",username);
                            editSignUpData.putString("SignUpPassword",password);
                            editSignUpData.putString("SignUpEmail",email);
                            editSignUpData.putString("SignUpAddress",address);
                            editSignUpData.apply();
                            Intent welcomeIntent = new Intent(SignUpActivity.this,WelcomeActivity.class);
                            startActivity(welcomeIntent);
                        }else{
                            Toast.makeText(this,"Address length must be greater than 5",Toast.LENGTH_LONG).show();
                        }
                    }else{
                        Toast.makeText(this,"Incorrect Email format.",Toast.LENGTH_LONG).show();
                    }
                }else{
                    Toast.makeText(this,"Password length must be greater than 6.",Toast.LENGTH_LONG).show();
                }
            }else {
                Toast.makeText(this,"Username length must be greater than 5.",Toast.LENGTH_LONG).show();
            }
        }else{
            AlertDialog alertDialog = new AlertDialog.Builder(SignUpActivity.this).create();
            alertDialog.setTitle("ALERT");
            alertDialog.setMessage("No text field can be left blank.");
            alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            });
            alertDialog.show();
        }

    }
}
