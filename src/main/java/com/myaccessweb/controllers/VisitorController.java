package com.myaccessweb.controllers;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
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

import com.myaccessweb.dtos.VisitorRecordDTO;
import com.myaccessweb.dtos.VisitorUpdateRecordDTO;
import com.myaccessweb.models.Visitor;
import com.myaccessweb.services.VisitorService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@Tag(name = "Visitors", description = "VisitorController.java")
@RestController
@RequestMapping("/visitors")
public class VisitorController {
    
    private VisitorService visitorService;

    public VisitorController(VisitorService visitorService) {
        this.visitorService = visitorService;
    }

    @Operation(summary = "Find all visitors ordered by name (max 20 per page)", description = "* Method: getAllVisitorsPageable")
    @GetMapping
    public ResponseEntity<Page<Visitor>> getAllVisitorsPageable (@PageableDefault(page = 0, size = 20, sort = "name", direction = Sort.Direction.ASC) Pageable pageable) {
        return ResponseEntity.status(HttpStatus.OK).body(visitorService.getVisitorListPageable(pageable));
    }

    @Operation(summary = "Find one visitor by document", description = "* Method: getVisitorByDocument")
    @GetMapping("/{document}")
    public ResponseEntity<Object> getVisitorByDocument(@PathVariable String document) {
        Optional<Visitor> visitorOptional = visitorService.getVisitorByDocument(document);
        if (visitorOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Visitor not found!");
        }
        return ResponseEntity.status(HttpStatus.OK).body(visitorOptional.get());
    }

    @Operation(summary = "Create one visitor", description = "* Method: createVisitor")
    @PostMapping
    public ResponseEntity<Object> createVisitor(@RequestBody @Valid VisitorRecordDTO visitorRecordDTO) {
        if (visitorService.existByDocument(visitorRecordDTO.document())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Document already registered!");
        }
        var visitor = new Visitor();
        BeanUtils.copyProperties(visitorRecordDTO, visitor);
        visitor.setCreateDate(LocalDateTime.now(ZoneId.of("UTC")));
        visitor.setUpdateDate(null);
        visitor.setBlocked(false);
        visitor.setPhotoUrl(null);
        visitorService.createVisitor(visitor);
        return ResponseEntity.status(HttpStatus.CREATED).body(visitor);
    }

    @Operation(summary = "Delete one visitor by document", description = "* Method: deleteVisitor")
    @DeleteMapping("/{document}")
    public ResponseEntity<Object> deleteVisitor(@PathVariable String document) {
        Optional<Visitor> visitorOptional = visitorService.getVisitorByDocument(document);
        if (visitorOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Visitor not found!");
        }
        visitorService.deleteVisitor(visitorOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Visitor deleted successfully!");
    }

    @Operation(summary = "Update one visitor by document", description = "* Method: updateVisitor")
    @PutMapping("/{document}")
    public ResponseEntity<Object> updateVisitor(@PathVariable String document, @RequestBody @Valid VisitorUpdateRecordDTO visitorUpdateRecordDTO) {
        Optional<Visitor> visitorOptional = visitorService.getVisitorByDocument(document);
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

    @Operation(summary = "Find all visitors with partial document", description = "* Method: getAllVisitorsByPartialDocument")
    @GetMapping("/doc/{partialDocument}")
    public ResponseEntity<Object> getAllVisitorsByPartialDocument(@PathVariable String partialDocument) {
        List<Visitor> visitorList = visitorService.getByDocumentLike(partialDocument);
        if (visitorList.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Document not found!");
        }
        return ResponseEntity.status(HttpStatus.OK).body(visitorList);
    }

    @Operation(summary = "Find all visitors with partial name", description = "* Method: getAllVisitorsByPartialName")
    @GetMapping("/name/{partialName}")
    public ResponseEntity<Object> getAllVisitorsByPartialName(@PathVariable String partialName) {
        List<Visitor> visitorList = visitorService.getNameByContainingIgnoreCase(partialName);
        if (visitorList.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Name not found!");
        }
        return ResponseEntity.status(HttpStatus.OK).body(visitorList);
    }
}
