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

@RestController
@RequestMapping("/sinistro")
@RequiredArgsConstructor
public class SinistroController {

    private final SinistroService sinistroService;

    @PostMapping
    public ResponseEntity<SinistroResponse> criarSinistro(@Valid @RequestBody SinistroRequest request) {
        SinistroResponse response = sinistroService.criarSinistro(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SinistroResponse> atualizarSinistro(@PathVariable Long id, @Valid @RequestBody SinistroRequest request) {
        SinistroResponse response = sinistroService.atualizarSinistro(id, request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SinistroResponse> buscarSinistroPorId(@PathVariable Long id) {
        SinistroResponse response = sinistroService.buscarSinistroPorId(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<SinistroResponse>> buscarSinistros() {
        List<SinistroResponse> response = sinistroService.buscarSinistros();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarSinistro(@PathVariable Long id) {
        sinistroService.deletarSinistro(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
