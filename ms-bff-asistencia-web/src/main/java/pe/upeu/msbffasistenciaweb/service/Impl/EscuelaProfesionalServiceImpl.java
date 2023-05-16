package pe.upeu.msbffasistenciaweb.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.upeu.msbffasistenciaweb.dto.EscuelaProfesionalDto;
import pe.upeu.msbffasistenciaweb.feign.ConfiguracionFeign;
import pe.upeu.msbffasistenciaweb.service.EscuelaProfesionalService;

import java.util.List;
import java.util.Optional;

@Service
public class EscuelaProfesionalServiceImpl implements EscuelaProfesionalService {
    @Autowired
    private ConfiguracionFeign configuracionFeign;

    @Override
    public List<EscuelaProfesionalDto> list() {
        return configuracionFeign.listEscuelaProfesional().getBody();
    }

    @Override
    public EscuelaProfesionalDto save(EscuelaProfesionalDto escuelaProfesionalDto) {
        return configuracionFeign.saveEscuelaProfesional(escuelaProfesionalDto).getBody();
    }

    @Override
    public EscuelaProfesionalDto update(EscuelaProfesionalDto escuelaProfesionalDto) {
        return configuracionFeign.updateEscuelaProfesional(escuelaProfesionalDto).getBody();
    }

    @Override
    public Optional<EscuelaProfesionalDto> listById(Integer id) {
        return Optional.of(configuracionFeign.listByIdEscuelaProfesional(id).getBody());
    }

    @Override
    public void deleteById(Integer id) {
        configuracionFeign.deleteByIdEscuelaProfesional(id);
    }

    @Override
    public List<EscuelaProfesionalDto> findByFacultadId(Integer id) {
        return configuracionFeign.findByFacultadIdEscuelaProfesional(id).getBody();
    }
}
