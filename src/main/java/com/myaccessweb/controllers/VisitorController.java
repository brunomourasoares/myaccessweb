package com.myaccessweb.controllers;

import java.net.URI;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.myaccessweb.dtos.VisitorRecordDTO;
import com.myaccessweb.dtos.VisitorUpdateRecordDTO;
import com.myaccessweb.models.Visitor;
import com.myaccessweb.services.VisitorService;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/visitors")
public class VisitorController {
    
    @Autowired
    private VisitorService visitorService;

    @GetMapping
    public ResponseEntity<Page<Visitor>> findAllVisitor(@PageableDefault(page = 0, size = 5, sort = "id", direction = Sort.Direction.ASC) Pageable pageable) {
        return ResponseEntity.status(HttpStatus.OK).body(visitorService.findAllVisitorPaged(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findOneVisitor(@PathVariable UUID id) {
        Optional<Visitor> visitorOptional = visitorService.findOneVisitor(id);
        if (visitorOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Visitor not found!");
        }
        return ResponseEntity.status(HttpStatus.OK).body(visitorOptional.get());
    }

    @PostMapping
    public ResponseEntity<Object> createVisitor(@RequestBody @Valid VisitorRecordDTO visitorRecordDTO) {
        if (visitorService.existsByDocument(visitorRecordDTO.document())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Document already registered!");
        }
        var visitor = new Visitor();
        BeanUtils.copyProperties(visitorRecordDTO, visitor);
        visitor.setCreateDate(LocalDateTime.now(ZoneId.of("UTC")));
        visitor.setUpdateDate(null);
        visitor.setBlocked(false);
        visitor.setPhotoUrl(null);
        visitorService.createVisitor(visitor);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(visitor.getId()).toUri();
        return ResponseEntity.created(uri).body(visitor);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteVisitor(@PathVariable UUID id) {
        Optional<Visitor> visitorOptional = visitorService.findOneVisitor(id);
        if (visitorOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Visitor not found!");
        }
        visitorService.deleteVisitor(visitorOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Visitor deleted successfully!");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateVisitor(@PathVariable UUID id, @RequestBody @Valid VisitorUpdateRecordDTO visitorUpdateRecordDTO) {
        Optional<Visitor> visitorOptional = visitorService.findOneVisitor(id);
        if (visitorOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Visitor not found!");
        }
        var visitor = new Visitor();
        BeanUtils.copyProperties(visitorUpdateRecordDTO, visitor);
        visitor.setId(visitorOptional.get().getId());
        visitor.setDocument(visitorOptional.get().getDocument());
        visitor.setCreateDate(visitorOptional.get().getCreateDate());
        visitor.setUpdateDate(LocalDateTime.now(ZoneId.of("UTC")));
        visitor.setPhotoUrl(null);
        return ResponseEntity.status(HttpStatus.OK).body(visitorService.createVisitor(visitor));
    }

    @GetMapping("/doc/{partialDocument}")
    public ResponseEntity<Object> listVisitorsByPartialDocument(@PathVariable String partialDocument) {
        List<Visitor> visitorList = visitorService.findByDocumentLike(partialDocument);
        if (visitorList.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Document not found!");
        }
        return ResponseEntity.status(HttpStatus.OK).body(visitorList);
    }

    @GetMapping("/name/{partialName}")
    public ResponseEntity<Object> listVisitorsByPartialName(@PathVariable String partialName) {
        List<Visitor> visitorList = visitorService.findByFullNameContainingIgnoreCase(partialName);
        if (visitorList.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Full name not found!");
        }
        return ResponseEntity.status(HttpStatus.OK).body(visitorList);
    }
}
