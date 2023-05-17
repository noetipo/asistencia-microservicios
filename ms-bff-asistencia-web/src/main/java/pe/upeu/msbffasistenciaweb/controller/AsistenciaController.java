package pe.upeu.msbffasistenciaweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.upeu.msbffasistenciaweb.dto.AsistenciaDto;
import pe.upeu.msbffasistenciaweb.dto.ReporteAsistenciaDto;
import pe.upeu.msbffasistenciaweb.service.AsistenciaService;

import java.util.List;

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
    public ResponseEntity<AsistenciaDto> save(@RequestBody AsistenciaDto asistenciaDto) {
        return ResponseEntity.ok(asistenciaService.save(asistenciaDto));
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
    public ResponseEntity<List<ReporteAsistenciaDto>> reporteAsistencia(@RequestParam Integer eventoDetalleid,
                                                                  @RequestParam Integer actividadId) {
        return ResponseEntity.ok().body(asistenciaService.reporteAsistencia(eventoDetalleid, actividadId));
    }


}
