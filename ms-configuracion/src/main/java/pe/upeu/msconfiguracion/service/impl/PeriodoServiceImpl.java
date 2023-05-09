package pe.upeu.msconfiguracion.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.upeu.msconfiguracion.entity.Periodo;
import pe.upeu.msconfiguracion.repository.PeriodoRepository;
import pe.upeu.msconfiguracion.service.PeriodoService;

import java.util.List;
import java.util.Optional;

@Service
public class PeriodoServiceImpl implements PeriodoService {
    @Autowired
    private PeriodoRepository periodoRepository;

    @Override
    public List<Periodo> list() {
        return periodoRepository.findAll();
    }

    @Override
    public Periodo save(Periodo periodo) {
        return periodoRepository.save(periodo);
    }

    @Override
    public Periodo update(Periodo periodo) {
        return periodoRepository.save(periodo);
    }

    @Override
    public Optional<Periodo> listById(Integer id) {
        return periodoRepository.findById(id);
    }

    @Override
    public void deleteById(Integer id) {
        periodoRepository.deleteById(id);
    }
}
