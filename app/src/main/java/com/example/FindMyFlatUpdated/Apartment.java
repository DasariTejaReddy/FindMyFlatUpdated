package com.example.FindMyFlatUpdated;


public class Apartment {
    private String id;
    private String name;
    private String price;
    private int imageResource;

    public Apartment(String id, String name, String price, int imageResource) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.imageResource = imageResource;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public int getImageResource() {
        return imageResource;
    }
}

