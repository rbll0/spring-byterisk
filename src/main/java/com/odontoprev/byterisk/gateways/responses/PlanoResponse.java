package com.odontoprev.byterisk.gateways.responses;

import lombok.Data;

@Data
public class PlanoResponse {

    private Long idPlano;
    private String nomePlano;
    private String tipoPlano;
    private Double valorMensal;
}
