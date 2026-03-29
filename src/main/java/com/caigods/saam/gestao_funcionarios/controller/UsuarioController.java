package com.caigods.saam.gestao_funcionarios.controller;

import com.caigods.saam.gestao_funcionarios.business.UsuarioService;
import com.caigods.saam.gestao_funcionarios.business.dto.UsuarioLoginDTO;
import com.caigods.saam.gestao_funcionarios.business.dto.UsuarioLoginResponseDTO;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;



 @PostMapping("/login")
 public ResponseEntity<UsuarioLoginResponseDTO> login(@RequestBody UsuarioLoginDTO dto) {
     return ResponseEntity.ok(usuarioService.login(dto));
 }
}
