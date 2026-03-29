package com.caigods.saam.gestao_funcionarios.controller;

import com.caigods.saam.gestao_funcionarios.business.FuncionarioService;
import com.caigods.saam.gestao_funcionarios.business.dto.FuncionarioDTO;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@AllArgsConstructor
@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

    private final FuncionarioService funcionarioService;


    @PostMapping
    public ResponseEntity<FuncionarioDTO> salvarFuncionario(
            @RequestBody @Valid FuncionarioDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(funcionarioService.salvarFuncionario(dto));
    }


    @GetMapping
    public ResponseEntity<List<FuncionarioDTO>> listarFuncionarios() {
        return ResponseEntity.ok(funcionarioService.listarFuncionario());
    }
}

