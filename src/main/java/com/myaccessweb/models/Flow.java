package com.myaccessweb.models;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Flow {
    
    @Column(nullable = false, length = 11)
    protected String document;
    @Column(length = 45)
    protected String carModel;
    @Column(length = 7)
    protected String carPlate;
    @Column(nullable = false, length = 45)
    protected String destination;
    @Column(nullable = false, length = 45)
    protected String wantedPeople;

    public Flow() {
    }

    public Flow(String document, String carModel, String carPlate, String destination, String wantedPeople) {
        this.document = document;
        this.carModel = carModel;
        this.carPlate = carPlate;
        this.destination = destination;
        this.wantedPeople = wantedPeople;
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
}
