package pe.upeu.msbffasistenciaweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.upeu.msbffasistenciaweb.dto.EscuelaProfesionalDto;
import pe.upeu.msbffasistenciaweb.service.EscuelaProfesionalService;

import java.util.List;

@RestController
@RequestMapping("/escuela-profesional")

public class EscuelaProfesionalController {
    @Autowired
    private EscuelaProfesionalService escuelaProfesionalService;

    @GetMapping()
    public ResponseEntity<List<EscuelaProfesionalDto>> list() {
        return ResponseEntity.ok().body(escuelaProfesionalService.list());
    }

    @PostMapping()
    public ResponseEntity<EscuelaProfesionalDto> save(@RequestBody EscuelaProfesionalDto escuelaProfesionalDto) {
        return ResponseEntity.ok(escuelaProfesionalService.save(escuelaProfesionalDto));
    }

    @PutMapping()
    public ResponseEntity<EscuelaProfesionalDto> update(@RequestBody EscuelaProfesionalDto escuelaProfesionalDto) {
        return ResponseEntity.ok(escuelaProfesionalService.update(escuelaProfesionalDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EscuelaProfesionalDto> listById(@PathVariable(required = true) Integer id) {
        return ResponseEntity.ok().body(escuelaProfesionalService.listById(id).get());
    }

    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable(required = true) Integer id) {
        escuelaProfesionalService.deleteById(id);
        return "Deleted Successfully";
    }

    @GetMapping("/facultad/{id}")
    public ResponseEntity<List<EscuelaProfesionalDto>> findByFacultadId(@PathVariable(required = true) Integer id) {
        return ResponseEntity.ok().body(escuelaProfesionalService.findByFacultadId(id));
    }

}
