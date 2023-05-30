package com.myaccessweb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myaccessweb.models.Visitor;

public interface VisitorRepository extends JpaRepository<Visitor, Long> {
    boolean existsByDocument(String document);
}