package com.odontoprev.byterisk.gateways.responses;

import lombok.Data;

/**
 * Classe que representa a resposta com os dados de um plano odontológico.
 * Usada para enviar as informações do plano nas respostas da API.
 */

@Data
public class PlanoResponse {

    private Long idPlano;
    private String nomePlano;
    private String tipoPlano;
    private Double valorMensal;
}
