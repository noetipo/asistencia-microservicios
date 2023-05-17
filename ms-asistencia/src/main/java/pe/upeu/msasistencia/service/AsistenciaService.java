package pe.upeu.msasistencia.service;

import pe.upeu.msasistencia.entity.Asistencia;

import java.util.List;
import java.util.Optional;

public interface AsistenciaService {
    public List<Asistencia> list();

    public Asistencia save(Asistencia asistencia);

    public Asistencia update(Asistencia asistencia);

    public Optional<Asistencia> listById(Integer id);

    public void deleteById(Integer id);

    public Optional<Asistencia> findByEventoDetalleIdAndMatriculaId(Integer eventoDetalleid, Integer matriculaId);
}

