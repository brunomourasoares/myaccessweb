package com.myaccessweb.dtos;

import java.io.Serializable;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VisitorDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @NotBlank
    @Size(min = 9, max = 11)
    private String document;
    @NotBlank
    @Size(max = 45)
    private String fullName;
    @NotBlank
    @Size(max = 15)
    private String gender;
    @NotBlank
    @Size(min = 8, max = 11)
    private String contactNumber;
    private String company;
    @Size(max = 500)
    private String observation;
    private Boolean blocked;
    private String photoUrl;
}
