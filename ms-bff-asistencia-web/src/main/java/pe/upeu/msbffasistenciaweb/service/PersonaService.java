package pe.upeu.msbffasistenciaweb.service;

import pe.upeu.msbffasistenciaweb.dto.PersonaDto;

import java.util.List;
import java.util.Optional;

public interface PersonaService {
    public List<PersonaDto.Response> list();

    public PersonaDto.Response save(PersonaDto.Request personaDtoRequest);

    public PersonaDto.Response update(PersonaDto.Request personaDtoRequest);

    public Optional<PersonaDto.Response> listById(Integer id);

    public void deleteById(Integer id);

    public List<PersonaDto.Response> findByCicloAndGrupoAndEscuelaProfesionalIdAndEstadoTrue(String ciclo, String grupo, Integer escuelaProfesionalId);
}
