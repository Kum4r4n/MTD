package com.bcas.mtd.models.common;

import com.bcas.mtd.helper.BookingStatus;
import org.springframework.lang.Nullable;

public class BookingModel {
    @Nullable
    private Long id;
    private int bookingReference;
    private boolean isPaid;
    private BookingStatus bookingStatus;

    @Nullable
    public Long getId() {
        return id;
    }

    public void setId(@Nullable Long id) {
        this.id = id;
    }

    public int getBookingReference() {
        return bookingReference;
    }

    public void setBookingReference(int bookingReference) {
        this.bookingReference = bookingReference;
    }


    public boolean getIsPaid() {
        return isPaid;
    }

    public void setIsPaid(boolean paid) {
        isPaid = paid;
    }

    public BookingStatus getBookingStatus() {
        return bookingStatus;
    }

    public void setBookingStatus(BookingStatus bookingStatus) {
        this.bookingStatus = bookingStatus;
    }
}
