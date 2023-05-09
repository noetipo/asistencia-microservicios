package pe.upeu.msevento.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.upeu.msevento.entity.Evento;
import pe.upeu.msevento.repository.EventoRepository;
import pe.upeu.msevento.service.EventoService;

import java.util.List;
import java.util.Optional;

@Service
public class EventoServiceImpl implements EventoService {
    @Autowired
    private EventoRepository eventoRepository;

    @Override
    public List<Evento> list() {
        return eventoRepository.findAll();
    }

    @Override
    public Evento save(Evento evento) {
        return eventoRepository.save(evento);
    }

    @Override
    public Evento update(Evento evento) {
        return eventoRepository.save(evento);
    }

    @Override
    public Optional<Evento> listById(Integer id) {
        return eventoRepository.findById(id);
    }

    @Override
    public void deleteById(Integer id) {
        eventoRepository.deleteById(id);
    }
}
