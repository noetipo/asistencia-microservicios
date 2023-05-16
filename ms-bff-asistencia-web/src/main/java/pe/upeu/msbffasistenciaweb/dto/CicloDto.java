package pe.upeu.msbffasistenciaweb.dto;
import jakarta.persistence.*;
import lombok.Data;
@Entity
@Data
public class CicloDto {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
}
