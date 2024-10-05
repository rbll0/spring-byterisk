package com.odontoprev.byterisk.gateways.controllers;

import com.odontoprev.byterisk.domains.Beneficiario;
import com.odontoprev.byterisk.gateways.requests.BeneficiarioRequest;
import com.odontoprev.byterisk.gateways.responses.BeneficiarioResponse;
import com.odontoprev.byterisk.usecases.interfaces.BeneficiarioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/beneficiario")
@RequiredArgsConstructor
public class BeneficiarioController {

    private final BeneficiarioService beneficiarioService;


    @PostMapping
    public ResponseEntity<BeneficiarioResponse> criarBeneficiario(@Valid @RequestBody BeneficiarioRequest request){
        BeneficiarioResponse response = beneficiarioService.criarBeneficiario(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BeneficiarioResponse> atualizarBeneficiario(@PathVariable Long id, @Valid @RequestBody BeneficiarioRequest request) {
        BeneficiarioResponse response = beneficiarioService.atualizarBeneficiario(id, request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BeneficiarioResponse> buscarBeneficiarioPorId(@PathVariable Long id) {
        BeneficiarioResponse response = beneficiarioService.buscarBeneficiarioPorId(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<BeneficiarioResponse>> buscarBeneficiarios() {
        List<BeneficiarioResponse> response = beneficiarioService.buscarBeneficiarios();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarBeneficiario(@PathVariable Long id) {
        beneficiarioService.deletarBeneficiario(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
