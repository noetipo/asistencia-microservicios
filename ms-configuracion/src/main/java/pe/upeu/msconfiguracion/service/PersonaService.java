package pe.upeu.msconfiguracion.service;

import pe.upeu.msconfiguracion.entity.Persona;

import java.util.List;
import java.util.Optional;

public interface PersonaService {
    public List<Persona> list();

    public Persona save(Persona persona);

    public Persona update(Persona persona);

    public Optional<Persona> listById(Integer id);

    public void deleteById(Integer id);
}
