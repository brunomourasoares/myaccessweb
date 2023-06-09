package com.myaccessweb.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record UserUpdateRecordDTO(@NotBlank @Size(max = 255) String password, @NotNull Boolean blocked) {}
