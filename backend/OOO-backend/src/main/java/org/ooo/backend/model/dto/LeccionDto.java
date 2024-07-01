package org.ooo.backend.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LeccionDto {

    private String nombre;
    private String autor;
    private String contenido;
    private double puntuacionPositiva;
    private double puntuacionNegativa;
    private int idCurso;
}
