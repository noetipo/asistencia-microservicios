package pe.upeu.msconfiguracion.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.upeu.msconfiguracion.dto.GrupoDto;
import pe.upeu.msconfiguracion.repository.GrupoRepository;
import pe.upeu.msconfiguracion.service.GrupoService;

import java.util.List;

@Service
public class GrupoServiceImpl implements GrupoService {
    @Autowired
    private GrupoRepository grupoRepository;

    @Override
    public List<GrupoDto> list(Integer idEscuelaProfesional, String ciclo) {
        return grupoRepository.listGroup(idEscuelaProfesional, ciclo);
    }
}
