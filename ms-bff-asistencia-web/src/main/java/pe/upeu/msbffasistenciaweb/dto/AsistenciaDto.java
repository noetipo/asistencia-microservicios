package pe.upeu.msbffasistenciaweb.dto;

import lombok.Data;

import java.util.Date;
@Data
public class AsistenciaDto {
    private Integer id;
    private Date fechaEntrada;
    private Date fechaSalida;
    private Integer eventoDetalleId;
    private Integer matriculaId;
}
