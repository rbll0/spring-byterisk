package com.odontoprev.byterisk.gateways.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class PlanoRequest {

    @NotBlank
    private String nomePlano;

    @NotBlank
    private String tipoPlano;

    @NotNull
    private Double valorMensal;
}
