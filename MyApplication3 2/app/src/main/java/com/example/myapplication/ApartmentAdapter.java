package com.example.myapplication;

import com.example.myapplication.R;

import android.view.LayoutInflater;

import android.view.View;

import android.view.ViewGroup;

import android.widget.TextView;

import android.widget.ImageView;

import android.content.Intent;

import android.content.Context;



import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ApartmentAdapter extends RecyclerView.Adapter<ApartmentAdapter.ViewHolder> {

    private Context context;

    private List<Apartment> apartmentList;

    public ApartmentAdapter(Context context, List<Apartment> apartmentList) {

        this.context = context;

        this.apartmentList = apartmentList;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView nameTextView, priceTextView;

        public ImageView imageView;

        public ViewHolder(View view) {

            super(view);

            nameTextView = view.findViewById(R.id.apartmentName);

            priceTextView = view.findViewById(R.id.apartmentPrice);

            imageView = view.findViewById(R.id.apartmentImage);

        }
    }

    public ApartmentAdapter(List<Apartment> apartmentList) {

        this.apartmentList = apartmentList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {// override a function 

        View itemView = LayoutInflater.from(parent.getContext())

                .inflate(R.layout.apartment_item, parent, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Apartment apartment = apartmentList.get(position);// created the object

        holder.itemView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {// onclick function is called

                navigateToDetailsScreen(apartment);
            }
        });
        holder.nameTextView.setText(apartment.getName());

        holder.priceTextView.setText(apartment.getPrice());

        holder.imageView.setImageResource(apartment.getImageResource());

    }

    @Override
    public int getItemCount() {


        return apartmentList.size();

    }

    private void navigateToDetailsScreen(Apartment apartment) {

        Intent intent = new Intent(context, ApartmentDetails.class);// created an object

        intent.putExtra("APARTMENT_ID", apartment.getId());

        intent.putExtra("APARTMENT_NAME", apartment.getName());

        intent.putExtra("APARTMENT_PRICE", apartment.getPrice());

        intent.putExtra("APARTMENT_IMAGE", apartment.getImageResource());

        intent.putExtra("APARTMENT_SIZE", apartment.getSize());

        intent.putExtra("APARTMENT_DESCRIPTION", apartment.getDescription());

        intent.putExtra("APARTMENT_CONTACT", apartment.getContact());

        intent.putExtra("APARTMENT_ADDRESS", apartment.getAddress());

        context.startActivity(intent);
    }
}

