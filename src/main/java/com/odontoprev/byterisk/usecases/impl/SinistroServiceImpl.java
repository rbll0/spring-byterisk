package com.odontoprev.byterisk.usecases.impl;

import com.odontoprev.byterisk.domains.Sinistro;
import com.odontoprev.byterisk.domains.enums.TipoSinistro;
import com.odontoprev.byterisk.gateways.repositories.BeneficiarioRepository;
import com.odontoprev.byterisk.gateways.repositories.SinistroRepository;
import com.odontoprev.byterisk.gateways.responses.SinistroResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SinistroServiceImpl {

    private final SinistroRepository sinistroRepository;
    private final BeneficiarioRepository beneficiarioRepository;

    private SinistroResponse mapToResponse(Sinistro sinistro) {
        SinistroResponse response = new SinistroResponse();
        response.setIdSinistro(sinistro.getIdSinistro());
        response.setNomeBeneficiario(sinistro.getBeneficiario().getNome());
        response.setDataSinistro(sinistro.getDataSinistro());
        response.setTipoSinistro(TipoSinistro.valueOf(sinistro.getTipoSinistro()));
        response.setValorSinistro(sinistro.getValorSinistro());

        return response;
    }
}
