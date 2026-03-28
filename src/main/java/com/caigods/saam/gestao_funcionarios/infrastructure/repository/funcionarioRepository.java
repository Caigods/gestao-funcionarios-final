package com.caigods.saam.gestao_funcionarios.infrastructure.repository;

import com.caigods.saam.gestao_funcionarios.infrastructure.entity.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface funcionarioRepository extends JpaRepository<Funcionario, Long> {


}
