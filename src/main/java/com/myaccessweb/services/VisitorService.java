package com.myaccessweb.services;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myaccessweb.models.Visitor;
import com.myaccessweb.repositories.VisitorRepository;

@Service
public class VisitorService {

    private VisitorRepository visitorRepository;

    public VisitorService(VisitorRepository visitorRepository) {
        this.visitorRepository = visitorRepository;
    }

    public Page<Visitor> getVisitorListPageable(Pageable pageable) {
        return visitorRepository.findAll(pageable);
    }

    public Optional<Visitor> getVisitorByDocument(String document) {
        return visitorRepository.findByDocument(document);
    }

    public boolean existByDocument(String document) {
        return visitorRepository.existsByDocument(document);
    }

    @Transactional
    public Visitor createVisitor(Visitor visitor) {
        return visitorRepository.save(visitor);
    }

    @Transactional
    public void deleteVisitor(Visitor visitor) {
        visitorRepository.delete(visitor);
    }

    public List<Visitor> getByDocumentLike(String partialDocument) {
        return visitorRepository.findByDocumentLike("%"+partialDocument+"%");
    }

    public List<Visitor> getNameByContainingIgnoreCase(String partialName) {
        return visitorRepository.findByNameContainingIgnoreCase(partialName);
    }
}
