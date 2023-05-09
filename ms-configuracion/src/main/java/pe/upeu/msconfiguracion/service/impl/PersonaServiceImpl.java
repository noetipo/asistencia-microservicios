package pe.upeu.msconfiguracion.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.upeu.msconfiguracion.entity.Persona;
import pe.upeu.msconfiguracion.repository.PersonaRepository;
import pe.upeu.msconfiguracion.service.PersonaService;

import java.util.List;
import java.util.Optional;

@Service
public class PersonaServiceImpl implements PersonaService {
    @Autowired
    private PersonaRepository personaRepository;

    @Override
    public List<Persona> list() {
        return personaRepository.findAll();
    }

    @Override
    public Persona save(Persona persona) {
        return personaRepository.save(persona);
    }

    @Override
    public Persona update(Persona persona) {
        return personaRepository.save(persona);
    }

    @Override
    public Optional<Persona> listById(Integer id) {
        return personaRepository.findById(id);
    }

    @Override
    public void deleteById(Integer id) {
        personaRepository.deleteById(id);
    }
}
