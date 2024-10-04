package com.odontoprev.byterisk.gateways.requests;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ExameRequest {

    @NotNull
    private Long idBeneficiario;

    @NotNull
    private LocalDate dataExame;

    private String tipoExame;

    private String resultadoExame;

    private Long idProfissional;
}
