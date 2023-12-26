package com.myaccessweb.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record EntranceRecordDTO (
    @NotBlank
    @Size(min = 9, max = 11)
    String document,
    @Size(max = 45) 
    String carModel, 
    @Size(max = 7) 
    String carPlate, 
    @NotBlank
    @Size(max = 45)
    String destination,
    @NotBlank
    @Size(max = 45)
    String wantedPeople
    ) {}
