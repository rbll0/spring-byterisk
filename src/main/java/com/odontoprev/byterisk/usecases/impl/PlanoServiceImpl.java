package com.odontoprev.byterisk.usecases.impl;

import com.odontoprev.byterisk.domains.Plano;
import com.odontoprev.byterisk.gateways.repositories.PlanoRepository;
import com.odontoprev.byterisk.gateways.requests.PlanoRequest;
import com.odontoprev.byterisk.gateways.responses.PlanoResponse;
import com.odontoprev.byterisk.usecases.interfaces.PlanoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PlanoServiceImpl implements PlanoService {

    private final PlanoRepository planoRepository;


    @Override
    public PlanoResponse criarPlano(PlanoRequest request) {
        Plano plano = new Plano();
        plano.setNomePlano(request.getNomePlano());
        plano.setTipoPlano(request.getTipoPlano());
        plano.setValorMensal(request.getValorMensal());

        Plano salvo = planoRepository.save(plano);
        return mapToResponse(salvo);

    }

    @Override
    public PlanoResponse atualizarPlano(Long id, PlanoRequest request) {
        Plano plano = planoRepository.findById(id).orElseThrow();
        plano.setNomePlano(request.getNomePlano());
        plano.setTipoPlano(request.getTipoPlano());
        plano.setValorMensal(request.getValorMensal());

        Plano atualizado = planoRepository.save(plano);
        return mapToResponse(atualizado);
    }

    @Override
    public PlanoResponse buscarPlanoPorId(Long id) {
        Plano planoId = planoRepository.findById(id).orElseThrow();
        return mapToResponse(planoId);
    }

    @Override
    public List<PlanoResponse> buscarPlanos() {
        return planoRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public void deletarPlano(Long id) {
        planoRepository.deleteById(id);
    }

    private PlanoResponse mapToResponse(Plano plano) {
        PlanoResponse response = new PlanoResponse();
        response.setIdPlano(plano.getIdPlano());
        response.setNomePlano(plano.getNomePlano());
        response.setTipoPlano(plano.getTipoPlano());
        response.setValorMensal(plano.getValorMensal());
        return response;
    }
}
