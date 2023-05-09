package pe.upeu.msconfiguracion.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.upeu.msconfiguracion.entity.EscuelaProfesional;
import pe.upeu.msconfiguracion.repository.EscuelaProfesionalRepository;
import pe.upeu.msconfiguracion.service.EscuelaProfesionalService;

import java.util.List;
import java.util.Optional;

@Service
public class EscuelaProfesionalServiceImpl implements EscuelaProfesionalService {
    @Autowired
    private EscuelaProfesionalRepository escuelaProfesionalRepository;

    @Override
    public List<EscuelaProfesional> list() {
        return escuelaProfesionalRepository.findAll();
    }

    @Override
    public EscuelaProfesional save(EscuelaProfesional escuelaProfesional) {
        return escuelaProfesionalRepository.save(escuelaProfesional);
    }

    @Override
    public EscuelaProfesional update(EscuelaProfesional escuelaProfesional) {
        return escuelaProfesionalRepository.save(escuelaProfesional);
    }

    @Override
    public Optional<EscuelaProfesional> listById(Integer id) {
        return escuelaProfesionalRepository.findById(id);
    }

    @Override
    public void deleteById(Integer id) {
        escuelaProfesionalRepository.deleteById(id);

    }

    @Override
    public List<EscuelaProfesional> findByFacultadId(Integer id) {
        return escuelaProfesionalRepository.findByFacultadId(id);
    }
}
