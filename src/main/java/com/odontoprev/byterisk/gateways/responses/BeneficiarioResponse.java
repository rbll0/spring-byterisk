package com.odontoprev.byterisk.gateways.responses;

import com.odontoprev.byterisk.domains.enums.Ranking;
import lombok.Data;

@Data
public class BeneficiarioResponse {

    private Long idBeneficiario;
    private String nome;
    private String cpf;
    private String telefone;
    private String email;
    private String endereco;
    private Ranking ranking;
    private String nomePlano;
}
