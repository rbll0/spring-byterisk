package com.odontoprev.byterisk.gateways.controllers;

import com.odontoprev.byterisk.gateways.requests.PlanoRequest;
import com.odontoprev.byterisk.gateways.responses.PlanoResponse;
import com.odontoprev.byterisk.usecases.interfaces.PlanoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/plano")
@RequiredArgsConstructor
public class PlanoController {

    private final PlanoService planoService;

    @PostMapping
    public ResponseEntity<PlanoResponse> criarPlano(@Valid @RequestBody PlanoRequest request) {
        PlanoResponse response = planoService.criarPlano(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PlanoResponse> atualizarPlano(@PathVariable Long id, @Valid @RequestBody PlanoRequest request) {
        PlanoResponse response = planoService.atualizarPlano(id, request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlanoResponse> buscarPlanoPorId(@PathVariable Long id) {
        PlanoResponse response = planoService.buscarPlanoPorId(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<PlanoResponse>> buscarPlanos() {
        List<PlanoResponse> response = planoService.buscarPlanos();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPlano(@PathVariable Long id) {
        planoService.deletarPlano(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
