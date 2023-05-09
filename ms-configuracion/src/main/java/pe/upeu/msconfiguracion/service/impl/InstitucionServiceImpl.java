package pe.upeu.msconfiguracion.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.upeu.msconfiguracion.entity.Institucion;
import pe.upeu.msconfiguracion.repository.InstitucionRepository;
import pe.upeu.msconfiguracion.service.InstitucionService;

import java.util.List;
import java.util.Optional;

@Service
public class InstitucionServiceImpl implements InstitucionService {
    @Autowired
    private InstitucionRepository institucionRepository;

    @Override
    public List<Institucion> list() {
        return institucionRepository.findAll();
    }

    @Override
    public Institucion save(Institucion institucion) {
        return institucionRepository.save(institucion);
    }

    @Override
    public Institucion update(Institucion institucion) {
        return institucionRepository.save(institucion);
    }

    @Override
    public Optional<Institucion> listById(Integer id) {
        return institucionRepository.findById(id);
    }

    @Override
    public void deleteById(Integer id) {
        institucionRepository.deleteById(id);
    }
}
