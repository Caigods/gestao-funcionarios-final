package com.caigods.saam.gestao_funcionarios.business;

import com.caigods.saam.gestao_funcionarios.business.dto.UsuarioLoginDTO;
import com.caigods.saam.gestao_funcionarios.business.dto.UsuarioLoginResponseDTO;
import com.caigods.saam.gestao_funcionarios.security.JwtUtil;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor

public class UsuarioService {

    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;


    //faz login via AuthManager+jwt
    public UsuarioLoginResponseDTO login(UsuarioLoginDTO dto) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(dto.getEmail(), dto.getSenha())
        );
        String token = jwtUtil.generateToken(authentication.getName());
        return UsuarioLoginResponseDTO.builder()
                .token(token)
                .build();
    }
}
