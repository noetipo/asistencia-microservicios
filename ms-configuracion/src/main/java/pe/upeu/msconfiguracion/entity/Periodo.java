package pe.upeu.msconfiguracion.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "periodo")
@Data
@NoArgsConstructor
public class Periodo {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String descripcion;
    private Boolean estado;

}
