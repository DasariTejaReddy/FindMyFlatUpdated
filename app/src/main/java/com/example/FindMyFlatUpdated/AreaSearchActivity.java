package com.example.FindMyFlat.screens;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.app.ActionBar;



import com.example.milestone.R;

import java.util.ArrayList;
import java.util.List;

public class ApartmentsView extends AppCompatActivity {
    private List<Apartment> apartmentList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apartments_view);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowHomeEnabled(true);
            actionBar.setTitle("");

        }




        // Populate the list of apartments with data
        apartmentList.add(new Apartment("Park", "Parkway Apartments", "$1000", R.drawable.apartment1));
        apartmentList.add(new Apartment("Loca", "Locarna Apartments", "$1200", R.drawable.apartment2));
        apartmentList.add(new Apartment("Vill", "Village O Apartments", "$1500", R.drawable.apartment3));


        // Set up the RecyclerView
        RecyclerView recyclerView = findViewById(R.id.apartmentsRecyclerView);
        ApartmentAdapter adapter = new ApartmentAdapter(this, apartmentList); // Add this line
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }
    @Override
    public void onBackPressed() {
        // Handle the back button press
        super.onBackPressed(); // Optional, remove this line if you want to override the back button functionality
    }

}
