package pe.upeu.msconfiguracion.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.upeu.msconfiguracion.dto.CicloDto;
import pe.upeu.msconfiguracion.repository.CicloRepository;
import pe.upeu.msconfiguracion.service.CicloService;

import java.util.List;

@Service
public class CicloServiceImpl implements CicloService {
    @Autowired
    private CicloRepository cicloRepository;

    @Override
    public List<CicloDto> list(Integer idEscuelaProfesional) {
        return cicloRepository.listCycle(idEscuelaProfesional);
    }
}
