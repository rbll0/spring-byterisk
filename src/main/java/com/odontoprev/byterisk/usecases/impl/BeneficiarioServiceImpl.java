package com.odontoprev.byterisk.usecases.impl;

import com.odontoprev.byterisk.domains.Beneficiario;
import com.odontoprev.byterisk.domains.Plano;
import com.odontoprev.byterisk.gateways.repositories.BeneficiarioRepository;
import com.odontoprev.byterisk.gateways.repositories.PlanoRepository;
import com.odontoprev.byterisk.gateways.requests.BeneficiarioRequest;
import com.odontoprev.byterisk.gateways.responses.BeneficiarioResponse;
import com.odontoprev.byterisk.usecases.interfaces.BeneficiarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
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

    /**
     * Cria um novo beneficiário com os dados fornecidos na requisição.
     *
     * @param request dados do novo beneficiário
     * @return o beneficiário criado como resposta
     */
    @Override
    public BeneficiarioResponse criarBeneficiario(BeneficiarioRequest request) {
        Beneficiario beneficiario = new Beneficiario();
        // Copia os atributos de request para beneficiario

        beneficiario.setNome(request.getNome());
        beneficiario.setCpf(request.getCpf());
        beneficiario.setDataNascimento(request.getDataNascimento());
        beneficiario.setTelefone(request.getTelefone());
        beneficiario.setEmail(request.getEmail());
        beneficiario.setEndereco(request.getEndereco());
        beneficiario.setRanking(request.getRanking());
        Plano plano = planoRepository.findById(request.getIdPlano()).orElseThrow();
        beneficiario.setPlano(plano);


        Beneficiario salvo = beneficiarioRepository.save(beneficiario);
        return mapToResponse(salvo);
    }

    /**
     * Atualiza um beneficiário existente com os novos dados fornecidos.
     *
     * @param id ID do beneficiário a ser atualizado
     * @param request dados atualizados do beneficiário
     * @return o beneficiário atualizado como resposta
     */
    @Override
    public BeneficiarioResponse atualizarBeneficiario(Long id, BeneficiarioRequest request) {
        Beneficiario beneficiario = beneficiarioRepository.findById(id).orElseThrow();
        // Copia os atributos de request para beneficiario

        beneficiario.setNome(request.getNome());
        beneficiario.setCpf(request.getCpf());
        beneficiario.setDataNascimento(request.getDataNascimento());
        beneficiario.setTelefone(request.getTelefone());
        beneficiario.setEmail(request.getEmail());
        beneficiario.setEndereco(request.getEndereco());
        beneficiario.setRanking(request.getRanking());


        Beneficiario salvo = beneficiarioRepository.save(beneficiario);
        return mapToResponse(salvo);
    }

    /**
     * Busca um beneficiário pelo ID.
     *
     * @param id ID do beneficiário
     * @return o beneficiário encontrado como resposta
     */
    @Override
    public BeneficiarioResponse buscarBeneficiarioPorId(Long id) {
        Beneficiario beneficiario = beneficiarioRepository.findById(id).orElseThrow();
        return mapToResponse(beneficiario);
    }

    /**
     * Retorna uma lista com todos os beneficiários cadastrados.
     *
     * @return lista de beneficiários como resposta
     */
    @Override
    public List<BeneficiarioResponse> buscarBeneficiarios() {
        return beneficiarioRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    /**
     * Deleta um beneficiário pelo ID.
     *
     * @param id ID do beneficiário a ser deletado
     */
    @Override
    public void deletarBeneficiario(Long id) {
        beneficiarioRepository.deleteById(id);
    }

    /**
     * Mapeia a entidade Beneficiario para BeneficiarioResponse.
     *
     * @param beneficiario o beneficiário a ser mapeado
     * @return o objeto BeneficiarioResponse correspondente
     */
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
