package pe.upeu.msbffasistenciaweb.service;

import pe.upeu.msbffasistenciaweb.dto.EscuelaProfesionalDto;

import java.util.List;
import java.util.Optional;

public interface EscuelaProfesionalService {
    public List<EscuelaProfesionalDto> list();

    public EscuelaProfesionalDto save(EscuelaProfesionalDto escuelaProfesionalDto);

    public EscuelaProfesionalDto update(EscuelaProfesionalDto escuelaProfesionalDto);

    public Optional<EscuelaProfesionalDto> listById(Integer id);

    public void deleteById(Integer id);

    public List<EscuelaProfesionalDto> findByFacultadId(Integer id);
}
