package pe.upeu.msbffasistenciaweb.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.upeu.msbffasistenciaweb.dto.CicloDto;
import pe.upeu.msbffasistenciaweb.feign.ConfiguracionFeign;
import pe.upeu.msbffasistenciaweb.service.CicloService;

import java.util.List;

@Service
public class CicloServiceImpl implements CicloService {
    @Autowired
    private ConfiguracionFeign configuracionFeign;

    @Override
    public List<CicloDto> list(Integer idEscuelaProfesional) {
        return configuracionFeign.listCiclo(idEscuelaProfesional).getBody();
    }
}
