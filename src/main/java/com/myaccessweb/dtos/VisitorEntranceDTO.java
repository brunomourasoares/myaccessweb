package com.myaccessweb.dtos;

import java.io.Serializable;
import java.time.Instant;

import com.myaccessweb.models.VisitorEntrance;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VisitorEntranceDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private Long id;
    private String carModel;
    private String carPlate;
    private String destiny;
    private String wantedPeople;
    private Instant entranceDate;

    public VisitorEntranceDTO() {
    }

    public VisitorEntranceDTO(Long id, String carModel, String carPlate, String destiny, 
                            String wantedPeople, Instant entranceDate) {
        this.id = id;
        this.carModel = carModel;
        this.carPlate = carPlate;
        this.destiny = destiny;
        this.wantedPeople = wantedPeople;
        this.entranceDate = entranceDate;
    }

    public VisitorEntranceDTO(VisitorEntrance entity) {
        this.id = entity.getId();
        this.carModel = entity.getCarModel();
        this.carPlate = entity.getCarPlate();
        this.destiny = entity.getDestiny();
        this.wantedPeople = entity.getWantedPeople();
        this.entranceDate = entity.getEntranceDate();
    }
}
