package pe.upeu.msbffasistenciaweb.service;

import pe.upeu.msbffasistenciaweb.dto.InstitucionDto;

import java.util.List;
import java.util.Optional;

public interface InstitucionService {
    public List<InstitucionDto> list();

    public InstitucionDto save(InstitucionDto institucionDto);

    public InstitucionDto update(InstitucionDto institucionDto);

    public Optional<InstitucionDto> listById(Integer id);

    public void deleteById(Integer id);
}
