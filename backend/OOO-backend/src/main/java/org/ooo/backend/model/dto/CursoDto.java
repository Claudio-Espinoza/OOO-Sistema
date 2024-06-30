package org.ooo.backend.model.dto;

import lombok.Builder;
import org.ooo.backend.model.Leccion;

import java.util.List;

@Builder
public record CursoDto(Integer id, String nombre, String descripcion, String lenguaje, List<Leccion> lecciones) {
}

