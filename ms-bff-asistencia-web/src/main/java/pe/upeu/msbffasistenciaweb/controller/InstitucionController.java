package pe.upeu.msbffasistenciaweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.upeu.msbffasistenciaweb.dto.InstitucionDto;
import pe.upeu.msbffasistenciaweb.service.InstitucionService;

import java.util.List;

@RestController
@RequestMapping("/institucion")

public class InstitucionController {
    @Autowired
    private InstitucionService institucionService;

    @GetMapping()
    public ResponseEntity<List<InstitucionDto>> list() {
        return ResponseEntity.ok().body(institucionService.list());
    }

    @PostMapping()
    public ResponseEntity<InstitucionDto> save(@RequestBody InstitucionDto institucionDto) {
        return ResponseEntity.ok(institucionService.save(institucionDto));
    }

    @PutMapping()
    public ResponseEntity<InstitucionDto> update(@RequestBody InstitucionDto institucionDto) {
        return ResponseEntity.ok(institucionService.update(institucionDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<InstitucionDto> listById(@PathVariable(required = true) Integer id) {
        return ResponseEntity.ok().body(institucionService.listById(id).get());
    }

    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable(required = true) Integer id) {
        institucionService.deleteById(id);
        return "Deleted Successfully";
    }

}
