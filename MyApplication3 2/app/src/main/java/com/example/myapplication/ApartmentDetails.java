package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import androidx.annotation.NonNull;

import androidx.appcompat.widget.Toolbar;

import android.view.MenuItem;

import androidx.appcompat.app.ActionBar;

import android.content.Intent;

import android.widget.TextView;

import android.widget.ImageView;




import android.os.Bundle;

import com.example.myapplication.R;

public class ApartmentDetails extends AppCompatActivity {

    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_apartment_details);

        String apartmentName = "";  // Initialize with default values or handle null appropriately
        
        String apartmentPrice = "";

        int apartmentImageResource = 0;

        String apartmentSize = "";

        String apartmentDescription = "";

        String apartmentContact = "";

        String apartmentAddress = "";

        Intent intent = getIntent();

        if (intent != null) {
            //here we give the apartment details like name,price,size cost etc...

            apartmentName = intent.getStringExtra("APARTMENT_NAME");

            apartmentPrice = intent.getStringExtra("APARTMENT_PRICE");

            apartmentImageResource = intent.getIntExtra("APARTMENT_IMAGE", 0);

            apartmentSize = intent.getStringExtra("APARTMENT_SIZE");

            apartmentDescription = intent.getStringExtra("APARTMENT_DESCRIPTION");

            apartmentContact = intent.getStringExtra("APARTMENT_CONTACT");

            apartmentAddress = intent.getStringExtra("APARTMENT_ADDRESS");

            // Now you can use these values to display details in your activity
            // For example, set them to TextViews or ImageViews in your layout

        }
        // here we created text views and image views for our layout which used to display the code
        TextView apartmentNameTextView = findViewById(R.id.apartmentName);

        TextView apartmentPriceTextView = findViewById(R.id.apartmentPrice);

        TextView apartmentSizeTextView = findViewById(R.id.apartmentSize);

        TextView apartmentDescriptionTextView = findViewById(R.id.apartmentDescription);

        TextView apartmentContactTextView = findViewById(R.id.contactDetails);

        TextView apartmentAddressTextView = findViewById(R.id.apartmentLocation);

        ImageView apartmentImageView = findViewById(R.id.apartmentImage);

        apartmentNameTextView.setText(apartmentName);

        apartmentPriceTextView.setText(apartmentPrice);

        apartmentImageView.setImageResource(apartmentImageResource);

        apartmentSizeTextView.setText(apartmentSize);

        apartmentDescriptionTextView.setText(apartmentDescription);

        apartmentContactTextView.setText(apartmentContact);

        apartmentAddressTextView.setText(apartmentAddress);

        Toolbar toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        getSupportActionBar().setDisplayShowHomeEnabled(true);

        getSupportActionBar().setTitle(apartmentName);


    }
    @Override

    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (item.getItemId() == android.R.id.home) {

            onBackPressed();

            return true;
        }

        return super.onOptionsItemSelected(item);

    }
}