package com.bcas.mtd.entities;

import javax.persistence.*;
import java.util.Set;

@Table
@Entity
public class Package extends BaseEntity{

    private String name;
    private String address;

    @ManyToMany
    @JoinTable(
            name = "package_hotels",
            joinColumns = @JoinColumn(name = "package_id", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "hotel_id", nullable = false)
    )
    private Set<Hotel> hotels;

    @ManyToMany
    @JoinTable(
            name = "package_actvities",
            joinColumns = @JoinColumn(name = "package_id", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "activities_id", nullable = false)
    )
    private Set<Activities> activities;

    private double price;

    @OneToMany(mappedBy = "packages")
    private Set<PackageFeedback> packageFeedbacks;

    @OneToMany(mappedBy = "packages")
    private Set<Booking> bookings;

    public Package() {
    }

    public Package(String name, String address, Set<Hotel> hotels, Set<Activities> activities, double price, Set<PackageFeedback> packageFeedbacks) {
        this.name = name;
        this.address = address;
        this.hotels = hotels;
        this.activities = activities;
        this.price = price;
        this.packageFeedbacks = packageFeedbacks;
    }

    public Package(String name, String address, double price) {
        this.name = name;
        this.address = address;
        this.price = price;
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

    public Set<Hotel> getHotels() {
        return hotels;
    }

    public void setHotels(Set<Hotel> hotels) {
        this.hotels = hotels;
    }

    public Set<Activities> getActivities() {
        return activities;
    }

    public void setActivities(Set<Activities> activities) {
        this.activities = activities;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Set<PackageFeedback> getPackageFeedbacks() {
        return packageFeedbacks;
    }

    public void setPackageFeedbacks(Set<PackageFeedback> packageFeedbacks) {
        this.packageFeedbacks = packageFeedbacks;
    }
}
