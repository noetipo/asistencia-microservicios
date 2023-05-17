package pe.upeu.msevento.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.upeu.msevento.entity.Evento;
import pe.upeu.msevento.entity.Matricula;
import pe.upeu.msevento.repository.MatriculaRepository;
import pe.upeu.msevento.service.MatriculaService;

import java.util.List;

@Service
public class MatriculaServiceImpl implements MatriculaService {
    @Autowired
    private MatriculaRepository matriculaRepository;

    @Override
    public List<Matricula> findByPersonaId(Integer id) {
        return matriculaRepository.findByPersonaId(id);
    }
}
