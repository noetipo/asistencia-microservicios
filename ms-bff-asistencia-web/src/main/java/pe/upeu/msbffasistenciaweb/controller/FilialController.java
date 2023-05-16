package pe.upeu.msbffasistenciaweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.upeu.msbffasistenciaweb.dto.FilialDto;
import pe.upeu.msbffasistenciaweb.service.FilialService;

import java.util.List;

@RestController
@RequestMapping("/filial")

public class FilialController {
    @Autowired
    private FilialService filialService;

    @GetMapping()
    public ResponseEntity<List<FilialDto>> list() {
        return ResponseEntity.ok().body(filialService.list());
    }

    @PostMapping()
    public ResponseEntity<FilialDto> save(@RequestBody FilialDto filialDto) {
        return ResponseEntity.ok(filialService.save(filialDto));
    }

    @PutMapping()
    public ResponseEntity<FilialDto> update(@RequestBody FilialDto filialDto) {
        return ResponseEntity.ok(filialService.update(filialDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<FilialDto> listById(@PathVariable(required = true) Integer id) {
        return ResponseEntity.ok().body(filialService.listById(id).get());
    }

    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable(required = true) Integer id) {
        filialService.deleteById(id);
        return "Deleted Successfully";
    }

    @GetMapping("/institucion/{id}")
    public ResponseEntity<List<FilialDto>> findByInstitucionId(@PathVariable(required = true) Integer id) {
        return ResponseEntity.ok().body(filialService.findByInstitucionId(id));
    }

}
