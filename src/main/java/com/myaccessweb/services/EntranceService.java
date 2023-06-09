package com.myaccessweb.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myaccessweb.models.Entrance;
import com.myaccessweb.models.Visitor;
import com.myaccessweb.repositories.EntranceRepository;

@Service
public class EntranceService {

    @Autowired
    private EntranceRepository entranceRepository;

        public Page<Entrance> findAllEntrancePaged(Pageable pageable) {
        return entranceRepository.findAll(pageable);
    }

    public Optional<Entrance> findOneEntrance(UUID id) {
        return entranceRepository.findById(id);
    }

    @Transactional
    public Entrance createEntrance(Entrance entrance) {
        return entranceRepository.save(entrance);
    }

    public List<Entrance> findByDocumentLike(String partialDocument) {
        return entranceRepository.findByDocumentLike("%"+partialDocument+"%");
    }
}
