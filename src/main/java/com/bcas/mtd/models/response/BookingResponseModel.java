package com.bcas.mtd.models.response;

import com.bcas.mtd.models.common.Activity;
import com.bcas.mtd.models.common.BookingModel;
import com.bcas.mtd.models.common.HotelModel;

import java.util.List;

public class BookingResponseModel extends BookingModel {

    private Long packageId;
    private Long userId;
    private List<HotelModel> hotels;
    private List<Activity> activities;
    private Double price;

    public Long getPackageId() {
        return packageId;
    }

    public void setPackageId(Long packageId) {
        this.packageId = packageId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
