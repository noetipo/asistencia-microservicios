package pe.upeu.msbffasistenciaweb.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.upeu.msbffasistenciaweb.dto.InstitucionDto;
import pe.upeu.msbffasistenciaweb.feign.ConfiguracionFeign;
import pe.upeu.msbffasistenciaweb.service.InstitucionService;

import java.util.List;
import java.util.Optional;

@Service
public class InstitucionServiceImpl implements InstitucionService {
    @Autowired
    private ConfiguracionFeign configuracionFeign;

    @Override
    public List<InstitucionDto> list() {
        return configuracionFeign.listInstitucion().getBody();
    }

    @Override
    public InstitucionDto save(InstitucionDto institucionDto) {
        return configuracionFeign.saveInstitucion(institucionDto).getBody();
    }

    @Override
    public InstitucionDto update(InstitucionDto institucionDto) {
        return configuracionFeign.updateInstitucion(institucionDto).getBody();
    }

    @Override
    public Optional<InstitucionDto> listById(Integer id) {
        return Optional.of(configuracionFeign.listByIdInstitucion(id).getBody());
    }

    @Override
    public void deleteById(Integer id) {
        configuracionFeign.deleteByIdInstitucion(id);
    }
}
