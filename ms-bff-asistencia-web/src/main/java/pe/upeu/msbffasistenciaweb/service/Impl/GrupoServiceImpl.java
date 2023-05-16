package pe.upeu.msbffasistenciaweb.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.upeu.msbffasistenciaweb.dto.GrupoDto;
import pe.upeu.msbffasistenciaweb.feign.ConfiguracionFeign;
import pe.upeu.msbffasistenciaweb.service.GrupoService;

import java.util.List;

@Service
public class GrupoServiceImpl implements GrupoService {
    @Autowired
    private ConfiguracionFeign configuracionFeign;

    @Override
    public List<GrupoDto> list(Integer idEscuelaProfesional, String ciclo) {
        return configuracionFeign.listGrupo(idEscuelaProfesional, ciclo).getBody();
    }
}
