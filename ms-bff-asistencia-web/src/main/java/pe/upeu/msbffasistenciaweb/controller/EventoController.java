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
    public ResponseEntity<List<EventoDto>> list() {
        return ResponseEntity.ok().body(eventoService.list());
    }

    @PostMapping()
    public ResponseEntity<EventoDto> save(@RequestBody EventoDto eventoDto) {
        return ResponseEntity.ok(eventoService.save(eventoDto));
    }

    @PutMapping()
    public ResponseEntity<EventoDto> update(@RequestBody EventoDto eventoDto) {
        return ResponseEntity.ok(eventoService.update(eventoDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EventoDto> listById(@PathVariable(required = true) Integer id) {
        return ResponseEntity.ok().body(eventoService.listById(id).get());
    }

    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable(required = true) Integer id) {
        eventoService.deleteById(id);
        return "Deleted Successfully";
    }

}
