package pe.upeu.msconfiguracion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.upeu.msconfiguracion.entity.Periodo;

public interface PeriodoRepository extends JpaRepository<Periodo, Integer> {
}
