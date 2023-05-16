package pe.upeu.msbffasistenciaweb.dto;

import lombok.Data;

import java.util.Date;

@Data
public class EventoDetalleDto {
    private Integer id;
    private String nombre;
    private Date fecha;
}
