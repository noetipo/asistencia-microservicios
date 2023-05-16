package pe.upeu.msbffasistenciaweb.service;

import pe.upeu.msbffasistenciaweb.dto.PersonaDto;

import java.util.List;
import java.util.Optional;

public interface PersonaService {
    public List<PersonaDto> list();

    public PersonaDto save(PersonaDto personaDto);

    public PersonaDto update(PersonaDto personaDto);

    public Optional<PersonaDto> listById(Integer id);

    public void deleteById(Integer id);

    public List<PersonaDto> findByCicloAndGrupoAndEscuelaProfesionalIdAndEstadoTrue(String ciclo, String grupo, Integer escuelaProfesionalId);
}
