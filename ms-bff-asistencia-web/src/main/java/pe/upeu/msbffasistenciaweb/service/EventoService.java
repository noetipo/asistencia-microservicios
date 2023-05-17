package pe.upeu.msbffasistenciaweb.service;

import org.springframework.http.ResponseEntity;
import pe.upeu.msbffasistenciaweb.dto.EventoDto;

import java.util.List;
import java.util.Optional;

public interface EventoService {
    public List<EventoDto.Response> list();

    public EventoDto.Response save(EventoDto.Request eventoDtoRequest);

    public EventoDto.Response update(EventoDto.Request eventoDtoRequest);

    public Optional<EventoDto.Response> listById(Integer id);

    public void deleteById(Integer id);

    public ResponseEntity<List<EventoDto.Response>> findByEscuelaProfesionalIdAndEstadoTrue(Integer id);

}
