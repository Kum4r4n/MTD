package com.bcas.mtd.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table
public class Activities extends BaseEntity{

    private String name;
    private String address;
    private double price;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "activities")
    private Set<Package> packages = new HashSet<>();

    public Activities() {
    }

    public Activities(String name, String address, double price, Set<Package> packages) {
        this.name = name;
        this.address = address;
        this.price = price;
        this.packages = packages;
    }

    public Activities(String name, String address, double price) {
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
