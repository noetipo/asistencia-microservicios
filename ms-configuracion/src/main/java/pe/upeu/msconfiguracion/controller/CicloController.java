package pe.upeu.msconfiguracion.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.upeu.msconfiguracion.dto.CicloDto;
import pe.upeu.msconfiguracion.service.CicloService;

import java.util.List;

@RestController
@RequestMapping("/ciclo")

public class CicloController {
    @Autowired
    private CicloService cicloService;

    @GetMapping("/{idEscuelaProfesional}")

    public ResponseEntity<List<CicloDto>> list(@PathVariable(required = true) Integer idEscuelaProfesional) {
        return ResponseEntity.ok().body(cicloService.list(idEscuelaProfesional));
    }

}
