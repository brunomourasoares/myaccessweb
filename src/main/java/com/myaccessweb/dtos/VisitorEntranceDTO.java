package com.myaccessweb.dtos;

import java.io.Serializable;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class VisitorEntranceDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @NotBlank
    @Size(min = 9, max = 11)
    private String document;
    private String carModel;
    @NotBlank
    @Size(min = 7, max = 7)
    private String carPlate;
    @NotBlank
    @Size(max = 45)
    private String destiny;
    @NotBlank
    @Size(max = 45)
    private String wantedPeople;
}
