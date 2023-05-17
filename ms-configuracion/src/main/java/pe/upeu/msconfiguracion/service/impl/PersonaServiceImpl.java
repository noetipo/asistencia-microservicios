package pe.upeu.msconfiguracion.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.upeu.msconfiguracion.dto.PersonaDto;
import pe.upeu.msconfiguracion.entity.EscuelaProfesional;
import pe.upeu.msconfiguracion.entity.Periodo;
import pe.upeu.msconfiguracion.entity.Persona;
import pe.upeu.msconfiguracion.repository.PeriodoRepository;
import pe.upeu.msconfiguracion.repository.PersonaRepository;
import pe.upeu.msconfiguracion.service.PersonaService;

import java.beans.Transient;
import java.util.List;
import java.util.Optional;

@Service
public class PersonaServiceImpl implements PersonaService {
    @Autowired
    private PersonaRepository personaRepository;
    @Autowired
    private PeriodoRepository periodoRepository;

    @Override
    public List<Persona> list() {
        return personaRepository.findAll();
    }

    @Override
    public Persona save(PersonaDto personaDto) {
        Persona persona = new Persona();
        persona.setCodigo(personaDto.getCodigo());
        persona.setDni(personaDto.getDni());
        persona.setNombre(personaDto.getNombre());
        persona.setApellidoPaterno(personaDto.getApellidoPaterno());
        persona.setApellidoMaterno(personaDto.getApellidoMaterno());
        persona.setNombres(personaDto.getNombres());
        persona.setCorreo(personaDto.getCorreo());
        persona.setTipo(personaDto.getTipo());
        persona.setCiclo(personaDto.getCiclo());
        persona.setGrupo(personaDto.getGrupo());
        persona.setEstado(personaDto.getEstado());
        EscuelaProfesional escuelaProfesional = new EscuelaProfesional();
        escuelaProfesional.setId(personaDto.getEscuelaProfesionalId());
        persona.setEscuelaProfesional(escuelaProfesional);
        Optional<Periodo> periodo = periodoRepository.findByEstadoTrue();
        persona.setPeriodo(periodo.get());
        return personaRepository.save(persona);
    }


    @Override
    @Transient
    public Persona update(PersonaDto personaDto) {
        Optional<Persona> persona = personaRepository.findById(personaDto.getId());
        persona.get().setCodigo(personaDto.getCodigo());
        persona.get().setDni(personaDto.getDni());
        persona.get().setNombre(personaDto.getNombre());
        persona.get().setApellidoPaterno(personaDto.getApellidoPaterno());
        persona.get().setApellidoMaterno(personaDto.getApellidoMaterno());
        persona.get().setNombres(personaDto.getNombres());
        persona.get().setCorreo(personaDto.getCorreo());
        persona.get().setTipo(personaDto.getTipo());
        persona.get().setCiclo(personaDto.getCiclo());
        persona.get().setGrupo(personaDto.getGrupo());
        persona.get().setEstado(personaDto.getEstado());
        EscuelaProfesional escuelaProfesional = new EscuelaProfesional();
        escuelaProfesional.setId(personaDto.getEscuelaProfesionalId());
        persona.get().setEscuelaProfesional(escuelaProfesional);
        System.out.println(persona.get().getEscuelaProfesional().toString());
        return personaRepository.save(persona.get());
    }

    @Override
    public Optional<Persona> listById(Integer id) {
        return personaRepository.findById(id);
    }

    @Override
    public void deleteById(Integer id) {
        personaRepository.deleteById(id);
    }

    @Override
    public List<Persona> findByCicloAndGrupoAndEscuelaProfesionalIdAndEstadoTrue(String ciclo, String grupo, Integer escuelaProfesionalId) {
        return personaRepository.findByCicloAndGrupoAndEscuelaProfesionalIdAndEstadoTrue(ciclo, grupo, escuelaProfesionalId);
    }

    @Override
    public Optional<Persona> findByCodigoOrDni(String codigo, String dni) {
        return Optional.of(personaRepository.findByCodigoOrDni(codigo, dni).orElse(new Persona()));
    }
}
