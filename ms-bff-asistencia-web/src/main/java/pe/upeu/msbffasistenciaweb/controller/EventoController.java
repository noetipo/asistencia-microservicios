package pe.upeu.msbffasistenciaweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.upeu.msbffasistenciaweb.dto.EventoDto;
import pe.upeu.msbffasistenciaweb.service.EventoService;

import java.util.List;

@RestController
@RequestMapping("/evento")

public class EventoController {
    @Autowired
    private EventoService eventoService;

    @GetMapping()
    public ResponseEntity<List<EventoDto.Response>> list() {
        return ResponseEntity.ok().body(eventoService.list());
    }

    @PostMapping()
    public ResponseEntity<EventoDto.Response> save(@RequestBody EventoDto.Request eventoDtoRequest) {
        return ResponseEntity.ok(eventoService.save(eventoDtoRequest));
    }

    @PutMapping()
    public ResponseEntity<EventoDto.Response> update(@RequestBody EventoDto.Request eventoDtoRequest) {
        return ResponseEntity.ok(eventoService.update(eventoDtoRequest));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EventoDto.Response> listById(@PathVariable(required = true) Integer id) {
        return ResponseEntity.ok().body(eventoService.listById(id).get());
    }

    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable(required = true) Integer id) {
        eventoService.deleteById(id);
        return "Deleted Successfully";
    }
    @GetMapping("/escuela-profesional/{id}")
    public ResponseEntity<List<EventoDto.Response>> findByEscuelaProfesionalIdAndEstadoTrue(@PathVariable(required = true) Integer id) {
        return ResponseEntity.ok().body(eventoService.findByEscuelaProfesionalIdAndEstadoTrue(id)).getBody();
    }
}
