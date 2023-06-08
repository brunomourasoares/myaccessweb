package com.myaccessweb.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

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

    public Page<Visitor> findAllVisitorPaged(Pageable pageable) {
        return visitorRepository.findAll(pageable);
    }

    public Optional<Visitor> findOneVisitor(UUID id) {
        return visitorRepository.findById(id);
    }

    @Transactional
    public Visitor createVisitor(Visitor visitor) {
        return visitorRepository.save(visitor);
    }

    @Transactional
    public void deleteVisitor(Visitor visitor) {
        visitorRepository.delete(visitor);
    }

    public boolean existsByDocument(String document) {
        return visitorRepository.existsByDocument(document);
    }

    public List<Visitor> findByDocumentLike(String partialDocument) {
        return visitorRepository.findByDocumentLike("%"+partialDocument+"%");
    }

    public List<Visitor> findByFullNameContainingIgnoreCase(String partialName) {
        return visitorRepository.findByFullNameContainingIgnoreCase(partialName);
    }
}
