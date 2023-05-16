package pe.upeu.msconfiguracion.service;

import pe.upeu.msconfiguracion.dto.CicloDto;

import java.util.List;

public interface CicloService {
    public List<CicloDto> list(Integer idEscuelaProfesional);

}
