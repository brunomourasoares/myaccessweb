package com.myaccessweb.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record EntranceRecordDTO(@NotBlank @Size(min = 9, max = 11) String document, String carModel, @Size(min = 7, max = 7) String carPlate, 
                            @NotBlank @Size(max = 45) String destiny, @NotBlank @Size(max = 45) String wantedPeople) {}
