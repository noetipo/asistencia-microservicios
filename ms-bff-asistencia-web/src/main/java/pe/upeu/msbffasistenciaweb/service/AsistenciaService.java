package pe.upeu.msbffasistenciaweb.service;

import pe.upeu.msbffasistenciaweb.dto.AsistenciaDto;
import pe.upeu.msbffasistenciaweb.dto.ReporteAsistenciaDto;

import java.util.List;
import java.util.Optional;

public interface AsistenciaService {
    public List<AsistenciaDto> list();

    public AsistenciaDto save(Integer eventoDetalleId, Integer eventoId, String dni);

    public AsistenciaDto update(AsistenciaDto asistenciaDto);

    public Optional<AsistenciaDto> listById(Integer id);

    public void deleteById(Integer id);

    public Optional<AsistenciaDto> findByEventoDetalleIdAndMatriculaId(Integer eventoDetalleid, Integer actividadId);

    public List<ReporteAsistenciaDto> reporteAsistencia(Integer eventoId, Integer actividadId);
}

