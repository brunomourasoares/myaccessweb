package com.myaccessweb.models;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_entrance")
public class Entrance extends Flow implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID entranceId;
    private LocalDateTime entranceDate;

    public Entrance() {
    }

    public Entrance(UUID entranceId, String document, String carModel, String carPlate, String destination, String wantedPeople, LocalDateTime entranceDate) {
        super(document, carModel, carPlate, destination, wantedPeople);
        this.entranceId = entranceId;
        this.entranceDate = entranceDate;
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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((entranceId == null) ? 0 : entranceId.hashCode());
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
        Entrance other = (Entrance) obj;
        if (entranceId == null) {
            if (other.entranceId != null)
                return false;
        } else if (!entranceId.equals(other.entranceId))
            return false;
        return true;
    }

    public void setEntranceDate(LocalDateTime entranceDate) {
        this.entranceDate = entranceDate;
    }
}
