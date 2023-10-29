package com.example.FindMyFlat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.FindMyFlat.screens.loginActivity;
import com.example.milestone.R;

public class splashscreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent mainIntent = new Intent(splashscreen.this, loginActivity.class);
         startActivity(mainIntent);
         finish();
            }
        },10000);
    }
}