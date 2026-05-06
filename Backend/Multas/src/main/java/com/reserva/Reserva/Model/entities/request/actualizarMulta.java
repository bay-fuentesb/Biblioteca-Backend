package com.example.casosemestral.model.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class actualizarMulta {
    @NotBlank
    private int idMulta;
    @NotBlank
    private String motivoMulta;
}
