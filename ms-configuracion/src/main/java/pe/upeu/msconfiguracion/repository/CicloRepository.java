package pe.upeu.msconfiguracion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.upeu.msconfiguracion.dto.CicloDto;

import java.util.List;

public interface CicloRepository extends JpaRepository<CicloDto, String> {
    @Query(value = "select ciclo as id\n" +
            "from persona\n" +
            "where periodo_id = (select id from periodo where estado = 1 limit 1)\n" +
            " and escuela_profesional_id= ?1\n" +
            "group by ciclo\n" +
            "order by ciclo", nativeQuery = true)
    public List<CicloDto> listCycle(Integer idEscuelaProfesional);
}
