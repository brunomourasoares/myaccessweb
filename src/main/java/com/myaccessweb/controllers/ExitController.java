package com.myaccessweb.controllers;

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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myaccessweb.dtos.ExitRecordDTO;
import com.myaccessweb.models.Entrance;
import com.myaccessweb.models.Exit;
import com.myaccessweb.services.EntranceService;
import com.myaccessweb.services.ExitService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/exits")
public class ExitController {
    

    private ExitService exitService;
    private EntranceService entranceService;

    public ExitController(ExitService exitService, EntranceService entranceService) {
        this.exitService = exitService;
        this.entranceService = entranceService;
    }

    @GetMapping
    public ResponseEntity<Page<Exit>> getAllExitsPageable(@PageableDefault(page = 0, size = 20, sort = "exitDate", direction = Sort.Direction.DESC) Pageable pageable) {
        return ResponseEntity.status(HttpStatus.OK).body(exitService.getExitListPageable(pageable));
    }

    @GetMapping("/{exitId}")
    public ResponseEntity<Object> getExitById(@PathVariable UUID exitId) {
        Optional<Exit> exitOptional = exitService.getExitById(exitId);
        if (exitOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Entrance not found!");
        }
        return ResponseEntity.status(HttpStatus.OK).body(exitOptional.get());
    }

    @PostMapping
    public ResponseEntity<Object> createExit(@RequestBody @Valid ExitRecordDTO exitRecordDTO) {
        Optional<Entrance> entranceOptional = entranceService.getLastEntranceByDocument(exitRecordDTO.document());
        if (entranceOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Entrance not found!");
        }
        Optional<Exit> exitOptional = exitService.getExitByEntranceId(entranceOptional.get().getEntranceId());
        if (exitOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Need entrance first!");
        }
        var exit = new Exit();
        BeanUtils.copyProperties(entranceOptional.get(), exit);
        exit.setExitDate(LocalDateTime.now(ZoneId.of("UTC")));
        exitService.createExit(exit);
        return ResponseEntity.status(HttpStatus.CREATED).body(exit);
    }

    @GetMapping("/doc/{visitorDocument}")
    public ResponseEntity<Object> getAllExitsByDocument(@PathVariable String visitorDocument) {
        List<Exit> exitList = exitService.getExitListByDocument(visitorDocument);
        if (exitList.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Entrance not found!");
        }
        return ResponseEntity.status(HttpStatus.OK).body(exitList);
    }
}
