// S558568   Premchand Are

package com.example.milestone.screens;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import android.content.Intent;
import android.view.View;
import android.os.Bundle;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Button;

import com.example.milestone.R;

public class AreaSearchActivity extends AppCompatActivity {
    private Spinner spinner;
    private ImageView imageView;

    private Button myButton;
    private TextView descriptionTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_area_search);

        spinner = findViewById(R.id.spinner);
        imageView = findViewById(R.id.imageView);
        descriptionTextView = findViewById(R.id.descriptionTextView);
        myButton = findViewById(R.id.myButton);

        descriptionTextView.setText("");
        spinner.setSelection(-1);

        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to the ApartmentsView activity
                Intent intent = new Intent(AreaSearchActivity.this, ApartmentsView.class);
                startActivity(intent);
            }
        });

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.items, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = parent.getItemAtPosition(position).toString();
                // Logic to display the corresponding image based on the selected item
                if (selectedItem.equals("Street 1")) {
                    imageView.setImageResource(R.drawable.image1);
                    descriptionTextView.setText("Maple Street: A warm embrace for newcomers, where neighbors become friends.");
                    myButton.setVisibility(View.VISIBLE);
                } else if (selectedItem.equals("Street 2")) {
                    imageView.setImageResource(R.drawable.image2);
                    descriptionTextView.setText("Sunrise Avenue: Where hospitality shines bright, greeting newcomers with open hearts.");
                    myButton.setVisibility(View.VISIBLE);
                } else if (selectedItem.equals("Street 3")) {
                    imageView.setImageResource(R.drawable.image3);
                    descriptionTextView.setText("Willow Lane: A street of smiles and warm welcomes, where every newcomer feels at home.");
                    myButton.setVisibility(View.VISIBLE);
                } else {
                    descriptionTextView.setText("");
                    myButton.setVisibility(View.GONE);
                    imageView.setImageDrawable(null);
                }
                // Add more conditions as needed for other items
            }



            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                //myButton.setVisibility(View.GONE);
            }
        });
    }
}