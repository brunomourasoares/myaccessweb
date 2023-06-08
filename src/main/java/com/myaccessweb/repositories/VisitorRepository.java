package com.myaccessweb.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myaccessweb.models.Visitor;


public interface VisitorRepository extends JpaRepository<Visitor, UUID> {
    Boolean existsByDocument(String document);

    //@Query(nativeQuery= true, value="SELECT * FROM tb_visitor WHERE document = ?")
    List<Visitor> findByDocumentLike(String partialDocument);
    List<Visitor> findByFullNameContainingIgnoreCase(String partialName);
}