package pe.upeu.msconfiguracion.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "escuela_profesional")
@Data
@NoArgsConstructor
public class EscuelaProfesional {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String descripcion;
    private Boolean estado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "facultad_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Facultad facultad;
}
