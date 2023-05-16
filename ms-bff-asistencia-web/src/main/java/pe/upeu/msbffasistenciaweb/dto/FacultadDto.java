package pe.upeu.msbffasistenciaweb.dto;

import lombok.Data;

@Data
public class FacultadDto {
    private Integer id;
    private String descripcion;
    private Boolean estado;
    private FilialDto filial;
}
