package com.odontoprev.byterisk.usecases.interfaces;

import com.odontoprev.byterisk.gateways.requests.PlanoRequest;
import com.odontoprev.byterisk.gateways.responses.PlanoResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PlanoService {
    PlanoResponse criarPlano(PlanoRequest request);
    PlanoResponse atualizarPlano(Long id,PlanoRequest request);
    PlanoResponse buscarPlanoPorId(Long id);
    List<PlanoResponse> buscarPlanos();
    void deletarPlano(Long id);
}
