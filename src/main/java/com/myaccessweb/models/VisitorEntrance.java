package com.myaccessweb.models;

import java.io.Serializable;
import java.time.Instant;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "tb_visitor_entrance")
public class VisitorEntrance implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;
    private String carModel;
    private String carPlate;
    private String destiny;
    private String wantedPeople;
    private Instant entranceDate;

    public VisitorEntrance() {
    }

    public VisitorEntrance(Long id, String carModel, String carPlate, String destiny, 
                            String wantedPeople, Instant entranceDate) {
        this.id = id;
        this.carModel = carModel;
        this.carPlate = carPlate;
        this.destiny = destiny;
        this.wantedPeople = wantedPeople;
        this.entranceDate = entranceDate;
    }
}
