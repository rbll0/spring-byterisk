package com.odontoprev.byterisk.gateways.responses;


import com.odontoprev.byterisk.domains.enums.TipoSinistro;
import lombok.Data;

import java.time.LocalDate;

@Data
public class SinistroResponse {

    private Long idSinistro;
    private String nomeBeneficiario;
    private LocalDate dataSinistro;
    private TipoSinistro tipoSinistro;
    private Double valorSinistro;
}
