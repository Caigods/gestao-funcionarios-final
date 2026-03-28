package com.caigods.saam.gestao_funcionarios.business;

import com.caigods.saam.gestao_funcionarios.business.converter.FuncionarioConverter;
import com.caigods.saam.gestao_funcionarios.business.dto.FuncionarioDTO;
import com.caigods.saam.gestao_funcionarios.business.exception.BadRequestException;
import com.caigods.saam.gestao_funcionarios.infrastructure.entity.Funcionario;
import com.caigods.saam.gestao_funcionarios.infrastructure.repository.FuncionarioRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@Service
public class FuncionarioService {

    private final FuncionarioRepository funcionarioRepository;
    private final FuncionarioConverter funcionarioConverter;

    @Transactional
    public FuncionarioDTO salvarFuncionario(FuncionarioDTO funcionarioDTO) {
        validarDataAdmissao(funcionarioDTO.getDataAdimissao());
        validarSalarioNeg(funcionarioDTO.getSalario());
        Funcionario funcionario = funcionarioConverter.toFuncionario(funcionarioDTO);

        return funcionarioConverter.toDTO(funcionarioRepository.save(funcionario));
    }

    public List<FuncionarioDTO> listarFuncionario() {
        List<Funcionario> funcionarios = funcionarioRepository.findAll();

        return funcionarios.stream().map(funcionarioConverter::toDTO).toList();
    }


    //Validacoes
    public void validarDataAdmissao(LocalDate dataAdmissao) {
        if (dataAdmissao == null) return;
        LocalDate dataHoje = LocalDate.now();
        if (dataAdmissao.isAfter(dataHoje)) {
            throw new BadRequestException("Data de admissão não pode ser no futuro.");
        }
    }

    public void validarSalarioNeg(BigDecimal salario){
        if (salario == null) return;
        if (salario.compareTo(BigDecimal.ZERO) < 0){
            throw new BadRequestException("Salário deve ser positivo");
        }
    }
}
