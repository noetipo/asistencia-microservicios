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
    public List<PersonaDto.Response> list() {
        return configuracionFeign.listPersona().getBody();
    }

    @Override
    public PersonaDto.Response save(PersonaDto.Request personaDtoRequest) {
        return configuracionFeign.savePersona(personaDtoRequest).getBody();
    }

    @Override
    public PersonaDto.Response update(PersonaDto.Request personaDtoRequest) {
        return configuracionFeign.updatePersona(personaDtoRequest).getBody();
    }

    @Override
    public Optional<PersonaDto.Response> listById(Integer id) {
        return Optional.of(configuracionFeign.listByIdPersona(id).getBody());
    }

    @Override
    public void deleteById(Integer id) {
        configuracionFeign.deleteByIdPersona(id);
    }

    @Override
    public List<PersonaDto.Response> findByCicloAndGrupoAndEscuelaProfesionalIdAndEstadoTrue(String ciclo, String grupo, Integer escuelaProfesionalId) {
        return configuracionFeign.findByCicloAndGrupoAndEscuelaProfesionalIdAndEstadoTruePersona(ciclo, grupo, escuelaProfesionalId).getBody();
    }
}
