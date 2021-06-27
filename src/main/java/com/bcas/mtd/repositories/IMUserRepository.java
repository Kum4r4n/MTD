package com.bcas.mtd.repositories;

import com.bcas.mtd.entities.MUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMUserRepository extends JpaRepository<MUser, Long> {
}
