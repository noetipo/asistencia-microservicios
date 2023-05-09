package pe.upeu.msconfiguracion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.upeu.msconfiguracion.entity.Facultad;

import java.util.List;

public interface FacultadRepository extends JpaRepository<Facultad, Integer> {
    public List<Facultad> findByFilialId(Integer id);
}
