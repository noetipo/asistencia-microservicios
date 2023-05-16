package pe.upeu.msbffasistenciaweb.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.upeu.msbffasistenciaweb.dto.*;

import java.util.List;

@FeignClient(name = "ms-configuracion-service")
public interface ConfiguracionFeign {
    @GetMapping("/institucion")
    public ResponseEntity<List<InstitucionDto>> listInstitucion();

    @PostMapping("/institucion")
    public ResponseEntity<InstitucionDto> saveInstitucion(@RequestBody InstitucionDto institucionDto);

    @PutMapping("/institucion")
    public ResponseEntity<InstitucionDto> updateInstitucion(@RequestBody InstitucionDto institucionDto);

    @GetMapping("/institucion/{id}")
    public ResponseEntity<InstitucionDto> listByIdInstitucion(@PathVariable(required = true) Integer id);

    @DeleteMapping("/institucion/{id}")
    public String deleteByIdInstitucion(@PathVariable(required = true) Integer id);

    @GetMapping("/filial")
    public ResponseEntity<List<FilialDto>> listFilial();

    @PostMapping("/filial")
    public ResponseEntity<FilialDto> saveFilial(@RequestBody FilialDto filialDto);

    @PutMapping("/filial")
    public ResponseEntity<FilialDto> updateFilial(@RequestBody FilialDto filialDto);

    @GetMapping("/filial/{id}")
    public ResponseEntity<FilialDto> listByIdFilial(@PathVariable(required = true) Integer id);

    @DeleteMapping("/filial/{id}")
    public String deleteByIdFilial(@PathVariable(required = true) Integer id);

    @GetMapping("/filial/institucion/{id}")
    public ResponseEntity<List<FilialDto>> findByInstitucionIdFilial(@PathVariable(required = true) Integer id);

    @GetMapping("/facultad")
    public ResponseEntity<List<FacultadDto>> listFacultad();

    @PostMapping("/facultad")
    public ResponseEntity<FacultadDto> saveFacultad(@RequestBody FacultadDto facultadDto);

    @PutMapping("/facultad")
    public ResponseEntity<FacultadDto> updateFacultad(@RequestBody FacultadDto facultadDto);

    @GetMapping("/facultad/{id}")
    public ResponseEntity<FacultadDto> listByIdFacultad(@PathVariable(required = true) Integer id);

    @DeleteMapping("/facultad/{id}")
    public String deleteByIdFacultad(@PathVariable(required = true) Integer id);

    @GetMapping("/facultad/filial/{id}")
    public ResponseEntity<List<FacultadDto>> findByFilialIdFacultad(@PathVariable(required = true) Integer id);


    @GetMapping("/escuela-profesional")
    public ResponseEntity<List<EscuelaProfesionalDto>> listEscuelaProfesional();

    @PostMapping("/escuela-profesional")
    public ResponseEntity<EscuelaProfesionalDto> saveEscuelaProfesional(@RequestBody EscuelaProfesionalDto escuelaProfesionalDto);

    @PutMapping("/escuela-profesional")
    public ResponseEntity<EscuelaProfesionalDto> updateEscuelaProfesional(@RequestBody EscuelaProfesionalDto escuelaProfesionalDto);

    @GetMapping("/escuela-profesional/{id}")
    public ResponseEntity<EscuelaProfesionalDto> listByIdEscuelaProfesional(@PathVariable(required = true) Integer id);

    @DeleteMapping("/escuela-profesional/{id}")
    public String deleteByIdEscuelaProfesional(@PathVariable(required = true) Integer id);

    @GetMapping("/escuela-profesional/facultad/{id}")
    public ResponseEntity<List<EscuelaProfesionalDto>> findByFacultadIdEscuelaProfesional(@PathVariable(required = true) Integer id);


    @GetMapping("/periodo")
    public ResponseEntity<List<PeriodoDto>> listPeriodo();

    @PostMapping("/periodo")
    public ResponseEntity<PeriodoDto> savePeriodo(@RequestBody PeriodoDto periodoDto);

    @PutMapping("/periodo")
    public ResponseEntity<PeriodoDto> updatePeriodo(@RequestBody PeriodoDto periodoDto);

    @GetMapping("/periodo/{id}")
    public ResponseEntity<PeriodoDto> listByIdPeriodo(@PathVariable(required = true) Integer id);

    @DeleteMapping("/periodo/{id}")
    public String deleteByIdPeriodo(@PathVariable(required = true) Integer id);

    @GetMapping("/persona")
    public ResponseEntity<List<PersonaDto.Response>> listPersona();

    @PostMapping("/persona")
    public ResponseEntity<PersonaDto.Response> savePersona(@RequestBody PersonaDto.Request personaDtoRequest);

    @PutMapping("/persona")
    public ResponseEntity<PersonaDto.Response> updatePersona(@RequestBody PersonaDto.Request personaDtoRequest);

    @GetMapping("/persona/{id}")
    public ResponseEntity<PersonaDto.Response> listByIdPersona(@PathVariable(required = true) Integer id);

    @DeleteMapping("/persona/{id}")
    public String deleteByIdPersona(@PathVariable(required = true) Integer id);

    @GetMapping("/persona/matricula")
    public ResponseEntity<List<PersonaDto.Response>> findByCicloAndGrupoAndEscuelaProfesionalIdAndEstadoTruePersona(@RequestParam String ciclo,
                                                                                                           @RequestParam String grupo,
                                                                                                           @RequestParam Integer escuelaProfesionalId);

    @GetMapping("/ciclo")
    public ResponseEntity<List<CicloDto>> listCiclo(@RequestParam Integer idEscuelaProfesional);

    @GetMapping("/grupo")
    public ResponseEntity<List<GrupoDto>> listGrupo(@RequestParam Integer idEscuelaProfesional, @RequestParam String ciclo);

}
