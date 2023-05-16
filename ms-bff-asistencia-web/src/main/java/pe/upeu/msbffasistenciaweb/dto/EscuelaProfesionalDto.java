package pe.upeu.msbffasistenciaweb.dto;

import lombok.Data;

@Data
public class EscuelaProfesionalDto {
    private Integer id;
    private String descripcion;
    private Boolean estado;
    private FacultadDto facultad;
}
