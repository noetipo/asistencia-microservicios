package pe.upeu.msasistencia.controller;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.upeu.msasistencia.entity.Asistencia;
import pe.upeu.msasistencia.service.AsistenciaService;

import java.util.List;

@RestController
@RequestMapping("/asistencia")
public class AsistenciaController {
    @Autowired
    private AsistenciaService asistenciaService;

    @GetMapping()
    public ResponseEntity<List<Asistencia>> list() {
        return ResponseEntity.ok().body(asistenciaService.list());
    }
    @CircuitBreaker(name = "asistenciaGuardarCB", fallbackMethod = "fallBackPostAsistenciaGuardar")
    @PostMapping()
    public ResponseEntity<Asistencia> save(@RequestBody Asistencia asistencia) {
        return ResponseEntity.ok(asistenciaService.save(asistencia));
    }

    @PutMapping()
    public ResponseEntity<Asistencia> update(@RequestBody Asistencia asistencia) {
        return ResponseEntity.ok(asistenciaService.update(asistencia));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Asistencia> listById(@PathVariable(required = true) Integer id) {
        return ResponseEntity.ok().body(asistenciaService.listById(id).get());
    }

    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable(required = true) Integer id) {
        asistenciaService.deleteById(id);
        return "Deleted Successfully";
    }

    @GetMapping("/reporte")
    public ResponseEntity<Asistencia> findByEventoDetalleIdAndMatriculaId(@RequestParam Integer eventoDetalleid,
                                                                          @RequestParam Integer matriculaId) {
        return ResponseEntity.ok().body(asistenciaService.findByEventoDetalleIdAndMatriculaId(eventoDetalleid, matriculaId).orElse(null));
    }

    private ResponseEntity<Asistencia> fallBackPostAsistenciaGuardar(@RequestBody Asistencia asistencia, RuntimeException e) {
        Asistencia asistenciaGuardar = new Asistencia();
        asistenciaGuardar.setId(90000);
        return ResponseEntity.ok().body(asistenciaGuardar);
    }
}
