package com.odontoprev.byterisk.usecases.impl;

import com.odontoprev.byterisk.domains.Sinistro;
import com.odontoprev.byterisk.domains.enums.TipoSinistro;
import com.odontoprev.byterisk.gateways.repositories.BeneficiarioRepository;
import com.odontoprev.byterisk.gateways.repositories.SinistroRepository;
import com.odontoprev.byterisk.gateways.requests.SinistroRequest;
import com.odontoprev.byterisk.gateways.responses.SinistroResponse;
import com.odontoprev.byterisk.usecases.interfaces.SinistroService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SinistroServiceImpl implements SinistroService {

    private final SinistroRepository sinistroRepository;
    private final BeneficiarioRepository beneficiarioRepository;

    @Override
    public SinistroResponse criarSinistro(SinistroRequest request) {
        Sinistro sinistro = new Sinistro();
        sinistro.setBeneficiario(beneficiarioRepository.findById(request.getIdBeneficiario())
                .orElseThrow());
        sinistro.setDataSinistro(request.getDataSinistro());
        sinistro.setTipoSinistro(String.valueOf(request.getTipoSinistro()));
        sinistro.setValorSinistro(request.getValorSinistro());


        Sinistro salvo = sinistroRepository.save(sinistro);
        return mapToResponse(salvo);
    }

    @Override
    public SinistroResponse atualizarSinistro(Long id, SinistroRequest request) {
        Sinistro sinistro = sinistroRepository.findById(id).orElseThrow();

        sinistro.setDataSinistro(request.getDataSinistro());
        sinistro.setTipoSinistro(String.valueOf(request.getTipoSinistro()));
        sinistro.setValorSinistro(request.getValorSinistro());

        Sinistro atualizado = sinistroRepository.save(sinistro);
        return mapToResponse(atualizado);
    }

    @Override
    public SinistroResponse buscarSinistroPorId(Long id) {
        Sinistro sinistroId = sinistroRepository.findById(id).orElseThrow();
        return mapToResponse(sinistroId);
    }

    @Override
    public List<SinistroResponse> buscarSinistros() {
        return sinistroRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public void deletarSinistro(Long id) {
        sinistroRepository.deleteById(id);
    }


    private SinistroResponse mapToResponse(Sinistro sinistro) {
        SinistroResponse response = new SinistroResponse();
        response.setIdSinistro(sinistro.getIdSinistro());
        response.setNomeBeneficiario(sinistro.getBeneficiario().getNome());
        response.setDataSinistro(sinistro.getDataSinistro());
        response.setTipoSinistro(TipoSinistro.valueOf(sinistro.getTipoSinistro()));
        response.setValorSinistro(sinistro.getValorSinistro());

        return response;
    }
}
