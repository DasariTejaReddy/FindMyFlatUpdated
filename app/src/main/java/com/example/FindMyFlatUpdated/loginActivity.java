package com.example.FindMyFlat.screens;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.view.View;

import android.os.Bundle;

import com.example.milestone.R;

public class loginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        AppCompatButton loginButton = findViewById(R.id.login_button);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle login logic here if needed

                // Launch the AreaSearchActivity
               // Intent areaSearchIntent = new Intent(loginActivity.this, AreaSearchActivity.class);
                Intent areaSearchIntent = new Intent(loginActivity.this, AreaSearchActivity.class);
                startActivity(areaSearchIntent);
            }
        });
    }
}
