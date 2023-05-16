package pe.upeu.msbffasistenciaweb.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.upeu.msbffasistenciaweb.dto.FilialDto;
import pe.upeu.msbffasistenciaweb.feign.ConfiguracionFeign;
import pe.upeu.msbffasistenciaweb.service.FilialService;

import java.util.List;
import java.util.Optional;

@Service
public class FilialServiceImpl implements FilialService {
    @Autowired
    private ConfiguracionFeign configuracionFeign;


    @Override
    public List<FilialDto> list() {
        return configuracionFeign.listFilial().getBody();
    }

    @Override
    public FilialDto save(FilialDto filialDto) {
        return configuracionFeign.saveFilial(filialDto).getBody();
    }

    @Override
    public FilialDto update(FilialDto filialDto) {
        return configuracionFeign.updateFilial(filialDto).getBody();
    }

    @Override
    public Optional<FilialDto> listById(Integer id) {
        return Optional.of(configuracionFeign.listByIdFilial(id).getBody());
    }

    @Override
    public void deleteById(Integer id) {
        configuracionFeign.deleteByIdFilial(id);
    }

    @Override
    public List<FilialDto> findByInstitucionId(Integer id) {
        return configuracionFeign.findByInstitucionIdFilial(id).getBody();
    }
}
