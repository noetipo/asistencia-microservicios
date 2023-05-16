package pe.upeu.msbffasistenciaweb.service;

import pe.upeu.msbffasistenciaweb.dto.CicloDto;

import java.util.List;

public interface CicloService {
    public List<CicloDto> list(Integer idEscuelaProfesional);

}
