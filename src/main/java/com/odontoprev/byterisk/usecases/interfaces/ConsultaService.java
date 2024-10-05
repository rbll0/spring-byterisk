package com.odontoprev.byterisk.usecases.interfaces;

import com.odontoprev.byterisk.gateways.requests.ConsultaRequest;
import com.odontoprev.byterisk.gateways.responses.ConsultaResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ConsultaService {

    ConsultaResponse criarConsulta(ConsultaRequest request);
    ConsultaResponse atualizarConsulta(Long id,ConsultaRequest request);
    ConsultaResponse buscarConsultaPorId(Long id);
    List<ConsultaResponse> buscarConsultas();
    void deletarConsulta(Long id);
}
