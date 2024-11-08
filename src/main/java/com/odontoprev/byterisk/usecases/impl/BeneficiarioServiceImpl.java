package com.odontoprev.byterisk.usecases.impl;

import com.odontoprev.byterisk.domains.Beneficiario;
import com.odontoprev.byterisk.domains.Plano;
import com.odontoprev.byterisk.gateways.procedures.BeneficiarioProcedures;
import com.odontoprev.byterisk.gateways.repositories.BeneficiarioRepository;
import com.odontoprev.byterisk.gateways.repositories.PlanoRepository;
import com.odontoprev.byterisk.gateways.requests.BeneficiarioRequest;
import com.odontoprev.byterisk.gateways.responses.BeneficiarioResponse;
import com.odontoprev.byterisk.usecases.interfaces.BeneficiarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

/**
 * Implementação do serviço de Beneficiario. Contém a lógica
 * para criar, atualizar, buscar e deletar beneficiários.
 */
@Service
@RequiredArgsConstructor
public class BeneficiarioServiceImpl implements BeneficiarioService {

    private final BeneficiarioRepository beneficiarioRepository;
    private final PlanoRepository planoRepository;
    private final BeneficiarioProcedures beneficiarioProcedures;

    @Override
    public BeneficiarioResponse criarBeneficiario(BeneficiarioRequest request) {
        // Converte a data de nascimento
        java.sql.Date dataNascimentoSql = java.sql.Date.valueOf(request.getDataNascimento());

        beneficiarioProcedures.inserirBeneficiario(
                request.getNome(),
                dataNascimentoSql,
                request.getCpf(),
                request.getTelefone(),
                request.getEmail(),
                request.getEndereco(),
                request.getRanking().toString(),
                request.getIdPlano()
        );

        Beneficiario beneficiario = beneficiarioRepository.findTopByCpf(request.getCpf())
                .orElseThrow(() -> new NoSuchElementException("Beneficiário não encontrado após inserção."));
        return mapToResponse(beneficiario);
    }

    @Override
    public BeneficiarioResponse atualizarBeneficiario(Long id, BeneficiarioRequest request) {
        // Converte a data de nascimento
        java.sql.Date dataNascimentoSql = java.sql.Date.valueOf(request.getDataNascimento());

        beneficiarioProcedures.atualizarBeneficiario(
                id,
                request.getNome(),
                dataNascimentoSql,
                request.getCpf(),
                request.getTelefone(),
                request.getEmail(),
                request.getEndereco(),
                request.getRanking().toString(),
                request.getIdPlano()
        );

        Beneficiario beneficiario = beneficiarioRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Beneficiário não encontrado com ID: " + id));
        return mapToResponse(beneficiario);
    }


    @Override
    public void deletarBeneficiario(Long id) {
        beneficiarioProcedures.deletarBeneficiario(id);
        beneficiarioRepository.deleteById(id);
    }

    @Override
    public BeneficiarioResponse buscarBeneficiarioPorId(Long id) {
        Beneficiario beneficiario = beneficiarioRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Beneficiário não encontrado com ID: " + id));
        return mapToResponse(beneficiario);
    }

    @Override
    public List<BeneficiarioResponse> buscarBeneficiarios() {
        return beneficiarioRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    private BeneficiarioResponse mapToResponse(Beneficiario beneficiario) {
        BeneficiarioResponse response = new BeneficiarioResponse();
        response.setIdBeneficiario(beneficiario.getIdBeneficiario());
        response.setNome(beneficiario.getNome());
        response.setCpf(beneficiario.getCpf());
        response.setTelefone(beneficiario.getTelefone());
        response.setEmail(beneficiario.getEmail());
        response.setEndereco(beneficiario.getEndereco());
        response.setRanking(beneficiario.getRanking());
        response.setNomePlano(beneficiario.getPlano().getNomePlano());
        return response;
    }
}