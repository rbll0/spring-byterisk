package com.odontoprev.byterisk.gateways.requests;

import com.odontoprev.byterisk.domains.enums.Ranking;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
public class BeneficiarioRequest {

    @NotBlank
    private String nome;

    @NotNull
    private LocalDate dataNascimento;

    @NotBlank
    private String cpf;

    private String telefone;

    @Email
    private String email;

    private String endereco;

    @NotNull
    private Ranking ranking;

    @NotNull
    private Long idPlano;
}
