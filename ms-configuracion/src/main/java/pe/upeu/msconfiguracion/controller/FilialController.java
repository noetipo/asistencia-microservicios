package pe.upeu.msconfiguracion.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.upeu.msconfiguracion.entity.Filial;
import pe.upeu.msconfiguracion.service.FilialService;

import java.util.List;

@RestController
@RequestMapping("/filial")

public class FilialController {
    @Autowired
    private FilialService filialService;

    @GetMapping()
    public ResponseEntity<List<Filial>> list() {
        return ResponseEntity.ok().body(filialService.list());
    }

    @PostMapping()
    public ResponseEntity<Filial> save(@RequestBody Filial filial) {
        return ResponseEntity.ok(filialService.save(filial));
    }

    @PutMapping()
    public ResponseEntity<Filial> update(@RequestBody Filial filial) {
        return ResponseEntity.ok(filialService.update(filial));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Filial> listById(@PathVariable(required = true) Integer id) {
        return ResponseEntity.ok().body(filialService.listById(id).get());
    }

    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable(required = true) Integer id) {
        filialService.deleteById(id);
        return "Deleted Successfully";
    }

    @GetMapping("/institucion/{id}")
    public ResponseEntity<List<Filial>> findByInstitucionId(@PathVariable(required = true) Integer id) {
        return ResponseEntity.ok().body(filialService.findByInstitucionId(id));
    }

}
