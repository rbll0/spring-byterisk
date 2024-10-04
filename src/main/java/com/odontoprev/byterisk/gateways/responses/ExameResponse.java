package com.odontoprev.byterisk.gateways.responses;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ExameResponse {

    private Long idExame;
    private String nomeBeneficiario;
    private LocalDate dataExame;
    private String tipoExame;
    private String resultadoExame;
    private String nomeProfissional;
}
