package pe.upeu.msconfiguracion.dto;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class GrupoDto {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
}
