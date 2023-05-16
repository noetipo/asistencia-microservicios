package pe.upeu.msbffasistenciaweb.service;

import pe.upeu.msbffasistenciaweb.dto.GrupoDto;

import java.util.List;

public interface GrupoService {
    public List<GrupoDto> list(Integer idEscuelaProfesional, String ciclo);

}
