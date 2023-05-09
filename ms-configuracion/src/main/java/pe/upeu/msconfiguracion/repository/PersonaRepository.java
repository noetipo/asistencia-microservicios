package pe.upeu.msconfiguracion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.upeu.msconfiguracion.entity.Persona;

public interface PersonaRepository extends JpaRepository<Persona, Integer> {
}
