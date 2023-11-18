package com.example.myapplication;

import androidx.annotation.NonNull;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;

import android.os.Bundle;

import android.view.View;

import android.widget.Button;

import android.widget.EditText;

import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;

import com.google.firebase.database.DatabaseError;

import com.google.firebase.database.DatabaseReference;

import com.google.firebase.database.FirebaseDatabase;


import com.google.firebase.database.Query;

import com.google.firebase.database.ValueEventListener;

import java.util.Objects;


public class LoginActivity extends AppCompatActivity {

    EditText loginUsername, loginPassword;

    Button loginButton;

    TextView signupRedirectText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);

        loginUsername = findViewById(R.id.login_username);

        loginPassword = findViewById(R.id.login_password);

        loginButton = findViewById(R.id.login_button);

        signupRedirectText = findViewById(R.id.signupRedirectText);
        // This method is called when the loginButton is clicked
        loginButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                if (!validateUsername() | !validatePassword()) {



                } 
                else 
                {



                    checkUser();


                }
            }


        });
        signupRedirectText.setOnClickListener(new View.OnClickListener() {



            @Override

            public void onClick(View view) {

                // Creating a new Intent to navigate from the current LoginActivity to the SignupActivity
                Intent intent = new Intent(LoginActivity.this, SignupActivity.class);


                startActivity(intent);

            }

        });
    }
    public Boolean validateUsername() {

         // Retrieving the text entered in the loginUsername EditText and converting it to a String
        String val = loginUsername.getText().toString();

        if (val.isEmpty()) {

            loginUsername.setError("Username cannot be empty");

            return false;
        } else {

            loginUsername.setError(null);

            return true;
        }
    }
    public Boolean validatePassword(){

        String val = loginPassword.getText().toString();

        if (val.isEmpty()) {

            loginPassword.setError("Password cannot be empty");


            return false;

        } else {
            
            loginPassword.setError(null);

            return true;

        }

    }
    public void checkUser(){

        String userUsername = loginUsername.getText().toString().trim();

        String userPassword = loginPassword.getText().toString().trim();

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("users");

        Query checkUserDatabase = reference.orderByChild("username").equalTo(userUsername);

         // Adding a listener to check the user database for a single value event
        checkUserDatabase.addListenerForSingleValueEvent(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                if (snapshot.exists()){


                    loginUsername.setError(null);

                    String passwordFromDB = snapshot.child(userUsername).child("password").getValue(String.class);

                    if (passwordFromDB.equals(userPassword)) {

                        loginUsername.setError(null);

                        String nameFromDB = snapshot.child(userUsername).child("name").getValue(String.class);

                        String emailFromDB = snapshot.child(userUsername).child("email").getValue(String.class);


                        String usernameFromDB = snapshot.child(userUsername).child("username").getValue(String.class);
                        
                        //Creating a  Intent to navigate from the current LoginActivity to the AreaSearch activity
                       Intent intent = new Intent(LoginActivity.this, AreaSearch.class);


                         // Adding extra information to the Intent before starting the new activity
                          intent.putExtra("name", nameFromDB);


                        intent.putExtra("email", emailFromDB);

                        intent.putExtra("username", usernameFromDB);


                        intent.putExtra("password", passwordFromDB);

                        // Initiating the start of a new activity using the previously created Intent
                        startActivity(intent);

                    } 
                    
                    else
                    
                     {
                        // Setting an error message for the password input field in case of invalid login credentials
                        loginPassword.setError("Invalid Credentials");

                     // Requesting focus on the password input field after displaying an error message
                       loginPassword.requestFocus();

                    }


                } 
                else
                
                 {
                    loginUsername.setError("User does not exist");

                    loginUsername.requestFocus();
                }
            }
            @Override

            public void onCancelled(@NonNull DatabaseError error) {


            }

        });
    }
}