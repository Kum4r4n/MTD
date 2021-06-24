package com.bcas.mtd.repositories;

import com.bcas.mtd.entities.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IHotelRepository extends JpaRepository<Hotel, Long> {

}
