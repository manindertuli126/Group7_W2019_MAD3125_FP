package com.example.group7_w2019_mad3125_fp;

import android.content.DialogInterface;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final TextInputLayout usernameWrapper = (TextInputLayout) findViewById(R.id.usernameWrapper);
        final TextInputLayout passwordWrapper = (TextInputLayout) findViewById(R.id.passwordWrapper);

        usernameWrapper.setHint("Username");
        passwordWrapper.setHint("Password");
    }
//    AlertDialog alertDialog = new AlertDialog.Builder(SignUpActivity.this).create();
//                alertDialog.setTitle("ALERT");
//                alertDialog.setMessage("No text field can be left blank.");
//                alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK", new DialogInterface.OnClickListener() {
//        @Override
//        public void onClick(DialogInterface dialog, int which) {
//            dialog.dismiss();
//        }
//    });
//                alertDialog.show();
}
