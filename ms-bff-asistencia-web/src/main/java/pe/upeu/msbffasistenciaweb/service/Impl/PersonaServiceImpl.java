package pe.upeu.msbffasistenciaweb.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.upeu.msbffasistenciaweb.dto.PersonaDto;
import pe.upeu.msbffasistenciaweb.feign.ConfiguracionFeign;
import pe.upeu.msbffasistenciaweb.service.PersonaService;

import java.util.List;
import java.util.Optional;

@Service
public class PersonaServiceImpl implements PersonaService {
    @Autowired
    private ConfiguracionFeign configuracionFeign;

    @Override
    public List<PersonaDto> list() {
        return configuracionFeign.listPersona().getBody();
    }

    @Override
    public PersonaDto save(PersonaDto personaDto) {
        return configuracionFeign.savePersona(personaDto).getBody();
    }

    @Override
    public PersonaDto update(PersonaDto personaDto) {
        return configuracionFeign.updatePersona(personaDto).getBody();
    }

    @Override
    public Optional<PersonaDto> listById(Integer id) {
        return Optional.of(configuracionFeign.listByIdPersona(id).getBody());
    }

    @Override
    public void deleteById(Integer id) {
        configuracionFeign.deleteByIdPersona(id);
    }

    @Override
    public List<PersonaDto> findByCicloAndGrupoAndEscuelaProfesionalIdAndEstadoTrue(String ciclo, String grupo, Integer escuelaProfesionalId) {
        return configuracionFeign.findByCicloAndGrupoAndEscuelaProfesionalIdAndEstadoTruePersona(ciclo, grupo, escuelaProfesionalId).getBody();
    }
}
