package pe.upeu.msconfiguracion.service;

import pe.upeu.msconfiguracion.dto.PersonaDto;
import pe.upeu.msconfiguracion.entity.Persona;

import java.util.List;
import java.util.Optional;

public interface PersonaService {
    public List<Persona> list();

    public Persona save(PersonaDto personaDto);

    public Persona update(PersonaDto personaDto);

    public Optional<Persona> listById(Integer id);

    public void deleteById(Integer id);

    public List<Persona> findByCicloAndGrupoAndEscuelaProfesionalIdAndEstadoTrue(String ciclo, String grupo, Integer escuelaProfesionalId);

    public Optional<Persona> findByCodigoOrDni(String codigo, String dni);
}
