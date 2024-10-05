package com.odontoprev.byterisk.usecases.interfaces;

import com.odontoprev.byterisk.gateways.requests.SinistroRequest;
import com.odontoprev.byterisk.gateways.responses.SinistroResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SinistroService {

    SinistroResponse criarSinistro(SinistroRequest request);
    SinistroResponse atualizarSinistro(Long id,SinistroRequest request);
    SinistroResponse buscarSinistroPorId(Long id);
    List<SinistroResponse> buscarSinistros();
    void deletarSinistro(Long id);
}
