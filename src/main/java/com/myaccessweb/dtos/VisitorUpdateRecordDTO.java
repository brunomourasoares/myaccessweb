package com.myaccessweb.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record VisitorUpdateRecordDTO(@NotBlank @Size(max = 45) String fullName, @NotBlank @Size(max = 15) String gender, 
                                    @NotBlank @Size(min = 8, max = 11) String contactNumber, String company, 
                                    @Size(max = 500) String observation, @NotNull Boolean blocked) {}
