package com.bcas.mtd.models.request;

import com.bcas.mtd.models.common.BookingModel;

import java.util.List;

public class BookingRequestModel extends BookingModel {

    private Long packageId;
    private Long userId;
    private List<Long> hotelIds;
    private List<Long> activitiesIds;

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

    public List<Long> getHotelIds() {
        return hotelIds;
    }

    public void setHotelIds(List<Long> hotelIds) {
        this.hotelIds = hotelIds;
    }

    public List<Long> getActivitiesIds() {
        return activitiesIds;
    }

    public void setActivitiesIds(List<Long> activitiesIds) {
        this.activitiesIds = activitiesIds;
    }
}
