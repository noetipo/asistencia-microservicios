package pe.upeu.msconfiguracion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.upeu.msconfiguracion.entity.Persona;

import java.util.List;

public interface PersonaRepository extends JpaRepository<Persona, Integer> {
    public List<Persona> findByCicloAndGrupoAndEscuelaProfesionalIdAndEstadoTrue(String ciclo, String grupo, Integer escuelaProfesionalId);
}
