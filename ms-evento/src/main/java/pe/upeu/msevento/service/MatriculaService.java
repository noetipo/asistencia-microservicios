package pe.upeu.msevento.service;

import pe.upeu.msevento.entity.Matricula;

import java.util.List;

public interface MatriculaService {
    public List<Matricula> findByPersonaId(Integer id);
}
