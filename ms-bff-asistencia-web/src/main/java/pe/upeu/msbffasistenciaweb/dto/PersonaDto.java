package pe.upeu.msbffasistenciaweb.dto;


import lombok.Data;

public class PersonaDto {
    @Data
    public static class Response {
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
        private PeriodoDto periodoDto;
        private EscuelaProfesionalDto escuelaProfesional;
    }


    @Data
    public static class Request {
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


}
