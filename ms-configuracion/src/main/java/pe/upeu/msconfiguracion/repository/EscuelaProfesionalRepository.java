package pe.upeu.msconfiguracion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.upeu.msconfiguracion.entity.EscuelaProfesional;

import java.util.List;

public interface EscuelaProfesionalRepository extends JpaRepository<EscuelaProfesional, Integer> {
    public List<EscuelaProfesional> findByFacultadId(Integer id);
}
