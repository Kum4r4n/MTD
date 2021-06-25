package com.bcas.mtd.models.common;

import org.springframework.lang.Nullable;

public class HotelModel {
    @Nullable
    private Long Id;
    private String name;
    private int numOfRooms;
    private int adultCount;
    private int childCount;
    private int availability;
    private String address;
    private double price;

    public HotelModel() {
    }

    public HotelModel(@Nullable Long id, String name, int numOfRooms, int adultCount, int childCount, int availability, String address, double price) {
        Id = id;
        this.name = name;
        this.numOfRooms = numOfRooms;
        this.adultCount = adultCount;
        this.childCount = childCount;
        this.availability = availability;
        this.address = address;
        this.price = price;
    }

    public HotelModel(String name, int numOfRooms, int adultCount, int childCount, int availability, String address, double price) {
        this.name = name;
        this.numOfRooms = numOfRooms;
        this.adultCount = adultCount;
        this.childCount = childCount;
        this.availability = availability;
        this.address = address;
        this.price = price;
    }

    @Nullable
    public Long getId() {
        return Id;
    }

    public void setId(@Nullable Long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumOfRooms() {
        return numOfRooms;
    }

    public void setNumOfRooms(int numOfRooms) {
        this.numOfRooms = numOfRooms;
    }

    public int getAdultCount() {
        return adultCount;
    }

    public void setAdultCount(int adultCount) {
        this.adultCount = adultCount;
    }

    public int getChildCount() {
        return childCount;
    }

    public void setChildCount(int childCount) {
        this.childCount = childCount;
    }

    public int getAvailability() {
        return availability;
    }

    public void setAvailability(int availability) {
        this.availability = availability;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
