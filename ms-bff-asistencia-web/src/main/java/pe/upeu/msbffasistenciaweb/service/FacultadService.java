package pe.upeu.msbffasistenciaweb.service;

import pe.upeu.msbffasistenciaweb.dto.FacultadDto;

import java.util.List;
import java.util.Optional;

public interface FacultadService {
    public List<FacultadDto> list();

    public FacultadDto save(FacultadDto facultadDto);

    public FacultadDto update(FacultadDto facultadDto);

    public Optional<FacultadDto> listById(Integer id);

    public void deleteById(Integer id);

    public List<FacultadDto> findByFilialId(Integer id);
}
