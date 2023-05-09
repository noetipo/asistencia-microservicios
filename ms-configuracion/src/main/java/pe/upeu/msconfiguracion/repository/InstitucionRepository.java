package pe.upeu.msconfiguracion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.upeu.msconfiguracion.entity.Institucion;

public interface InstitucionRepository extends JpaRepository<Institucion, Integer> {
}
