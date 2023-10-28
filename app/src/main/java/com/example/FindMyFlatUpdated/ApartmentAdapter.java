package com.example.FindMyFlatUpdated;



import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.ImageView;
import android.content.Intent;
import android.content.Context;



import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;

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
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.apartment_item, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Apartment apartment = apartmentList.get(position);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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
        Intent intent = new Intent(context, ApartmentDetails.class);
        intent.putExtra("APARTMENT_ID", apartment.getId());
        context.startActivity(intent);
    }
}

