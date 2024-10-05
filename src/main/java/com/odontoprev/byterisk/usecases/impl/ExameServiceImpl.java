package com.odontoprev.byterisk.usecases.impl;

import com.odontoprev.byterisk.domains.Exame;
import com.odontoprev.byterisk.gateways.repositories.BeneficiarioRepository;
import com.odontoprev.byterisk.gateways.repositories.ExameRepository;
import com.odontoprev.byterisk.gateways.repositories.ProfissionalRepository;
import com.odontoprev.byterisk.gateways.responses.ExameResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ExameServiceImpl {

    private final ExameRepository exameRepository;
    private final BeneficiarioRepository beneficiarioRepository;
    private final ProfissionalRepository profissionalRepository;

    private ExameResponse mapToResponse(Exame exame) {
        ExameResponse response = new ExameResponse();
        response.setIdExame(exame.getIdExame());
        response.setNomeBeneficiario(exame.getBeneficiario().getNome());
        response.setDataExame(exame.getDataExame());
        response.setTipoExame(exame.getTipoExame());
        response.setResultadoExame(exame.getResultadoExame());
        response.setNomeProfissional(exame.getProfissional().getNome());


        return response;
    }
}
