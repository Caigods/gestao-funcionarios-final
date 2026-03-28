package com.caigods.saam.gestao_funcionarios.infrastructure.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
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
    @NotBlank (message = "Nome não pode estar vazio")
    private String nomeFuncionario;

    @Column (name = "data_adimissao")
    private LocalDate dataAdimissao;

    @Column (name="salario")
    private BigDecimal salario;

    @Column (name= "status")
    private StatusFuncionario statusFuncionario;



}
