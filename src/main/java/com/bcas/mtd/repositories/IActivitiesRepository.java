package com.bcas.mtd.repositories;

import com.bcas.mtd.entities.Activities;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IActivitiesRepository extends JpaRepository<Activities, Long> {
}
