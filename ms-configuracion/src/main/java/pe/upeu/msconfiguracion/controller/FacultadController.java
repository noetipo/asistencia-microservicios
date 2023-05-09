package pe.upeu.msconfiguracion.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.upeu.msconfiguracion.entity.Facultad;
import pe.upeu.msconfiguracion.service.FacultadService;

import java.util.List;

@RestController
@RequestMapping("/facultad")

public class FacultadController {
    @Autowired
    private FacultadService facultadService;

    @GetMapping()
    public ResponseEntity<List<Facultad>> list() {
        return ResponseEntity.ok().body(facultadService.list());
    }

    @PostMapping()
    public ResponseEntity<Facultad> save(@RequestBody Facultad facultad) {
        return ResponseEntity.ok(facultadService.save(facultad));
    }

    @PutMapping()
    public ResponseEntity<Facultad> update(@RequestBody Facultad facultad) {
        return ResponseEntity.ok(facultadService.update(facultad));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Facultad> listById(@PathVariable(required = true) Integer id) {
        return ResponseEntity.ok().body(facultadService.listById(id).get());
    }

    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable(required = true) Integer id) {
        facultadService.deleteById(id);
        return "Deleted Successfully";
    }

    @GetMapping("/filial/{id}")
    public ResponseEntity<List<Facultad>> findByFilialId(@PathVariable(required = true) Integer id) {
        return ResponseEntity.ok().body(facultadService.findByFilialId(id));
    }

}
