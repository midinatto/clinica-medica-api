package br.edu.imepac.central.repositories;

import br.edu.imepac.central.models.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

}
