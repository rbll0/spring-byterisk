package com.odontoprev.byterisk.usecases.interfaces;


import com.odontoprev.byterisk.gateways.requests.BeneficiarioRequest;
import com.odontoprev.byterisk.gateways.responses.BeneficiarioResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BeneficiarioService {
    BeneficiarioResponse criarBeneficiario(BeneficiarioRequest request);
    BeneficiarioResponse atualizarBeneficiario(BeneficiarioRequest request);

    BeneficiarioResponse buscarBeneficiarioPorId(Long id);

    List<BeneficiarioResponse> buscarBeneficiarios();

    void deletarBeneficiario(Long id);
}
