package com.myaccessweb.controllers;

import java.lang.reflect.Method;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myaccessweb.dtos.EntranceDTO;
import com.myaccessweb.models.Entrance;
import com.myaccessweb.services.EntranceService;
import com.myaccessweb.services.VisitorService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@Tag(name = "Entrances", description = "EntranceController.java")
@RestController
@RequestMapping(value = "/entrances")
public class EntranceController {
    
    private EntranceService entranceService;
    private VisitorService visitorService;

    public EntranceController(EntranceService entranceService, VisitorService visitorService) {
        this.entranceService = entranceService;
        this.visitorService = visitorService;
    }

    @Operation(summary = "Find all entrances ordered by entranceDate descending (max 20 per page)", description = "* Method: getAllEntrancesPageable")
    @GetMapping
    public ResponseEntity<Page<Entrance>> getAllEntrancesPageable(@PageableDefault(page = 0, size = 20, sort = "entranceDate", direction = Sort.Direction.DESC) Pageable pageable) {
        return ResponseEntity.status(HttpStatus.OK).body(entranceService.getEntranceListPageable(pageable));
    }

    @Operation(summary = "Find one entrance by id", description = "* Method: getEntranceById")
    @GetMapping("/{entranceId}")
    public ResponseEntity<Object> getEntranceById(@PathVariable UUID entranceId) {
        Optional<Entrance> entranceOptional = entranceService.getEntranceById(entranceId);
        if (entranceOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Entrance not found!");
        }
        EntranceDTO entranceDTO = new EntranceDTO();
        BeanUtils.copyProperties(entranceOptional.get(), entranceDTO);
        entranceDTO.add(WebMvcLinkBuilder.linkTo(EntranceController.class).slash("doc").slash(entranceDTO.getDocument()).withSelfRel());
        return ResponseEntity.status(HttpStatus.OK).body(entranceDTO);
    }

    @Operation(summary = "Entrances list by document", description = "* Method: getAllEntrancesByDocument")
    @GetMapping("/doc/{visitorDocument}")
    public ResponseEntity<Object> getAllEntrancesByDocument(@PathVariable String visitorDocument) {
        List<Entrance> entranceList = entranceService.getEntranceListByDocument(visitorDocument);
        if (entranceList.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Entrance not found!");
        }
        
        return ResponseEntity.status(HttpStatus.OK).body(entranceList);
    }

    @Operation(summary = "Create one entrance", description = "* Method: createEntrance")
    @PostMapping
    public ResponseEntity<Object> createEntrance(@RequestBody @Valid EntranceDTO entranceDTO) {
        if (!visitorService.existByDocument(entranceDTO.getDocument())) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Visitor not found!");
        }
        var entrance = new Entrance();
        BeanUtils.copyProperties(entranceDTO, entrance);
        entrance.setEntranceDate(LocalDateTime.now(ZoneId.of("UTC")));
        entranceService.createEntrance(entrance);
        entranceDTO.setEntranceId(entrance.getEntranceId());
        entranceDTO.setEntranceDate(entrance.getEntranceDate());
        entranceDTO.add(WebMvcLinkBuilder.linkTo(EntranceController.class).slash(entranceDTO.getEntranceId()).withSelfRel());
        return ResponseEntity.status(HttpStatus.CREATED).body(entranceDTO);
    }
}
