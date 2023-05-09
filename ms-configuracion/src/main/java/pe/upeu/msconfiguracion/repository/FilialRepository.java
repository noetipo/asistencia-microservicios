package pe.upeu.msconfiguracion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.upeu.msconfiguracion.entity.Filial;

import java.util.List;

public interface FilialRepository extends JpaRepository<Filial, Integer> {

    public List<Filial> findByInstitucionId(Integer id);
}
