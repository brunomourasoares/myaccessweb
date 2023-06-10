package com.myaccessweb.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record ExitRecordDTO(@NotBlank @Size(min = 9, max = 11) String document) {}
