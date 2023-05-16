package pe.upeu.msconfiguracion.dto;

import lombok.Data;

@Data
public class PersonaDto {
    private Integer id;
    private String codigo;
    private String dni;
    private String nombre;

    private String apellidoPaterno;

    private String apellidoMaterno;
    private String nombres;

    private String correo;
    private String tipo;
    private String ciclo;

    private String grupo;
    private Boolean estado;
    private Integer periodoId;

    private Integer escuelaProfesionalId;
}
