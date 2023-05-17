package pe.upeu.msbffasistenciaweb.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class ReporteAsistenciaDto {
    private String nombre;
    private String codigo;
    private String dni;
    private String nombres;
    private String ciclo;
    private String grupo;
    private String fecha;
    private Date fechaEntrada;
    private Date fechaSalida;
}
