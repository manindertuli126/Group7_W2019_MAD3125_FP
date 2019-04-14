package com.example.group7_w2019_mad3125_fp;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.icu.text.UnicodeSetSpanner;
import android.support.annotation.BinderThread;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private TextView loginUser;
    private TextView loginPass;
    private TextInputLayout usernameWrapper;
    private TextInputLayout passwordWrapper;
    private SharedPreferences sharedPreferences;
    private Switch rememberMeSwitch;
    private String SPusername;
    private String SPpassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        getSupportActionBar().setTitle("Existing User");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        rememberMeSwitch = (Switch) findViewById(R.id.loginRememberMe);
        loginUser = findViewById(R.id.loginUser);
        loginPass = findViewById(R.id.loginPass);

        sharedPreferences = getSharedPreferences("UserData",MODE_PRIVATE);
        SPusername = sharedPreferences.getString("SignUpUsername",null);
        SPpassword = sharedPreferences.getString("SignUpPassword",null);
        if(sharedPreferences.contains("loginUsername")&&sharedPreferences.contains("loginPassword")){
            loginUser.setText(SPusername);
            loginPass.setText(SPpassword);
            rememberMeSwitch.setChecked(true);
        }else{
            loginUser.setText("");
            loginPass.setText("");
            rememberMeSwitch.setChecked(false);
        }

        usernameWrapper = (TextInputLayout) findViewById(R.id.usernameWrapper);
        passwordWrapper = (TextInputLayout) findViewById(R.id.passwordWrapper);
        usernameWrapper.setHint("Username");
        passwordWrapper.setHint("Password");
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent myIntent = new Intent(getApplicationContext(), WelcomeActivity.class);
        startActivityForResult(myIntent, 0);
        return true;
    }

    public void moveToHome(View view){
            final String getUsername = loginUser.getText().toString();
            final String getPassword = loginPass.getText().toString();
            if(getUsername.length()!=0 && getPassword.length()!=0){
                    if(getUsername.equals(SPusername)){
                        if(getPassword.equals(SPpassword)){
                            SharedPreferences.Editor saveLoginData = sharedPreferences.edit();
                            if(rememberMeSwitch.isChecked()){
                                saveLoginData.putString("loginUsername",getUsername);
                                saveLoginData.putString("loginPassword",getPassword);
                                saveLoginData.apply();
                            }else{
                                saveLoginData.remove("loginUsername");
                                saveLoginData.remove("loginPassword");
                                saveLoginData.apply();
                            }
                                Intent moveToHomePage = new Intent(LoginActivity.this,HomeActivity.class);
                                startActivity(moveToHomePage);
                        }else{
                            Toast.makeText(this,"Incorrect Password entered.", Toast.LENGTH_LONG).show();
                        }
                    }else{
                        Toast.makeText(this,"Incorrect Username entered.", Toast.LENGTH_LONG).show();
                    }
            }else{
                AlertDialog alertDialog = new AlertDialog.Builder(LoginActivity.this).create();
                alertDialog.setTitle("ALERT");
                alertDialog.setMessage("Username Or Password Field can not be left blank.");
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
