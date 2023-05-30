package com.myaccessweb.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myaccessweb.models.Visitor;
import com.myaccessweb.repositories.VisitorRepository;

@Service
public class VisitorService {

    @Autowired
    private VisitorRepository visitorRepository;

    @Transactional(readOnly = true)
    public Page<Visitor> getAllVisitorPaged(Pageable pageable) {
        return visitorRepository.findAll(pageable);
    }

    @Transactional(readOnly = true)
    public Optional<Visitor> getOneVisitor(Long id) {
        return visitorRepository.findById(id);
    }

    @Transactional
    public Visitor setVisitor(Visitor visitor) {
        return visitorRepository.save(visitor);
    }

    @Transactional
    public void delete(Visitor visitor) {
        visitorRepository.delete(visitor);
    }

    public boolean existsByDocument(String document) {
        return visitorRepository.existsByDocument(document);
    }
}
