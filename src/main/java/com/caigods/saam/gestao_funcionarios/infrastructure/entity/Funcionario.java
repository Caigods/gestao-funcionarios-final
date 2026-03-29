package com.caigods.saam.gestao_funcionarios.infrastructure.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "funcionario")
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (name = "nome")
    @NotBlank (message = "Nome é obrigatório")
    private String nomeFuncionario;

    @NotNull(message = "Data de admissão é obrigatória")
    @Column (name = "data_admissao")
    private LocalDate dataAdimissao;

    @NotNull(message = "Salário é obrigatório")
    @Column (name="salario")
    private BigDecimal salario;

    @NotNull(message = "Status do funcionário é obrigatório")
    @Enumerated(EnumType.STRING)
    @Column (name= "status")
    private StatusFuncionario statusFuncionario;



}
