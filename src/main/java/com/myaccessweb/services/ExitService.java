package com.myaccessweb.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myaccessweb.models.Exit;
import com.myaccessweb.repositories.ExitRepository;

@Service
public class ExitService {

    private ExitRepository exitRepository;

    public ExitService(ExitRepository exitRepository) {
        this.exitRepository = exitRepository;
    }

    @Transactional
    public Exit createExit(Exit exit) {
        return exitRepository.save(exit);
    }

    public Page<Exit> getExitListPageable(Pageable pageable) {
        return exitRepository.findAll(pageable);
    }

    public List<Exit> getExitListByDocument(String document) {
        return exitRepository.findByDocument(document);
    }

    public Optional<Exit> getExitById(UUID exitId) {
        return exitRepository.findById(exitId);
    }

    public Optional<Exit> getExitByEntranceId(UUID entranceId) {
        return exitRepository.findByEntranceId(entranceId);
    }
}
