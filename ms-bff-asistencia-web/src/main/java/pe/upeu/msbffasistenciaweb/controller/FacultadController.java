package pe.upeu.msbffasistenciaweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.upeu.msbffasistenciaweb.dto.FacultadDto;
import pe.upeu.msbffasistenciaweb.service.FacultadService;

import java.util.List;

@RestController
@RequestMapping("/facultad")

public class FacultadController {
    @Autowired
    private FacultadService facultadService;

    @GetMapping()
    public ResponseEntity<List<FacultadDto>> list() {
        return ResponseEntity.ok().body(facultadService.list());
    }

    @PostMapping()
    public ResponseEntity<FacultadDto> save(@RequestBody FacultadDto facultadDto) {
        return ResponseEntity.ok(facultadService.save(facultadDto));
    }

    @PutMapping()
    public ResponseEntity<FacultadDto> update(@RequestBody FacultadDto facultadDto) {
        return ResponseEntity.ok(facultadService.update(facultadDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<FacultadDto> listById(@PathVariable(required = true) Integer id) {
        return ResponseEntity.ok().body(facultadService.listById(id).get());
    }

    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable(required = true) Integer id) {
        facultadService.deleteById(id);
        return "Deleted Successfully";
    }

    @GetMapping("/filial/{id}")
    public ResponseEntity<List<FacultadDto>> findByFilialId(@PathVariable(required = true) Integer id) {
        return ResponseEntity.ok().body(facultadService.findByFilialId(id));
    }

}
