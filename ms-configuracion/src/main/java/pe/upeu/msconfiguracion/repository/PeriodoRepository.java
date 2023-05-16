package pe.upeu.msconfiguracion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.upeu.msconfiguracion.entity.Periodo;

import java.util.Optional;

public interface PeriodoRepository extends JpaRepository<Periodo, Integer> {
    Optional<Periodo> findByEstadoTrue();
}
