package pe.upeu.msevento.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.upeu.msevento.entity.Matricula;

import java.util.List;
import java.util.Optional;

public interface MatriculaRepository extends JpaRepository<Matricula, Integer> {
    public List<Matricula> findByPersonaId(Integer id);
}
