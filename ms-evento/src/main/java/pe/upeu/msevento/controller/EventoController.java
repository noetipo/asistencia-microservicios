package pe.upeu.msevento.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.upeu.msevento.entity.Evento;
import pe.upeu.msevento.service.EventoService;

import java.util.List;

@RestController
@RequestMapping("/evento")

public class EventoController {
    @Autowired
    private EventoService eventoService;

    @GetMapping()
    public ResponseEntity<List<Evento>> list() {
        return ResponseEntity.ok().body(eventoService.list());
    }

    @PostMapping()
    public ResponseEntity<Evento> save(@RequestBody Evento evento) {
        return ResponseEntity.ok(eventoService.save(evento));
    }

    @PutMapping()
    public ResponseEntity<Evento> update(@RequestBody Evento evento) {
        return ResponseEntity.ok(eventoService.update(evento));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Evento> listById(@PathVariable(required = true) Integer id) {
        return ResponseEntity.ok().body(eventoService.listById(id).get());
    }

    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable(required = true) Integer id) {
        eventoService.deleteById(id);
        return "Deleted Successfully";
    }
    @GetMapping("/escuela-profesional/{id}")
    public ResponseEntity<List<Evento>> findByEscuelaProfesionalIdAndEstadoTrue(@PathVariable(required = true) Integer id) {
        return ResponseEntity.ok().body(eventoService.findByEscuelaProfesionalIdAndEstadoTrue(id));
    }
}
