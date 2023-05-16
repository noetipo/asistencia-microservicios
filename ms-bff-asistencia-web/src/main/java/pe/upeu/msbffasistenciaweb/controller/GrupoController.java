package pe.upeu.msbffasistenciaweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pe.upeu.msbffasistenciaweb.dto.GrupoDto;
import pe.upeu.msbffasistenciaweb.service.GrupoService;

import java.util.List;

@RestController
@RequestMapping("/grupo")

public class GrupoController {
    @Autowired
    private GrupoService grupoService;

    @GetMapping()
    public ResponseEntity<List<GrupoDto>> list(@RequestParam Integer idEscuelaProfesional, @RequestParam String ciclo) {
        return ResponseEntity.ok().body(grupoService.list(idEscuelaProfesional, ciclo));
    }

}
