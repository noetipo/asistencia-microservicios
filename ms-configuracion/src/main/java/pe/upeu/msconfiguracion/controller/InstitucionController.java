package pe.upeu.msconfiguracion.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.upeu.msconfiguracion.entity.Institucion;
import pe.upeu.msconfiguracion.service.InstitucionService;

import java.util.List;

@RestController
@RequestMapping("/institucion")

public class InstitucionController {
    @Autowired
    private InstitucionService institucionService;

    @GetMapping()
    public ResponseEntity<List<Institucion>> list() {
        return ResponseEntity.ok().body(institucionService.list());
    }

    @PostMapping()
    public ResponseEntity<Institucion> save(@RequestBody Institucion institucion) {
        return ResponseEntity.ok(institucionService.save(institucion));
    }

    @PutMapping()
    public ResponseEntity<Institucion> update(@RequestBody Institucion institucion) {
        return ResponseEntity.ok(institucionService.update(institucion));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Institucion> listById(@PathVariable(required = true) Integer id) {
        return ResponseEntity.ok().body(institucionService.listById(id).get());
    }

    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable(required = true) Integer id) {
        institucionService.deleteById(id);
        return "Deleted Successfully";
    }

}
