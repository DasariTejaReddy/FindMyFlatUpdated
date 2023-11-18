package com.example.myapplication;

import android.os.Bundle;

import androidx.annotation.NonNull;

import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;

import androidx.recyclerview.widget.LinearLayoutManager;

import androidx.recyclerview.widget.RecyclerView;

import androidx.appcompat.widget.Toolbar;

import androidx.appcompat.app.ActionBar;



import com.example.myapplication.R;

import java.util.ArrayList;

import java.util.List;

public class ApartmentsView extends AppCompatActivity
 {

    private List<Apartment> apartmentList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) // declared on create method
    {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_apartments_view);

        int selectedItemIndex = getIntent().getIntExtra("SELECTED_ITEM_INDEX", -1);


        Toolbar toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();// created the object 

        if (actionBar != null) {

            actionBar.setDisplayHomeAsUpEnabled(true);

            actionBar.setDisplayShowHomeEnabled(true);

            actionBar.setTitle("");

        }

        // Determine which apartment list to use based on the selectedItemIndex
        switch (selectedItemIndex) {// switch case

            case 1:

                populateApartmentList1();

                break;

            case 2:

                populateApartmentList2();

                break;

            case 3:

                populateApartmentList3();

                break;

            default:

                // Handle the case when selectedItemIndex is not valid
                break;

        }


        // Set up the RecyclerView
        RecyclerView recyclerView = findViewById(R.id.apartmentsRecyclerView);

        ApartmentAdapter adapter = new ApartmentAdapter(this, apartmentList); // Declaring adapter

        recyclerView.setAdapter(adapter);// setting the adapter

        recyclerView.setLayoutManager(new LinearLayoutManager(this));// setting the layout manager

    }

    private void populateApartmentList1() 
    {
        // Populate apartmentList1 with data

        apartmentList.add(new Apartment("Park", "Parkway Apartments", "$1000", "1200sqft", "Description: \n" +
                "Chic city living awaits in this contemporary apartment featuring sleek design, high-end finishes, and ample natural light. \n" +
                "With an open-concept layout, the space seamlessly blends modern aesthetics with comfort", "Contact Details: For more information or to schedule a viewing, please contact us at 123-456-7890 or email us at example@example.com.", "123 Main Street, Cityville, State 12345", R.drawable.apartment1));
        apartmentList.add(new Apartment("Loca", "Locarna Apartments", "$1200", "1300 sqft",
                "Luxury living in Locarna Apartments with spacious rooms, modern amenities, and stunning views. Experience the epitome of comfort and style.",
                "Contact Details: Call us at 987-654-3210 or email at info@locarnaapartments.com.", "456 Elm Avenue, Townsville, State 56789", R.drawable.apartment2));
        apartmentList.add(new Apartment("Aqua", "Aqua Towers", "$1500", "1100 sqft",
                "Live in luxury at Aqua Towers with breathtaking waterfront views, state-of-the-art facilities, and elegant interiors. Your dream home awaits.",
                "Contact Details: Reach us at 555-123-4567 or aquatowers@email.com.", "789 Oak Lane, Villagetown, State 98765", R.drawable.apartment3));
        // Add more items to apartmentList1 as needed
    }

    private void populateApartmentList2() {
        apartmentList.add(new Apartment("CityVibe", "CityVibe Residences", "$1100", "1000 sqft",
                "Discover urban living at its best in CityVibe Residences. Stylish apartments, vibrant community, and convenient city access.",
                "Contact Details: Call us at 555-678-9012 or email at info@cityviberesidences.com.", "321 Maple Street, Hamletsville, State 43210", R.drawable.apartment9));

        apartmentList.add(new Apartment("SkyView", "SkyView Heights", "$1300", "1400 sqft",
                "Elevate your lifestyle at SkyView Heights. Enjoy panoramic city views, contemporary design, and top-notch amenities.",
                "Contact Details: Reach us at 987-654-3210 or skyviewheights@email.com.", "654 Pine Road, Suburbia City, State 87654", R.drawable.apartment4));

        apartmentList.add(new Apartment("GreenHaven", "GreenHaven Estates", "$1250", "1150 sqft",
                "Experience tranquility in the heart of nature at GreenHaven Estates. Serene surroundings, spacious interiors, and eco-friendly living.",
                "Contact Details: Call us at 555-321-0987 or email at info@greenhavenestates.com.", "987 Birch Boulevard, Riverside, State 21098", R.drawable.apartment5));


    }

    private void populateApartmentList3() {
        apartmentList.add(new Apartment("HarmonyPlace", "Harmony Place Residences", "$1400", "1050 sqft",
                "Find harmony in your living space at Harmony Place Residences. Modern comfort, stylish interiors, and a sense of community.",
                "Contact Details: Reach us at 123-456-7890 or harmonyplace@email.com.", "210 Cedar Court, Mountainview, State 87612", R.drawable.apartment6));

        apartmentList.add(new Apartment("SunsetVista", "Sunset Vista Apartments", "$1180", "1250 sqft",
                "Enjoy breathtaking sunsets at Sunset Vista Apartments. Spacious layouts, scenic views, and a perfect blend of comfort and style.",
                "Contact Details: Call us at 555-789-0123 or email at info@sunsetvistaapartments.com.", "543 Willow Way, Lakeside Town, State 10987", R.drawable.apartment7));

        apartmentList.add(new Apartment("ZenHomes", "Zen Homes Retreat", "$1450", "1100 sqft",
                "Discover Zen living at Zen Homes Retreat. Tranquil ambiance, minimalist design, and a sanctuary for mindful living.",
                "Contact Details: Reach us at 987-654-2109 or zenhomes@email.com.", "876 Spruce Street, Countryside, State 54321", R.drawable.apartment8));

    }
    @Override
    public void onBackPressed()
     {
        // Handle the back button press

        super.onBackPressed(); // Optional, remove this line if you want to override the back button functionality
    }


}