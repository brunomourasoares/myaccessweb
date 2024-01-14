package com.myaccessweb.dtos;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.hateoas.RepresentationModel;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class EntranceDTO extends RepresentationModel<EntranceDTO> {

    private UUID entranceId;
    @NotBlank
    @Size(min = 9, max = 11)
    private String document;
    @Size(max = 45)
    private String carModel;
    @Size(max = 7)
    private String carPlate;
    @NotBlank
    @Size(max = 45)
    private String destination;
    @NotBlank
    @Size(max = 45)
    private String wantedPeople;
    private LocalDateTime entranceDate;

    public UUID getEntranceId() {
        return entranceId;
    }
    public void setEntranceId(UUID entranceId) {
        this.entranceId = entranceId;
    }
    public String getDocument() {
        return document;
    }
    public void setDocument(String document) {
        this.document = document;
    }
    public String getCarModel() {
        return carModel;
    }
    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }
    public String getCarPlate() {
        return carPlate;
    }
    public void setCarPlate(String carPlate) {
        this.carPlate = carPlate;
    }
    public String getDestination() {
        return destination;
    }
    public void setDestination(String destination) {
        this.destination = destination;
    }
    public String getWantedPeople() {
        return wantedPeople;
    }
    public void setWantedPeople(String wantedPeople) {
        this.wantedPeople = wantedPeople;
    }
    public LocalDateTime getEntranceDate() {
        return entranceDate;
    }
    public void setEntranceDate(LocalDateTime entranceDate) {
        this.entranceDate = entranceDate;
    }
}
