package pe.upeu.msasistencia.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.upeu.msasistencia.entity.Asistencia;
import pe.upeu.msasistencia.repository.AsistenciaRepository;
import pe.upeu.msasistencia.service.AsistenciaService;

import java.util.List;
import java.util.Optional;

@Service
public class AsistenciaServiceImpl implements AsistenciaService {
    @Autowired
    private AsistenciaRepository asistenciaRepository;

    @Override
    public List<Asistencia> list() {
        return asistenciaRepository.findAll();
    }

    @Override
    public Asistencia save(Asistencia asistencia) {
        return asistenciaRepository.save(asistencia);
    }

    @Override
    public Asistencia update(Asistencia asistencia) {
        return asistenciaRepository.save(asistencia);
    }

    @Override
    public Optional<Asistencia> listById(Integer id) {
        return asistenciaRepository.findById(id);
    }

    @Override
    public void deleteById(Integer id) {
        asistenciaRepository.deleteById(id);
    }

    @Override
    public Optional<Asistencia> findByEventoDetalleIdAndMatriculaId(Integer eventoDetalleid, Integer matriculaId) {
        return Optional.of(asistenciaRepository.findByEventoDetalleIdAndMatriculaId(eventoDetalleid, matriculaId).orElse(new Asistencia()));
    }


}
