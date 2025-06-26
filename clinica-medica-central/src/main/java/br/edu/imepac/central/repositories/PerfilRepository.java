package br.edu.imepac.central.repositories;

import br.edu.imepac.central.models.Perfil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface PerfilRepository extends JpaRepository<Perfil, Long> {

}
