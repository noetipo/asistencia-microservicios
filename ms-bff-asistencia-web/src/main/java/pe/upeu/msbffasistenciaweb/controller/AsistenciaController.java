package pe.upeu.msbffasistenciaweb.controller;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.upeu.msbffasistenciaweb.dto.AsistenciaDto;
import pe.upeu.msbffasistenciaweb.dto.MensajeDto;
import pe.upeu.msbffasistenciaweb.dto.ReporteAsistenciaDto;
import pe.upeu.msbffasistenciaweb.service.AsistenciaService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/asistencia")
public class AsistenciaController {
    @Autowired
    private AsistenciaService asistenciaService;

    @GetMapping()
    public ResponseEntity<List<AsistenciaDto>> list() {
        return ResponseEntity.ok().body(asistenciaService.list());
    }

    @PostMapping()
    public ResponseEntity<AsistenciaDto> save(@RequestParam Integer eventoDetalleId, @RequestParam Integer eventoId, @RequestParam String dni) {
        return ResponseEntity.ok(asistenciaService.save(eventoDetalleId, eventoId, dni));
    }

    @PutMapping()
    public ResponseEntity<AsistenciaDto> update(@RequestBody AsistenciaDto asistenciaDto) {
        return ResponseEntity.ok(asistenciaService.update(asistenciaDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<AsistenciaDto> listById(@PathVariable(required = true) Integer id) {
        return ResponseEntity.ok().body(asistenciaService.listById(id).get());
    }

    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable(required = true) Integer id) {
        asistenciaService.deleteById(id);
        return "Deleted Successfully";
    }

    @GetMapping("/reporte")
    public ResponseEntity<List<ReporteAsistenciaDto>> reporteAsistencia(@RequestParam Integer eventoId,
                                                                        @RequestParam Integer actividadId) {
        return ResponseEntity.ok().body(asistenciaService.reporteAsistencia(eventoId, actividadId));
    }
    @CircuitBreaker(name = "asistenciaGuardarBffCB", fallbackMethod = "fallBackGetAsistenciaGuardarBff")
    @GetMapping("/registro")
    public ResponseEntity<Optional<MensajeDto>> saveAttendance(@RequestParam Integer eventoDetalleId,
                                                               @RequestParam Integer eventoId,
                                                               @RequestParam String dni) {
        asistenciaService.save(eventoDetalleId, eventoId, dni);
        return ResponseEntity.ok(Optional.of(new MensajeDto("Registro correcto")));
    }
    private ResponseEntity<Optional<MensajeDto>> fallBackGetAsistenciaGuardarBff(@RequestParam Integer eventoDetalleId,
                                                                                 @RequestParam Integer eventoId,
                                                                                 @RequestParam String dni, RuntimeException e) {
        return ResponseEntity.ok(Optional.of(new MensajeDto("Registro correcto")));
    }
}
