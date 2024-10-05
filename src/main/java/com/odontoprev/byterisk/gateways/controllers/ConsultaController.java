package com.odontoprev.byterisk.gateways.controllers;

import com.odontoprev.byterisk.gateways.requests.ConsultaRequest;
import com.odontoprev.byterisk.gateways.responses.ConsultaResponse;
import com.odontoprev.byterisk.usecases.interfaces.ConsultaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/consulta")
@RequiredArgsConstructor
public class ConsultaController {

    private final ConsultaService consultaService;

    @PostMapping
    public ResponseEntity<ConsultaResponse> criarConsulta(@Valid @RequestBody ConsultaRequest request) {
        ConsultaResponse response = consultaService.criarConsulta(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ConsultaResponse> atualizarConsulta(@PathVariable Long id, @Valid @RequestBody ConsultaRequest request) {
        ConsultaResponse response = consultaService.atualizarConsulta(id, request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ConsultaResponse> buscarConsultaPorId(@PathVariable Long id) {
        ConsultaResponse response = consultaService.buscarConsultaPorId(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<ConsultaResponse>> buscarConsultas() {
        List<ConsultaResponse> response = consultaService.buscarConsultas();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarConsulta(@PathVariable Long id) {
        consultaService.deletarConsulta(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
