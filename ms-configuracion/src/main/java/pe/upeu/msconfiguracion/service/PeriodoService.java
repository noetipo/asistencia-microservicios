package pe.upeu.msconfiguracion.service;

import pe.upeu.msconfiguracion.entity.Periodo;

import java.util.List;
import java.util.Optional;

public interface PeriodoService {
    public List<Periodo> list();

    public Periodo save(Periodo periodo);

    public Periodo update(Periodo periodo);

    public Optional<Periodo> listById(Integer id);

    public void deleteById(Integer id);

    public Optional<Periodo> findByEstadoTrue();
}
