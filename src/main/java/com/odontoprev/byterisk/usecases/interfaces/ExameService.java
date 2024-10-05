package com.odontoprev.byterisk.usecases.interfaces;

import com.odontoprev.byterisk.gateways.requests.ExameRequest;
import com.odontoprev.byterisk.gateways.responses.ExameResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ExameService {
    ExameResponse criarExame(ExameRequest request);
    ExameResponse atualizarExame(Long id,ExameRequest request);
    ExameResponse buscarExamePorId(Long id);
    List<ExameResponse> buscarExames();
    void deletarExame(Long id);
}
