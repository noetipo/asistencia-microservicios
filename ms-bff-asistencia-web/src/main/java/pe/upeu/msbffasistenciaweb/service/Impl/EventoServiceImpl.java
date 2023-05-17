package pe.upeu.msbffasistenciaweb.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pe.upeu.msbffasistenciaweb.dto.EscuelaProfesionalDto;
import pe.upeu.msbffasistenciaweb.dto.EventoDto;
import pe.upeu.msbffasistenciaweb.dto.MatriculaDto;
import pe.upeu.msbffasistenciaweb.dto.PersonaDto;
import pe.upeu.msbffasistenciaweb.feign.AsistenciaFeign;
import pe.upeu.msbffasistenciaweb.feign.ConfiguracionFeign;
import pe.upeu.msbffasistenciaweb.feign.EventoFeign;
import pe.upeu.msbffasistenciaweb.service.EventoService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EventoServiceImpl implements EventoService {
    @Autowired
    private EventoFeign eventoFeign;
    @Autowired
    private ConfiguracionFeign configuracionFeign;
    @Autowired
    private AsistenciaFeign asistenciaFeign;

    @Override
    public List<EventoDto.Response> list() {

        List<EventoDto.Response> responseList = eventoFeign.list().getBody().parallelStream().map(response -> {
            EscuelaProfesionalDto escuelaProfesionalDto = configuracionFeign.listByIdEscuelaProfesional(response.getEscuelaProfesionalId()).getBody();
            response.setEscuelaProfesionalDto(escuelaProfesionalDto);
            return response;
        }).collect(Collectors.toList());
        return responseList;
    }

    @Override
    public EventoDto.Response save(EventoDto.Request eventoDtoRequest) {
        eventoDtoRequest.setPeriodoId(configuracionFeign.findByEstadoTrue().getBody().getId());
        eventoFeign.save(eventoDtoRequest).getBody();
        return new EventoDto.Response();
    }

    @Override
    public EventoDto.Response update(EventoDto.Request eventoDtoRequest) {
        eventoFeign.save(eventoDtoRequest).getBody();
        return new EventoDto.Response();
    }

    @Override
    public Optional<EventoDto.Response> listById(Integer id) {
        EventoDto.Response eventoDtoResponse = eventoFeign.listById(id).getBody();
        eventoDtoResponse.setEscuelaProfesionalDto(configuracionFeign.listByIdEscuelaProfesional(eventoDtoResponse.getEscuelaProfesionalId()).getBody());
        List<MatriculaDto> matriculaDtos = eventoDtoResponse.getMatriculas().stream().parallel().map(matriculaDto -> {
            PersonaDto.Response personaDtoResponse = configuracionFeign.listByIdPersona(matriculaDto.getPersonaId()).getBody();
            matriculaDto.setPersonaDto(personaDtoResponse);
            return matriculaDto;
        }).collect(Collectors.toList());
        eventoDtoResponse.setMatriculas(matriculaDtos);
        return Optional.of(eventoDtoResponse);
    }

    @Override
    public void deleteById(Integer id) {
        eventoFeign.deleteById(id);
    }


    public ResponseEntity<List<EventoDto.Response>> findByEscuelaProfesionalIdAndEstadoTrue(Integer id) {
        return ResponseEntity.ok().body(eventoFeign.findByEscuelaProfesionalIdAndEstadoTrue(id).getBody());
    }


}


