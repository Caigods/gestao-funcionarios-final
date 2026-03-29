package com.caigods.saam.gestao_funcionarios.business.dto;

import com.caigods.saam.gestao_funcionarios.infrastructure.entity.StatusFuncionario;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class FuncionarioDTO {

    private Long id;

    private String nomeFuncionario;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate dataAdimissao;

    private BigDecimal salario;

    private StatusFuncionario statusFuncionario;
}
