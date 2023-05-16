package pe.upeu.msbffasistenciaweb.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.upeu.msbffasistenciaweb.dto.EventoDto;

import java.util.List;

@FeignClient(name = "ms-evento-service", path = "/evento")
public interface EventoFeign {

    @GetMapping()
    public ResponseEntity<List<EventoDto>> list();

    @PostMapping()
    public ResponseEntity<EventoDto> save(@RequestBody EventoDto eventoDto);

    @PutMapping()
    public ResponseEntity<EventoDto> update(@RequestBody EventoDto eventoDto);

    @GetMapping("/{id}")
    public ResponseEntity<EventoDto> listById(@PathVariable(required = true) Integer id);

    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable(required = true) Integer id);
}
