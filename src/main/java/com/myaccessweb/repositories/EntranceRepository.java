package com.myaccessweb.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myaccessweb.models.Entrance;

public interface EntranceRepository extends JpaRepository<Entrance, UUID> {
        List<Entrance> findByDocumentLike(String partialDocument);
}
