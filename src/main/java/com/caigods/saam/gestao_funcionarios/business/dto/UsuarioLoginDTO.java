package com.caigods.saam.gestao_funcionarios.business.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter


public class UsuarioLoginDTO {

    private String email;

    private String senha;
}
