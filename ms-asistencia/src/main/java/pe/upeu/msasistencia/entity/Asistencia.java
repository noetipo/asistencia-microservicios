package pe.upeu.msasistencia.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "asistencia")
@Data

public class Asistencia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "fecha_entrada")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaEntrada;

    @Column(name = "fecha_salida")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaSalida;

    @Column(name = "evento_detalle_id")
    private Integer eventoDetalleId;
    @Column(name = "matricula_id")
    private Integer matriculaId;

}
