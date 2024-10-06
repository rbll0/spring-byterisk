package com.odontoprev.byterisk.gateways.responses;

import com.odontoprev.byterisk.domains.enums.Ranking;
import lombok.Data;

/**
 * Classe que representa a resposta com os dados de um beneficiário. Usada para enviar as informações
 * do beneficiário nas respostas da API.
 */
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
