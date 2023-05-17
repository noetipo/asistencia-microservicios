package pe.upeu.msevento.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pe.upeu.msevento.entity.Matricula;
import pe.upeu.msevento.service.MatriculaService;

import java.util.List;

@RestController
@RequestMapping("/matricula")

public class MatriculaController {
    @Autowired
    private MatriculaService matriculaService;

    @GetMapping()
    public ResponseEntity<List<Matricula>> listByPersonId(@RequestParam Integer id) {
        return ResponseEntity.ok().body(matriculaService.findByPersonaId(id));
    }


}
