package com.myaccessweb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myaccessweb.models.VisitorEntrance;

public interface VisitorEntranceRepository extends JpaRepository<VisitorEntrance, Long> {
}
