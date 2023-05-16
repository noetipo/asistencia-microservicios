package pe.upeu.msbffasistenciaweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pe.upeu.msbffasistenciaweb.dto.CicloDto;
import pe.upeu.msbffasistenciaweb.service.CicloService;

import java.util.List;

@RestController
@RequestMapping("/ciclo")

public class CicloController {
    @Autowired
    private CicloService cicloService;

    @GetMapping()
    public ResponseEntity<List<CicloDto>> list(@RequestParam Integer idEscuelaProfesional) {
        return ResponseEntity.ok().body(cicloService.list(idEscuelaProfesional));
    }

}
