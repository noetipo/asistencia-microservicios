package pe.upeu.msasistencia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.upeu.msasistencia.entity.Asistencia;

import java.util.List;
import java.util.Optional;

public interface AsistenciaRepository extends JpaRepository<Asistencia, Integer> {
    public Optional<Asistencia> findByEventoDetalleIdAndMatriculaId(Integer eventoDetalleid, Integer matriculaId);
}
