package pe.upeu.msevento.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.upeu.msevento.entity.Evento;

import java.util.List;

public interface EventoRepository extends JpaRepository<Evento, Integer> {
    List<Evento> findByEscuelaProfesionalIdAndEstadoTrue(Integer id);
}
