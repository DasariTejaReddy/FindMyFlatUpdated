package com.example.myapplication;

public class Apartment {

    private String id;

    private String name;

    private String price;

    private String size;

    private String description;

    private String contact;

    private String address;

    private int imageResource;

    public Apartment(String id, String name, String price, String size, String description, String contact, String address, int imageResource) {
       
        this.id = id;

        this.name = name;

        this.price = price;

        this.size = size;

        this.description = description;

        this.contact = contact;

        this.address = address;

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

    public String getSize() {

        return size;

    }

    public String getDescription() {

        return description;

    }

    public String getContact() {

        return contact;

    }

    public String getAddress() {

        return address;

    }

    public int getImageResource() {

        return imageResource;

    }

    
}
