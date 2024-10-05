package com.odontoprev.byterisk.gateways.controllers;

import com.odontoprev.byterisk.gateways.requests.ExameRequest;
import com.odontoprev.byterisk.gateways.responses.ExameResponse;
import com.odontoprev.byterisk.usecases.interfaces.ExameService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/exame")
@RequiredArgsConstructor
public class ExameController {

    private final ExameService exameService;

    @PostMapping
    public ResponseEntity<ExameResponse> criarExame(@Valid @RequestBody ExameRequest request) {
        ExameResponse response = exameService.criarExame(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ExameResponse> atualizarExame(@PathVariable Long id, @Valid @RequestBody ExameRequest request) {
        ExameResponse response = exameService.atualizarExame(id, request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ExameResponse> buscarExamePorId(@PathVariable Long id) {
        ExameResponse response = exameService.buscarExamePorId(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<ExameResponse>> buscarExames() {
        List<ExameResponse> response = exameService.buscarExames();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarExame(@PathVariable Long id) {
        exameService.deletarExame(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
