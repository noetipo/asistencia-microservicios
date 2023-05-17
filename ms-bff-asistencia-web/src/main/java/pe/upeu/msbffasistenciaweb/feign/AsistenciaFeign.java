package pe.upeu.msbffasistenciaweb.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.upeu.msbffasistenciaweb.dto.AsistenciaDto;

import java.util.List;

@FeignClient(name = "ms-asistencia-service", path = "/asistencia")
public interface AsistenciaFeign {
    @GetMapping()
    public ResponseEntity<List<AsistenciaDto>> list();

    @PostMapping()
    public ResponseEntity<AsistenciaDto> save(@RequestBody AsistenciaDto asistenciaDto);

    @PutMapping()
    public ResponseEntity<AsistenciaDto> update(@RequestBody AsistenciaDto asistenciaDto);

    @GetMapping("/{id}")
    public ResponseEntity<AsistenciaDto> listById(@PathVariable(required = true) Integer id);

    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable(required = true) Integer id);

    @GetMapping("/reporte")
    public ResponseEntity<AsistenciaDto> findByEventoDetalleIdAndMatriculaId(@RequestParam Integer eventoDetalleid,
                                                                             @RequestParam Integer matriculaId);
}
