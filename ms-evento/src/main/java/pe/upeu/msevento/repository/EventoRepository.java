package pe.upeu.msevento.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.upeu.msevento.entity.Evento;
import pe.upeu.msevento.entity.Matricula;

import java.util.List;
import java.util.Optional;

public interface EventoRepository extends JpaRepository<Evento, Integer> {
    List<Evento> findByEscuelaProfesionalIdAndEstadoTrue(Integer id);
}
