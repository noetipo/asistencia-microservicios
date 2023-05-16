package pe.upeu.msconfiguracion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.upeu.msconfiguracion.dto.GrupoDto;

import java.util.List;

public interface GrupoRepository extends JpaRepository<GrupoDto, String> {
    @Query(value = "select grupo as id\n" +
            "from persona\n" +
            "where periodo_id = (select id from periodo where estado = 1 limit 1)\n" +
            "and escuela_profesional_id= ?1\n" +
            "and ciclo=?2\n" +
            "group by grupo\n" +
            "order by grupo", nativeQuery = true)
    public List<GrupoDto> listGroup(Integer idEscuelaProfesional, String ciclo);
}
