package com.caigods.saam.gestao_funcionarios.controller;

import com.caigods.saam.gestao_funcionarios.business.dto.UsuarioLoginDTO;
import com.caigods.saam.gestao_funcionarios.business.dto.UsuarioLoginResponseDTO;
import com.caigods.saam.gestao_funcionarios.security.JwtUtil;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;



 @PostMapping("/login")
    public ResponseEntity<UsuarioLoginResponseDTO> login (@RequestBody UsuarioLoginDTO usuarioLogindto){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(usuarioLogindto.getEmail(),
                        usuarioLogindto.getSenha())
        );
        String token = jwtUtil.generateToken(authentication.getName());
        return ResponseEntity.ok(new UsuarioLoginResponseDTO(token));
    }
}
