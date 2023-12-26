package com.myaccessweb.repositories;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myaccessweb.models.Visitor;


public interface VisitorRepository extends JpaRepository<Visitor, UUID> {
    
    Boolean existsByDocument(String document);
    List<Visitor> findByDocumentLike(String partialDocument);
    List<Visitor> findByNameContainingIgnoreCase(String partialName);
    Optional<Visitor> findByDocument(String document);
}