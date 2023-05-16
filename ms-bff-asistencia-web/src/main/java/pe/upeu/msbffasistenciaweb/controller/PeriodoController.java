package pe.upeu.msbffasistenciaweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.upeu.msbffasistenciaweb.dto.PeriodoDto;
import pe.upeu.msbffasistenciaweb.service.PeriodoService;

import java.util.List;

@RestController
@RequestMapping("/periodo")

public class PeriodoController {
    @Autowired
    private PeriodoService periodoService;

    @GetMapping()
    public ResponseEntity<List<PeriodoDto>> list() {
        return ResponseEntity.ok().body(periodoService.list());
    }

    @PostMapping()
    public ResponseEntity<PeriodoDto> save(@RequestBody PeriodoDto periodoDto) {
        return ResponseEntity.ok(periodoService.save(periodoDto));
    }

    @PutMapping()
    public ResponseEntity<PeriodoDto> update(@RequestBody PeriodoDto periodoDto) {
        return ResponseEntity.ok(periodoService.update(periodoDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PeriodoDto> listById(@PathVariable(required = true) Integer id) {
        return ResponseEntity.ok().body(periodoService.listById(id).get());
    }

    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable(required = true) Integer id) {
        periodoService.deleteById(id);
        return "Deleted Successfully";
    }

}
