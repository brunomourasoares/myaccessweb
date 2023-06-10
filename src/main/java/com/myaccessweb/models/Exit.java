package com.myaccessweb.models;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_exit")
public class Exit implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID exitId;
    @Column(nullable = false, length = 11)
    private String document;
    @Column(length = 45)
    private String carModel;
    @Column(length = 7)
    private String carPlate;
    @Column(nullable = false, length = 45)
    private String destiny;
    @Column(nullable = false, length = 45)
    private String wantedPeople;
    @Column(nullable = false, columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private LocalDateTime exitDate;
    @Column(nullable = false)
    private UUID entranceId;
    @Column(nullable = false, columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private LocalDateTime entranceDate;
    
    public Exit() {
    }

    public Exit(UUID exitId, String document, String carModel, String carPlate, String destiny, String wantedPeople,
            LocalDateTime exitDate, UUID entranceId, LocalDateTime entranceDate) {
        this.exitId = exitId;
        this.document = document;
        this.carModel = carModel;
        this.carPlate = carPlate;
        this.destiny = destiny;
        this.wantedPeople = wantedPeople;
        this.exitDate = exitDate;
        this.entranceId = entranceId;
        this.entranceDate = entranceDate;
    }

    public UUID getExitId() {
        return exitId;
    }
    
    public void setExitId(UUID exitId) {
        this.exitId = exitId;
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

    public String getDestiny() {
        return destiny;
    }

    public void setDestiny(String destiny) {
        this.destiny = destiny;
    }

    public String getWantedPeople() {
        return wantedPeople;
    }

    public void setWantedPeople(String wantedPeople) {
        this.wantedPeople = wantedPeople;
    }

    public LocalDateTime getExitDate() {
        return exitDate;
    }

    public void setExitDate(LocalDateTime exitDate) {
        this.exitDate = exitDate;
    }

    public UUID getEntranceId() {
        return entranceId;
    }

    public void setEntranceId(UUID entranceId) {
        this.entranceId = entranceId;
    }

    public LocalDateTime getEntranceDate() {
        return entranceDate;
    }

    public void setEntranceDate(LocalDateTime entranceDate) {
        this.entranceDate = entranceDate;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((exitId == null) ? 0 : exitId.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Exit other = (Exit) obj;
        if (exitId == null) {
            if (other.exitId != null)
                return false;
        } else if (!exitId.equals(other.exitId))
            return false;
        return true;
    }
}
