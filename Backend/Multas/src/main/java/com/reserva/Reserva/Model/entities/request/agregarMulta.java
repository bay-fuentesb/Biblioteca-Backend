package com.example.casosemestral.model.request;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class agregarMulta {
    @NotBlank
    private String motivoMulta;
    
}
