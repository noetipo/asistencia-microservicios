package pe.upeu.msbffasistenciaweb.service;

import pe.upeu.msbffasistenciaweb.dto.EventoDto;

import java.util.List;
import java.util.Optional;

public interface EventoService {
    public List<EventoDto> list();

    public EventoDto save(EventoDto eventoDto);

    public EventoDto update(EventoDto eventoDto);

    public Optional<EventoDto> listById(Integer id);

    public void deleteById(Integer id);
}
