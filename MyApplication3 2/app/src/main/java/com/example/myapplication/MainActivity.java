package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;

import android.os.Bundle;

import android.view.View;

import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        Button btnLogin = findViewById(R.id.btnLogin);

        Button btnSignup = findViewById(R.id.btnSignup);


        // Set click listeners for buttons
        btnLogin.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                // Navigate to the login activity
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);

                startActivity(intent);

            }

        });

        btnSignup.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                // Navigate to the signup activity
                Intent intent = new Intent(MainActivity.this, SignupActivity.class);

                startActivity(intent);
            }


        });

    }
    
    }
