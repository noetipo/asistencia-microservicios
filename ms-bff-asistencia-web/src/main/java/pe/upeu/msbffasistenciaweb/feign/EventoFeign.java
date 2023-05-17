package pe.upeu.msbffasistenciaweb.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.upeu.msbffasistenciaweb.dto.EventoDto;

import java.util.List;

@FeignClient(name = "ms-evento-service", path = "/evento")
public interface EventoFeign {

    @GetMapping()
    public ResponseEntity<List<EventoDto.Response>> list();

    @PostMapping()
    public ResponseEntity<EventoDto.Request> save(@RequestBody EventoDto.Request eventoDtoRequest);

    @PutMapping()
    public ResponseEntity<EventoDto.Request> update(@RequestBody EventoDto.Request eventoDtoRequest);

    @GetMapping("/{id}")
    public ResponseEntity<EventoDto.Response> listById(@PathVariable(required = true) Integer id);

    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable(required = true) Integer id);

    @GetMapping("/escuela-profesional/{id}")
    public ResponseEntity<List<EventoDto.Response>> findByEscuelaProfesionalIdAndEstadoTrue(@PathVariable(required = true) Integer id);
}
