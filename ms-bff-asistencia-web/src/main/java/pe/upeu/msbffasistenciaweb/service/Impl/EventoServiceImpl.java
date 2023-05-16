package pe.upeu.msbffasistenciaweb.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.upeu.msbffasistenciaweb.dto.EventoDto;
import pe.upeu.msbffasistenciaweb.feign.EventoFeign;
import pe.upeu.msbffasistenciaweb.service.EventoService;

import java.util.List;
import java.util.Optional;

@Service
public class EventoServiceImpl implements EventoService {
    @Autowired
    private EventoFeign eventoFeign;

    @Override
    public List<EventoDto> list() {
        return eventoFeign.list().getBody();
    }

    @Override
    public EventoDto save(EventoDto eventoDto) {
        return eventoFeign.save(eventoDto).getBody();
    }

    @Override
    public EventoDto update(EventoDto eventoDto) {
        return eventoFeign.update(eventoDto).getBody();
    }

    @Override
    public Optional<EventoDto> listById(Integer id) {
        return Optional.of(eventoFeign.listById(id).getBody());
    }

    @Override
    public void deleteById(Integer id) {
        eventoFeign.deleteById(id);
    }
}
