package pe.upeu.msbffasistenciaweb.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.upeu.msbffasistenciaweb.dto.PeriodoDto;
import pe.upeu.msbffasistenciaweb.feign.ConfiguracionFeign;
import pe.upeu.msbffasistenciaweb.service.PeriodoService;

import java.util.List;
import java.util.Optional;

@Service
public class PeriodoServiceImpl implements PeriodoService {
    @Autowired
    private ConfiguracionFeign configuracionFeign;

    @Override
    public List<PeriodoDto> list() {
        return configuracionFeign.listPeriodo().getBody();
    }

    @Override
    public PeriodoDto save(PeriodoDto periodoDto) {
        return configuracionFeign.savePeriodo(periodoDto).getBody();
    }

    @Override
    public PeriodoDto update(PeriodoDto periodoDto) {
        return configuracionFeign.updatePeriodo(periodoDto).getBody();
    }

    @Override
    public Optional<PeriodoDto> listById(Integer id) {
        return Optional.of(configuracionFeign.listByIdPeriodo(id).getBody());
    }

    @Override
    public void deleteById(Integer id) {
        configuracionFeign.deleteByIdPeriodo(id);
    }
}
