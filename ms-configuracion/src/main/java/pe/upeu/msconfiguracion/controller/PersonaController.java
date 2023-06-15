package pe.upeu.msconfiguracion.controller;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    @CircuitBreaker(name = "personaCB", fallbackMethod = "fallBackGetPersona")
    @GetMapping("/{id}")
    public ResponseEntity<Persona> listById(@PathVariable(required = true) Integer id) {
        return ResponseEntity.ok().body(personaService.listById(id).get());
    }

    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable(required = true) Integer id) {
        personaService.deleteById(id);
        return "Deleted Successfully";
    }

    @GetMapping("/matricula")
    public ResponseEntity<List<Persona>> findByCicloAndGrupoAndEscuelaProfesionalIdAndEstadoTrue(@RequestParam String ciclo,
                                                                                                 @RequestParam String grupo,
                                                                                                 @RequestParam Integer escuelaProfesionalId) {
        return ResponseEntity.ok().body(personaService.findByCicloAndGrupoAndEscuelaProfesionalIdAndEstadoTrue(ciclo, grupo, escuelaProfesionalId));
    }

    @GetMapping("/codigo")
    public ResponseEntity<Persona> findByCodigoOrDni(@RequestParam String codigo, @RequestParam String dni) {
        return ResponseEntity.ok().body(personaService.findByCodigoOrDni(codigo, dni).orElse(new Persona()));
    }
    private ResponseEntity<Persona> fallBackGetPersona(@PathVariable(required = true) Integer id, RuntimeException e) {
        Persona persona = new Persona();
        persona.setId(id);
        return ResponseEntity.ok().body(persona);
    }
}
