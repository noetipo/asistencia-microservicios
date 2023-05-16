package pe.upeu.msconfiguracion.service;

import pe.upeu.msconfiguracion.dto.GrupoDto;

import java.util.List;

public interface GrupoService {
    public List<GrupoDto> list(Integer idEscuelaProfesional, String ciclo);

}
