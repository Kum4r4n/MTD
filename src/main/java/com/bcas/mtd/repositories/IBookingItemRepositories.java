package com.bcas.mtd.repositories;

import com.bcas.mtd.entities.Booking;
import com.bcas.mtd.entities.BookingItems;
import com.bcas.mtd.helper.ItemType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IBookingItemRepositories extends JpaRepository<BookingItems, Long> {

    List<BookingItems> getBookingItemsByItemTypeAndBooking(ItemType itemType, Booking booking);
}
