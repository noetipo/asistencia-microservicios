package pe.upeu.msconfiguracion.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.upeu.msconfiguracion.dto.PersonaDto;
import pe.upeu.msconfiguracion.entity.Persona;
import pe.upeu.msconfiguracion.service.PersonaService;

import java.util.List;

@RestController
@RequestMapping("/persona")

public class PersonaController {
    @Autowired
    private PersonaService personaService;

    @GetMapping()
    public ResponseEntity<List<Persona>> list() {
        return ResponseEntity.ok().body(personaService.list());
    }

    @PostMapping()
    public ResponseEntity<Persona> save(@RequestBody PersonaDto personaDto) {
        return ResponseEntity.ok(personaService.save(personaDto));
    }

    @PutMapping()
    public ResponseEntity<Persona> update(@RequestBody PersonaDto personaDto) {
        return ResponseEntity.ok(personaService.update(personaDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Persona> listById(@PathVariable(required = true) Integer id) {
        return ResponseEntity.ok().body(personaService.listById(id).get());
    }

    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable(required = true) Integer id) {
        personaService.deleteById(id);
        return "Deleted Successfully";
    }

}
