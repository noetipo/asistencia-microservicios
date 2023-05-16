package pe.upeu.msbffasistenciaweb.service;


import pe.upeu.msbffasistenciaweb.dto.FilialDto;

import java.util.List;
import java.util.Optional;

public interface FilialService {
    public List<FilialDto> list();

    public FilialDto save(FilialDto filialDto);

    public FilialDto update(FilialDto filialDto);

    public Optional<FilialDto> listById(Integer id);

    public void deleteById(Integer id);

    public List<FilialDto> findByInstitucionId(Integer id);
}
