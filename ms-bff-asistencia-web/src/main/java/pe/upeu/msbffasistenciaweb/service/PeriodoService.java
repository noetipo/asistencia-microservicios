package pe.upeu.msbffasistenciaweb.service;

import pe.upeu.msbffasistenciaweb.dto.PeriodoDto;

import java.util.List;
import java.util.Optional;

public interface PeriodoService {
    public List<PeriodoDto> list();

    public PeriodoDto save(PeriodoDto periodoDto);

    public PeriodoDto update(PeriodoDto periodoDto);

    public Optional<PeriodoDto> listById(Integer id);

    public void deleteById(Integer id);
}
