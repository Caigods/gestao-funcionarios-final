package com.caigods.saam.gestao_funcionarios.business.converter;

import com.caigods.saam.gestao_funcionarios.business.dto.FuncionarioDTO;
import com.caigods.saam.gestao_funcionarios.infrastructure.entity.Funcionario;
import org.springframework.stereotype.Component;

@Component
public class FuncionarioConverter {


    //Converte de Entity para dto
    public FuncionarioDTO toDTO(Funcionario funcionario) {
        FuncionarioDTO funcionarioDTO = new FuncionarioDTO();

        funcionarioDTO.setId(funcionario.getId());
        funcionarioDTO.setNomeFuncionario(funcionario.getNomeFuncionario());
        funcionarioDTO.setDataAdimissao(funcionario.getDataAdimissao());
        funcionarioDTO.setSalario(funcionario.getSalario());
        funcionarioDTO.setStatusFuncionario(funcionario.getStatusFuncionario());
        return funcionarioDTO;
    }

    //Converte de dto para entity
    public Funcionario toFuncionario(FuncionarioDTO funcionarioDTO) {
        Funcionario entityFuncionario = new Funcionario();

        entityFuncionario.setNomeFuncionario(funcionarioDTO.getNomeFuncionario());
        entityFuncionario.setDataAdimissao(funcionarioDTO.getDataAdimissao());
        entityFuncionario.setSalario(funcionarioDTO.getSalario());
        entityFuncionario.setStatusFuncionario(funcionarioDTO.getStatusFuncionario());
        return entityFuncionario;


    }
}

