package pe.upeu.msconfiguracion.service;

import pe.upeu.msconfiguracion.entity.Facultad;

import java.util.List;
import java.util.Optional;

public interface FacultadService {
    public List<Facultad> list();

    public Facultad save(Facultad facultad);

    public Facultad update(Facultad facultad);

    public Optional<Facultad> listById(Integer id);

    public void deleteById(Integer id);
    public  List<Facultad> findByFilialId(Integer id);
}
