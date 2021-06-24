package com.bcas.mtd.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table
public class Hotel extends BaseEntity {

    private String name;
    private int numOfRooms;
    private int adultCount;
    private int childCount;
    private int availability;
    private String address;
    private double price;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "hotels")
    private Set<Package> packages = new HashSet<>();

    public Hotel() {
    }

    public Hotel(String name, int numOfRooms, int adultCount, int childCount, int availability, String address, double price, Set<Package> packages) {
        this.name = name;
        this.numOfRooms = numOfRooms;
        this.adultCount = adultCount;
        this.childCount = childCount;
        this.availability = availability;
        this.address = address;
        this.price = price;
        this.packages = packages;
    }

    public Hotel(String name, int numOfRooms, int adultCount, int childCount, int availability, String address, double price) {
        this.name = name;
        this.numOfRooms = numOfRooms;
        this.adultCount = adultCount;
        this.childCount = childCount;
        this.availability = availability;
        this.address = address;
        this.price = price;
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

    public Set<Package> getPackages() {
        return packages;
    }

    public void setPackages(Set<Package> packages) {
        this.packages = packages;
    }
}
