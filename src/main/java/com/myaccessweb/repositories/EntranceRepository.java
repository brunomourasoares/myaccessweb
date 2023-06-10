package com.myaccessweb.repositories;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.myaccessweb.models.Entrance;

public interface EntranceRepository extends JpaRepository<Entrance, UUID> {
    List<Entrance> findByDocument(String document);
       
    @Query(value = "SELECT * FROM tb_entrance WHERE document = ? ORDER BY entrance_date DESC LIMIT 1", nativeQuery = true)
    Optional<Entrance> findLastEntranceByDocument(String document);

}
