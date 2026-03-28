package com.caigods.saam.gestao_funcionarios.controller;

import com.caigods.saam.gestao_funcionarios.business.FuncionarioService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/")
public class FuncionarioController {

    private final FuncionarioService funcionarioService;





}
