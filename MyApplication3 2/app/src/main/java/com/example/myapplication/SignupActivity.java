package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;


import android.os.Bundle;

import android.view.View;


import android.widget.Button;

import android.widget.EditText;

import android.widget.TextView;


import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;



import com.google.firebase.database.FirebaseDatabase;

public class SignupActivity extends AppCompatActivity {

    EditText signupName, signupUsername, signupEmail, signupPassword;

    TextView loginRedirectText;

    Button signupButton;

    FirebaseDatabase database;

    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_signup);

        signupName = findViewById(R.id.signup_name);

        signupEmail = findViewById(R.id.signup_email);

        signupUsername = findViewById(R.id.signup_username);

        signupPassword = findViewById(R.id.signup_password);

        loginRedirectText = findViewById(R.id.loginRedirectText);

        signupButton = findViewById(R.id.signup_button);

          // This method is called when the signupButton is clicked
        signupButton.setOnClickListener(new View.OnClickListener()
        
         {

            @Override
            public void onClick(View view) {
                // Getting an instance of the FirebaseDatabase to interact with the Firebase Realtime Database
                database = FirebaseDatabase.getInstance();

                reference = database.getReference("users");

                String name = signupName.getText().toString();

                String email = signupEmail.getText().toString();

                String username = signupUsername.getText().toString();
                 // Retrieving the text entered in the signupPassword EditText and converting it to a String
                String password = signupPassword.getText().toString();

                HelperClass helperClass = new HelperClass(name, email, username, password);

                reference.child(username).setValue(helperClass);
               // Displaying a short-duration toast message to indicate successful signup

                Toast.makeText(SignupActivity.this, "You have signup successfully!", Toast.LENGTH_SHORT).show();
                 // Creating a new Intent to navigate from the current SignupActivity to the LoginActivity
                Intent intent = new Intent(SignupActivity.this, LoginActivity.class);

                startActivity(intent);

            }
        });

        loginRedirectText.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                // Creating a new Intent to navigate from the current SignupActivity to the LoginActivity
                Intent intent = new Intent(SignupActivity.this, LoginActivity.class);

                startActivity(intent);
            }

        });

    }
}