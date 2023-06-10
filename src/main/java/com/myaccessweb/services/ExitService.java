package com.myaccessweb.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myaccessweb.models.Exit;
import com.myaccessweb.repositories.ExitRepository;

@Service
public class ExitService {

    @Autowired
    private ExitRepository exitRepository;

    @Transactional
    public Exit createExit(Exit exit) {
        return exitRepository.save(exit);
    }

    public Page<Exit> findAllExitsPaged(Pageable pageable) {
        return exitRepository.findAll(pageable);
    }

    public List<Exit> findAllExitByDocument(String document) {
        return exitRepository.findByDocument(document);
    }

    public Optional<Exit> findOneExitById(UUID exitId) {
        return exitRepository.findById(exitId);
    }

    public Optional<Exit> findExitByEntranceId(UUID entranceId) {
        return exitRepository.findByEntranceId(entranceId);
    }
}
