package pe.upeu.msbffasistenciaweb.dto;

import lombok.Data;

@Data
public class FilialDto {
    private Integer id;
    private String descripcion;
    private Boolean estado;
    private InstitucionDto institucion;
}
