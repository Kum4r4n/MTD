package com.bcas.mtd.models.common;

import com.bcas.mtd.entities.Activities;
import com.bcas.mtd.entities.Hotel;
import org.springframework.lang.Nullable;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PackageModel {
    @Nullable
    private Long id;
    private String name;
    private String address;
    private List<HotelModel> hotels;
    private List<Activity> activities ;
    private double price;


    @Nullable
    public Long getId() {
        return id;
    }

    public void setId(@Nullable Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<HotelModel> getHotels() {
        return hotels;
    }

    public void setHotels(List<HotelModel> hotels) {
        this.hotels = hotels;
    }

    public List<Activity> getActivities() {
        return activities;
    }

    public void setActivities(List<Activity> activities) {
        this.activities = activities;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
