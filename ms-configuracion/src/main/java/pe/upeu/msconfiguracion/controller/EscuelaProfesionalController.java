package pe.upeu.msconfiguracion.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.upeu.msconfiguracion.entity.EscuelaProfesional;
import pe.upeu.msconfiguracion.service.EscuelaProfesionalService;

import java.util.List;

@RestController
@RequestMapping("/escuela-profesional")

public class EscuelaProfesionalController {
    @Autowired
    private EscuelaProfesionalService escuelaProfesionalService;

    @GetMapping()
    public ResponseEntity<List<EscuelaProfesional>> list() {
        return ResponseEntity.ok().body(escuelaProfesionalService.list());
    }

    @PostMapping()
    public ResponseEntity<EscuelaProfesional> save(@RequestBody EscuelaProfesional escuelaProfesional) {
        return ResponseEntity.ok(escuelaProfesionalService.save(escuelaProfesional));
    }

    @PutMapping()
    public ResponseEntity<EscuelaProfesional> update(@RequestBody EscuelaProfesional escuelaProfesional) {
        return ResponseEntity.ok(escuelaProfesionalService.update(escuelaProfesional));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EscuelaProfesional> listById(@PathVariable(required = true) Integer id) {
        return ResponseEntity.ok().body(escuelaProfesionalService.listById(id).get());
    }

    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable(required = true) Integer id) {
        escuelaProfesionalService.deleteById(id);
        return "Deleted Successfully";
    }

    @GetMapping("/facultad/{id}")
    public ResponseEntity<List<EscuelaProfesional>> findByFacultadId(@PathVariable(required = true) Integer id) {
        return ResponseEntity.ok().body(escuelaProfesionalService.findByFacultadId(id));
    }

}
