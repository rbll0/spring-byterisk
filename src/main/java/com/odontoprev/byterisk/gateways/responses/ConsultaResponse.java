package com.odontoprev.byterisk.gateways.responses;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ConsultaResponse {

    private Long idConsulta;
    private String nomeBeneficiario;
    private LocalDate dataConsulta;
    private String motivoConsulta;
    private String status;
    private String nomeProfissional;
}
