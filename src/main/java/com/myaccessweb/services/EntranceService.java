package com.myaccessweb.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myaccessweb.models.Entrance;
import com.myaccessweb.repositories.EntranceRepository;

@Service
public class EntranceService {

    private EntranceRepository entranceRepository;

    public EntranceService(EntranceRepository entranceRepository) {
        this.entranceRepository = entranceRepository;
    }

    public Page<Entrance> getEntranceListPageable(Pageable pageable) {
        return entranceRepository.findAll(pageable);
    }

    public List<Entrance> getEntranceListByDocument(String document) {
        return entranceRepository.findByDocument(document);
    }

    public Optional<Entrance> getEntranceById(UUID id) {
        return entranceRepository.findById(id);
    }

    public Optional<Entrance> getLastEntranceByDocument(String document) {
        return entranceRepository.getLastEntranceByDocument(document);
    }

    @Transactional
    public Entrance createEntrance(Entrance entrance) {
        return entranceRepository.save(entrance);
    }
}
