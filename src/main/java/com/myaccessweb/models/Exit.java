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
public class Exit extends Flow implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID exitId;
    @Column(nullable = false)
    private LocalDateTime exitDate;
    @Column(nullable = false)
    private UUID entranceId;
    
    public Exit() {
    }

    public Exit(UUID exitId, String document, String carModel, String carPlate, String destination, String wantedPeople, LocalDateTime exitDate, UUID entranceId) {
        super(document, carModel, carPlate, destination, wantedPeople);
        this.exitId = exitId;
        this.exitDate = exitDate;
        this.entranceId = entranceId;
    }

    public UUID getExitId() {
        return exitId;
    }
    
    public void setExitId(UUID exitId) {
        this.exitId = exitId;
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
