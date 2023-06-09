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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.myaccessweb.dtos.EntranceRecordDTO;
import com.myaccessweb.models.Entrance;
import com.myaccessweb.services.EntranceService;
import com.myaccessweb.services.VisitorService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/entrances")
public class EntranceController {
    
    @Autowired
    private EntranceService entranceService;

    @Autowired
    private VisitorService visitorService;

    @GetMapping
    public ResponseEntity<Page<Entrance>> findAllEntrances(@PageableDefault(page = 0, size = 5, sort = "id", direction = Sort.Direction.ASC) Pageable pageable) {
        return ResponseEntity.status(HttpStatus.OK).body(entranceService.findAllEntrancePaged(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findOneEntrance(@PathVariable UUID id) {
        Optional<Entrance> entranceOptional = entranceService.findOneEntrance(id);
        if (entranceOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Entrance not found!");
        }
        return ResponseEntity.status(HttpStatus.OK).body(entranceOptional.get());
    }

    @PostMapping
    public ResponseEntity<Object> createEntrance(@RequestBody @Valid EntranceRecordDTO entranceRecordDTO) {
        if (!visitorService.existsByDocument(entranceRecordDTO.document())) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Document not found!");
        }
        var entrance = new Entrance();
        BeanUtils.copyProperties(entranceRecordDTO, entrance);
        entrance.setEntranceDate(LocalDateTime.now(ZoneId.of("UTC")));
        entranceService.createEntrance(entrance);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(entrance.getId()).toUri();
        return ResponseEntity.created(uri).body(entrance);
    }

    @GetMapping("/doc/{partialDocument}")
    public ResponseEntity<Object> listEntranceByPartialDocument(@PathVariable String partialDocument) {
        List<Entrance> entranceList = entranceService.findByDocumentLike(partialDocument);
        if (entranceList.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Document not found!");
        }
        return ResponseEntity.status(HttpStatus.OK).body(entranceList);
    }
}
