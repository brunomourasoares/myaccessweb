package com.myaccessweb.models;

import java.io.Serializable;
import java.time.LocalDateTime;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.OneToOne;
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
    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private LocalDateTime entranceDate;

    public VisitorEntrance() {
    }

    public VisitorEntrance(Long id, String document, String carModel, String carPlate, String destiny, String wantedPeople, LocalDateTime entranceDate) {
        this.id = id;
        this.document = document;
        this.carModel = carModel;
        this.carPlate = carPlate;
        this.destiny = destiny;
        this.wantedPeople = wantedPeople;
        this.entranceDate = entranceDate;
    }
}
