package pe.upeu.msbffasistenciaweb.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.upeu.msbffasistenciaweb.dto.EventoDto;
import pe.upeu.msbffasistenciaweb.dto.MatriculaDto;

import java.util.List;

@FeignClient(name = "ms-evento-service")
public interface EventoFeign {

    @GetMapping("/evento")
    public ResponseEntity<List<EventoDto.Response>> list();

    @PostMapping("/evento")
    public ResponseEntity<EventoDto.Request> save(@RequestBody EventoDto.Request eventoDtoRequest);

    @PutMapping("/evento")
    public ResponseEntity<EventoDto.Request> update(@RequestBody EventoDto.Request eventoDtoRequest);

    @GetMapping("/evento/{id}")
    public ResponseEntity<EventoDto.Response> listById(@PathVariable(required = true) Integer id);

    @DeleteMapping("/evento/{id}")
    public String deleteById(@PathVariable(required = true) Integer id);

    @GetMapping("/evento/escuela-profesional/{id}")
    public ResponseEntity<List<EventoDto.Response>> findByEscuelaProfesionalIdAndEstadoTrue(@PathVariable(required = true) Integer id);


    @GetMapping("/matricula")
    public ResponseEntity<List<MatriculaDto>> listByPersonId(@RequestParam Integer id);
}
