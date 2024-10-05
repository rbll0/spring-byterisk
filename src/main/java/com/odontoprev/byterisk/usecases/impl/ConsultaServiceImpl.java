package com.odontoprev.byterisk.usecases.impl;

import com.odontoprev.byterisk.domains.Consulta;
import com.odontoprev.byterisk.gateways.repositories.BeneficiarioRepository;
import com.odontoprev.byterisk.gateways.repositories.ConsultaRepository;
import com.odontoprev.byterisk.gateways.repositories.ProfissionalRepository;
import com.odontoprev.byterisk.gateways.requests.ConsultaRequest;
import com.odontoprev.byterisk.gateways.responses.ConsultaResponse;
import com.odontoprev.byterisk.usecases.interfaces.ConsultaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ConsultaServiceImpl implements ConsultaService {

    private final ConsultaRepository consultaRepository;
    private final BeneficiarioRepository beneficiarioRepository;
    private final ProfissionalRepository profissionalRepository;

    @Override
    public ConsultaResponse criarConsulta(ConsultaRequest request) {
        Consulta consulta = new Consulta();
        consulta.setBeneficiario(beneficiarioRepository.findById(request.getIdBeneficiario())
                .orElseThrow());
        consulta.setDataConsulta(request.getDataConsulta());
        consulta.setMotivoConsulta(request.getMotivoConsulta());
        consulta.setStatus(request.getStatus());
        consulta.setProfissional(profissionalRepository.findById(request.getIdProfissional())
                .orElseThrow());

        Consulta salvo = consultaRepository.save(consulta);
        return mapToResponse(salvo);
    }


    @Override
    public ConsultaResponse atualizarConsulta(Long id, ConsultaRequest request) {
        Consulta consulta = consultaRepository.findById(id).orElseThrow();

        consulta.setDataConsulta(request.getDataConsulta());
        consulta.setMotivoConsulta(request.getMotivoConsulta());
        consulta.setStatus(request.getStatus());

        consulta.setProfissional(profissionalRepository.findById(request.getIdProfissional())
                .orElseThrow());

        Consulta atualizado = consultaRepository.save(consulta);
        return mapToResponse(atualizado);
    }

    @Override
    public ConsultaResponse buscarConsultaPorId(Long id) {
        Consulta consultaId = consultaRepository.findById(id).orElseThrow();
        return mapToResponse(consultaId);
    }

    @Override
    public List<ConsultaResponse> buscarConsultas() {
        return consultaRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public void deletarConsulta(Long id) {
        consultaRepository.deleteById(id);
    }

    private ConsultaResponse mapToResponse(Consulta consulta) {
        ConsultaResponse response = new ConsultaResponse();
        response.setIdConsulta(consulta.getIdConsulta());
        response.setNomeBeneficiario(consulta.getBeneficiario().getNome());
        response.setDataConsulta(consulta.getDataConsulta());
        response.setMotivoConsulta(consulta.getMotivoConsulta());
        response.setStatus(String.valueOf(consulta.getStatus()));
        response.setNomeProfissional(consulta.getProfissional().getNome());

        return response;
    }
}
