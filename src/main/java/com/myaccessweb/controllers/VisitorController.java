package com.myaccessweb.controllers;

import java.net.URI;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Optional;

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

import com.myaccessweb.dtos.VisitorDTO;
import com.myaccessweb.dtos.VisitorUpdateDTO;
import com.myaccessweb.models.Visitor;
import com.myaccessweb.services.VisitorService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/visitors")
public class VisitorController {
    
    @Autowired
    private VisitorService visitorService;

    @GetMapping
    public ResponseEntity<Page<Visitor>> findAllVisitor(@PageableDefault(page = 0, size = 2, sort = "id", direction = Sort.Direction.ASC) Pageable pageable) {
        return ResponseEntity.status(HttpStatus.OK).body(visitorService.getAllVisitorPaged(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findOneVisitor(@PathVariable Long id) {
        Optional<Visitor> visitorOptional = visitorService.getOneVisitor(id);
        if (!visitorOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Visitor not found!");
        }
        return ResponseEntity.status(HttpStatus.OK).body(visitorOptional.get());
    }

    @PostMapping
    public ResponseEntity<Object> createVisitor(@RequestBody @Valid VisitorDTO visitorDTO) {
        if (visitorService.existsByDocument(visitorDTO.getDocument())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Document already registered!");
        }
        var visitor = new Visitor();
        BeanUtils.copyProperties(visitorDTO, visitor);
        visitor.setCreateDate(LocalDateTime.now(ZoneId.of("UTC")));
        visitor.setUpdateDate(null);
        visitor.setBlocked(false);
        visitorService.setVisitor(visitor);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(visitor.getId()).toUri();
        return ResponseEntity.created(uri).body(visitor);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteVisitor(@PathVariable Long id) {
        Optional<Visitor> visitorOptional = visitorService.getOneVisitor(id);
        if (!visitorOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Visitor not found!");
        }
        visitorService.delete(visitorOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Visitor deleted successfully!");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateVisitor(@PathVariable Long id, @RequestBody @Valid VisitorUpdateDTO visitorUpdateDTO) {
        Optional<Visitor> visitorOptional = visitorService.getOneVisitor(id);
        if (!visitorOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Visitor not found!");
        }
        var visitor = new Visitor();
        BeanUtils.copyProperties(visitorUpdateDTO, visitor);
        visitor.setId(visitorOptional.get().getId());
        visitor.setDocument(visitorOptional.get().getDocument());
        visitor.setCreateDate(visitorOptional.get().getCreateDate());
        visitor.setUpdateDate(LocalDateTime.now(ZoneId.of("UTC")));
        return ResponseEntity.status(HttpStatus.OK).body(visitorService.setVisitor(visitor));
    }
}
