package com.odontoprev.byterisk.gateways.responses;

import lombok.Data;

import java.time.LocalDate;


/**
 * Classe que representa a resposta com os dados de um exame. Usada para enviar as informações
 * do exame nas respostas da API.
 */
@Data
public class ExameResponse {

    private Long idExame;
    private String nomeBeneficiario;
    private LocalDate dataExame;
    private String tipoExame;
    private String resultadoExame;
    private String nomeProfissional;
}
