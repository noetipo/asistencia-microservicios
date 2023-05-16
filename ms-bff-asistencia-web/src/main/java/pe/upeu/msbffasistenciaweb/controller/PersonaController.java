package pe.upeu.msbffasistenciaweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.upeu.msbffasistenciaweb.dto.PersonaDto;
import pe.upeu.msbffasistenciaweb.service.PersonaService;

import java.util.List;

@RestController
@RequestMapping("/persona")

public class PersonaController {
    @Autowired
    private PersonaService personaService;

    @GetMapping()
    public ResponseEntity<List<PersonaDto.Response>> list() {
        return ResponseEntity.ok().body(personaService.list());
    }

    @PostMapping()
    public ResponseEntity<PersonaDto.Response> save(@RequestBody PersonaDto.Request personaDtoRequest) {
        return ResponseEntity.ok(personaService.save(personaDtoRequest));
    }

    @PutMapping()
    public ResponseEntity<PersonaDto.Response> update(@RequestBody PersonaDto.Request personaDtoRequest) {
        return ResponseEntity.ok(personaService.update(personaDtoRequest));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonaDto.Response> listById(@PathVariable(required = true) Integer id) {
        return ResponseEntity.ok().body(personaService.listById(id).get());
    }

    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable(required = true) Integer id) {
        personaService.deleteById(id);
        return "Deleted Successfully";
    }

    @GetMapping("/matricula")
    public ResponseEntity<List<PersonaDto.Response>> findByCicloAndGrupoAndEscuelaProfesionalIdAndEstadoTrue(@RequestParam String ciclo,
                                                                                                    @RequestParam String grupo,
                                                                                                    @RequestParam Integer escuelaProfesionalId) {
        return ResponseEntity.ok().body(personaService.findByCicloAndGrupoAndEscuelaProfesionalIdAndEstadoTrue(ciclo, grupo, escuelaProfesionalId));
    }
}
