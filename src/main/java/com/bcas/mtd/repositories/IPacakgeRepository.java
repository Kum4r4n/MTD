package com.bcas.mtd.repositories;

import com.bcas.mtd.entities.Package;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPacakgeRepository extends JpaRepository<Package, Long> {
}
