package pe.upeu.msbffasistenciaweb.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.upeu.msbffasistenciaweb.dto.AsistenciaDto;
import pe.upeu.msbffasistenciaweb.dto.EventoDto;
import pe.upeu.msbffasistenciaweb.dto.PersonaDto;
import pe.upeu.msbffasistenciaweb.dto.ReporteAsistenciaDto;
import pe.upeu.msbffasistenciaweb.feign.AsistenciaFeign;
import pe.upeu.msbffasistenciaweb.feign.ConfiguracionFeign;
import pe.upeu.msbffasistenciaweb.feign.EventoFeign;
import pe.upeu.msbffasistenciaweb.service.AsistenciaService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AsistenciaServiceImpl implements AsistenciaService {
    @Autowired
    private EventoFeign eventoFeign;
    @Autowired
    private ConfiguracionFeign configuracionFeign;
    @Autowired
    private AsistenciaFeign asistenciaFeign;

    @Override
    public List<AsistenciaDto> list() {
        return null;
    }

    @Override
    public AsistenciaDto save(AsistenciaDto asistenciaDto) {
        return null;
    }

    @Override
    public AsistenciaDto update(AsistenciaDto asistenciaDto) {
        return null;
    }

    @Override
    public Optional<AsistenciaDto> listById(Integer id) {
        return Optional.empty();
    }

    @Override
    public void deleteById(Integer id) {

    }

    @Override
    public Optional<AsistenciaDto> findByEventoDetalleIdAndMatriculaId(Integer eventoDetalleid, Integer matriculaId) {
        return Optional.empty();
    }

    @Override
    public List<ReporteAsistenciaDto> reporteAsistencia(Integer eventoId, Integer actividadId) {
        List<ReporteAsistenciaDto> reporteAsistenciaDtos = new ArrayList<>();
        EventoDto.Response eventoDtoResponse = eventoFeign.listById(eventoId).getBody();
        eventoDtoResponse.setEscuelaProfesionalDto(configuracionFeign.listByIdEscuelaProfesional(eventoDtoResponse.getEscuelaProfesionalId()).getBody());
        eventoDtoResponse.getMatriculas().stream().parallel().map(matriculaDto -> {
            PersonaDto.Response personaDtoResponse = configuracionFeign.listByIdPersona(matriculaDto.getPersonaId()).getBody();
            AsistenciaDto asistenciaDto = asistenciaFeign.findByEventoDetalleIdAndMatriculaId(actividadId, matriculaDto.getId()).getBody();
            reporteAsistenciaDtos.add(ReporteAsistenciaDto.builder()
                    .codigo(personaDtoResponse.getCodigo())
                    .nombre(personaDtoResponse.getNombre())
                    .nombres(personaDtoResponse.getNombres())
                    .ciclo(personaDtoResponse.getCiclo())
                    .grupo(personaDtoResponse.getGrupo())
                    .fechaEntrada(asistenciaDto.getFechaEntrada())
                    .fechaSalida(asistenciaDto.getFechaSalida())
                    .build());
            return matriculaDto;
        });
        return reporteAsistenciaDtos;
    }
}
