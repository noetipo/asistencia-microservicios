package pe.upeu.msevento.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.upeu.msevento.entity.Evento;

public interface EventoRepository extends JpaRepository<Evento, Integer> {
}
