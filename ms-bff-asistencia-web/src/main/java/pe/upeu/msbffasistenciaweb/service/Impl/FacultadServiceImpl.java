package pe.upeu.msbffasistenciaweb.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.upeu.msbffasistenciaweb.dto.FacultadDto;
import pe.upeu.msbffasistenciaweb.feign.ConfiguracionFeign;
import pe.upeu.msbffasistenciaweb.service.FacultadService;

import java.util.List;
import java.util.Optional;

@Service
public class FacultadServiceImpl implements FacultadService {
    @Autowired
    private ConfiguracionFeign configuracionFeign;

    @Override
    public List<FacultadDto> list() {
        return configuracionFeign.listFacultad().getBody();
    }

    @Override
    public FacultadDto save(FacultadDto facultadDto) {
        return configuracionFeign.saveFacultad(facultadDto).getBody();
    }

    @Override
    public FacultadDto update(FacultadDto facultadDto) {
        return configuracionFeign.updateFacultad(facultadDto).getBody();
    }

    @Override
    public Optional<FacultadDto> listById(Integer id) {
        return Optional.of(configuracionFeign.listByIdFacultad(id).getBody());
    }

    @Override
    public void deleteById(Integer id) {
        configuracionFeign.deleteByIdFacultad(id);
    }

    @Override
    public List<FacultadDto> findByFilialId(Integer id) {
        return configuracionFeign.findByFilialIdFacultad(id).getBody();
    }
}
