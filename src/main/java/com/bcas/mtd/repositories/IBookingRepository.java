package com.bcas.mtd.repositories;

import com.bcas.mtd.entities.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBookingRepository extends JpaRepository<Booking, Long> {
}
