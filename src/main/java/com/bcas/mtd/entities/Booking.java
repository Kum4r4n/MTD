package com.bcas.mtd.entities;

import com.bcas.mtd.helper.BookingStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table
public class Booking extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "package_id", nullable = false)
    @JsonIgnore
    private Package packages;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mUser_id", nullable = false)
    @JsonIgnore
    private MUser mUser;

    private int bookingReference;
    private double amount;
    private boolean isPaid;
    private BookingStatus bookingStatus;

    public Booking() {
    }

    public Booking(int bookingReference, double amount, boolean isPaid, BookingStatus bookingStatus) {
        this.bookingReference = bookingReference;
        this.amount = amount;
        this.isPaid = isPaid;
        this.bookingStatus = bookingStatus;
    }

    public Booking(Package apackage, MUser user, int bookingReference, double amount, boolean isPaid, BookingStatus bookingStatus) {
        this.packages = apackage;
        this.mUser = user;
        this.bookingReference = bookingReference;
        this.amount = amount;
        this.isPaid = isPaid;
        this.bookingStatus = bookingStatus;
    }

    public Package getPackage() {
        return packages;
    }

    public void setPackage(Package apackage) {
        this.packages = apackage;
    }

    public MUser getUser() {
        return mUser;
    }

    public void setUser(MUser user) {
        this.mUser = user;
    }

    public int getBookingReference() {
        return bookingReference;
    }

    public void setBookingReference(int bookingReference) {
        this.bookingReference = bookingReference;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public void setPaid(boolean paid) {
        isPaid = paid;
    }

    public BookingStatus getBookingStatus() {
        return bookingStatus;
    }

    public void setBookingStatus(BookingStatus bookingStatus) {
        this.bookingStatus = bookingStatus;
    }
}
