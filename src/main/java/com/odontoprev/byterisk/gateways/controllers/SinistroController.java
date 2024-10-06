package com.odontoprev.byterisk.gateways.controllers;

import com.odontoprev.byterisk.gateways.requests.SinistroRequest;
import com.odontoprev.byterisk.gateways.responses.SinistroResponse;
import com.odontoprev.byterisk.usecases.interfaces.SinistroService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador para gerenciar operações relacionadas aos sinistros.
 * Fornece endpoints para criar, atualizar, buscar e deletar sinistros.
 */
@RestController
@RequestMapping("/sinistro")
@RequiredArgsConstructor
public class SinistroController {

    private final SinistroService sinistroService;

    /**
     * Endpoint para criar um novo sinistro.
     *
     * @param request dados do sinistro a ser criado
     * @return resposta contendo o sinistro criado e o status HTTP 201
     */
    @PostMapping
    public ResponseEntity<SinistroResponse> criarSinistro(@Valid @RequestBody SinistroRequest request) {
        SinistroResponse response = sinistroService.criarSinistro(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    /**
     * Endpoint para atualizar um sinistro existente.
     *
     * @param id ID do sinistro a ser atualizado
     * @param request dados atualizados do sinistro
     * @return resposta contendo o sinistro atualizado e o status HTTP 200
     */
    @PutMapping("/{id}")
    public ResponseEntity<SinistroResponse> atualizarSinistro(@PathVariable Long id, @Valid @RequestBody SinistroRequest request) {
        SinistroResponse response = sinistroService.atualizarSinistro(id, request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    /**
     * Endpoint para buscar um sinistro pelo ID.
     *
     * @param id ID do sinistro
     * @return resposta contendo o sinistro encontrado e o status HTTP 200
     */
    @GetMapping("/{id}")
    public ResponseEntity<SinistroResponse> buscarSinistroPorId(@PathVariable Long id) {
        SinistroResponse response = sinistroService.buscarSinistroPorId(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    /**
     * Endpoint para buscar todos os sinistros.
     *
     * @return resposta contendo a lista de sinistros encontrados e o status HTTP 200
     */
    @GetMapping
    public ResponseEntity<List<SinistroResponse>> buscarSinistros() {
        List<SinistroResponse> response = sinistroService.buscarSinistros();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    /**
     * Endpoint para deletar um sinistro pelo ID.
     *
     * @param id ID do sinistro a ser deletado
     * @return status HTTP 204
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarSinistro(@PathVariable Long id) {
        sinistroService.deletarSinistro(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
