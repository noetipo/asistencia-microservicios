package pe.upeu.msbffasistenciaweb.dto;

import lombok.Data;

import java.util.List;

@Data
public class EventoDto {
    private Integer id;
    private String nombre;
    private String descripcion;
    private Boolean estado;
    private Integer tolerancia;
    private Integer escuelaProfesionalId;
    private Integer periodoId;
    private List<EventoDetalleDto> eventoDetalles;
    private List<MatriculaDto> matriculas;
}
