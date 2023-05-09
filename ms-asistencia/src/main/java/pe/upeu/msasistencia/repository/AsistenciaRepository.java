package pe.upeu.msasistencia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.upeu.msasistencia.entity.Asistencia;

public interface AsistenciaRepository extends JpaRepository<Asistencia, Integer> {
}
