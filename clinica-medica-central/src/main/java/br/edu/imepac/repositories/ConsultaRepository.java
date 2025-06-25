package br.edu.imepac.repositories;

import br.edu.imepac.models.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultaRepository extends JpaRepository<Consulta, Long> {
}
