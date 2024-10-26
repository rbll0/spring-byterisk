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

/**
 * Implementação do serviço de Plano. Contém a lógica para criar, atualizar, buscar e deletar planos.
 */
@Service
@RequiredArgsConstructor
public class PlanoServiceImpl implements PlanoService {

    private final PlanoRepository planoRepository;


    /**
     * Cria um novo plano com os dados fornecidos na requisição.
     *
     * @param request dados do novo plano
     * @return o plano criado como resposta
     */
    @Override
    public PlanoResponse criarPlano(PlanoRequest request) {
        Plano plano = new Plano();
        plano.setNomePlano(request.getNomePlano());
        plano.setTipoPlano(request.getTipoPlano());
        plano.setValorMensal(request.getValorMensal());

        Plano salvo = planoRepository.save(plano);
        return mapToResponse(salvo);

    }


    /**
     * Atualiza um plano existente com os novos dados fornecidos.
     *
     * @param id ID do plano a ser atualizado
     * @param request dados atualizados do plano
     * @return o plano atualizado como resposta
     */
    @Override
    public PlanoResponse atualizarPlano(Long id, PlanoRequest request) {
        Plano plano = planoRepository.findById(id).orElseThrow();
        plano.setNomePlano(request.getNomePlano());
        plano.setTipoPlano(request.getTipoPlano());
        plano.setValorMensal(request.getValorMensal());

        Plano atualizado = planoRepository.save(plano);
        return mapToResponse(atualizado);
    }

    /**
     * Busca um plano pelo ID.
     *
     * @param id ID do plano
     * @return o plano encontrado como resposta
     */
    @Override
    public PlanoResponse buscarPlanoPorId(Long id) {
        Plano planoId = planoRepository.findById(id).orElseThrow();
        return mapToResponse(planoId);
    }

    /**
     * Retorna uma lista com todos os planos cadastrados.
     *
     * @return lista de planos como resposta
     */
    @Override
    public List<PlanoResponse> buscarPlanos() {
        return planoRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    /**
     * Deleta um plano pelo ID.
     *
     * @param id ID do plano a ser deletado
     */
    @Override
    public void deletarPlano(Long id) {
        planoRepository.deleteById(id);
    }

    /**
     * Mapeia a entidade Plano para PlanoResponse.
     *
     * @param plano o plano a ser mapeado
     * @return o objeto PlanoResponse correspondente
     */
    private PlanoResponse mapToResponse(Plano plano) {
        PlanoResponse response = new PlanoResponse();
        response.setIdPlano(plano.getIdPlano());
        response.setNomePlano(plano.getNomePlano());
        response.setTipoPlano(plano.getTipoPlano());
        response.setValorMensal(plano.getValorMensal());
        return response;
    }
}
