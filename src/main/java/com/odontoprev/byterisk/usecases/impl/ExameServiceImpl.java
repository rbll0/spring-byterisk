package com.odontoprev.byterisk.usecases.impl;

import com.odontoprev.byterisk.domains.Exame;
import com.odontoprev.byterisk.gateways.repositories.BeneficiarioRepository;
import com.odontoprev.byterisk.gateways.repositories.ExameRepository;
import com.odontoprev.byterisk.gateways.repositories.ProfissionalRepository;
import com.odontoprev.byterisk.gateways.requests.ExameRequest;
import com.odontoprev.byterisk.gateways.responses.ExameResponse;
import com.odontoprev.byterisk.usecases.interfaces.ExameService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ExameServiceImpl implements ExameService {

    private final ExameRepository exameRepository;
    private final BeneficiarioRepository beneficiarioRepository;
    private final ProfissionalRepository profissionalRepository;


    @Override
    public ExameResponse criarExame(ExameRequest request) {
        Exame exame = new Exame();
        exame.setBeneficiario(beneficiarioRepository.findById(request.getIdBeneficiario())
                .orElseThrow(() -> new RuntimeException("Beneficiário não encontrado!")));
        exame.setDataExame(request.getDataExame());
        exame.setTipoExame(request.getTipoExame());
        exame.setResultadoExame(request.getResultadoExame());
        if (request.getIdProfissional() != null) {
            exame.setProfissional(profissionalRepository.findById(request.getIdProfissional())
                    .orElseThrow(() -> new RuntimeException("Profissional não encontrado!")));
        }

        Exame salvo = exameRepository.save(exame);
        return mapToResponse(salvo);
    }


    @Override
    public ExameResponse atualizarExame(Long id, ExameRequest request) {
        Exame exame = exameRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Exame não encontrado!"));

        exame.setDataExame(request.getDataExame());
        exame.setTipoExame(request.getTipoExame());
        exame.setResultadoExame(request.getResultadoExame());

        if (request.getIdProfissional() != null) {
            exame.setProfissional(profissionalRepository.findById(request.getIdProfissional())
                    .orElseThrow(() -> new RuntimeException("Profissional não encontrado!")));
        }

        Exame atualizado = exameRepository.save(exame);
        return mapToResponse(atualizado);
    }

    @Override
    public ExameResponse buscarExamePorId(Long id) {
        Exame exame = exameRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Exame não encontrado!"));
        return mapToResponse(exame);
    }

    @Override
    public List<ExameResponse> buscarExames() {
        return exameRepository.findAll().stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public void deletarExame(Long id) {
        exameRepository.deleteById(id);
    }
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
