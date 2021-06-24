package com.bcas.mtd.entities;

import com.bcas.mtd.helper.ItemType;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table
public class BookingItems extends BaseEntity{

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "booking_id", nullable = false)
    private Booking booking;
    private ItemType itemType;
    private Long itemId;
    private double itemPrice;

    public BookingItems() {
    }

    public BookingItems(Booking booking, ItemType itemType, Long itemId, double itemPrice) {
        this.booking = booking;
        this.itemType = itemType;
        this.itemId = itemId;
        this.itemPrice = itemPrice;
    }

    public BookingItems(ItemType itemType, Long itemId, double itemPrice) {
        this.itemType = itemType;
        this.itemId = itemId;
        this.itemPrice = itemPrice;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    public ItemType getItemType() {
        return itemType;
    }

    public void setItemType(ItemType itemType) {
        this.itemType = itemType;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }
}
