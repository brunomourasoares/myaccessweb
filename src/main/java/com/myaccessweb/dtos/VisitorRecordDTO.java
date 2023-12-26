package com.myaccessweb.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record VisitorRecordDTO (
    @NotBlank
    @Size(min = 9, max = 11)
    String document,
    @NotBlank
    @Size(max = 45)
    String name,
    @NotBlank
    @Size(max = 15)
    String gender,
    @Size(max = 11)
    String contactNumber,
    @Size(max = 100)
    String company,
    @Size(max = 500)
    String observation
    //String photoUrl
    ) {}