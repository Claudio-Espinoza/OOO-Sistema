package org.ooo.backend.service.mapper;

import org.ooo.backend.model.Leccion;
import org.ooo.backend.model.ContenidoLeccion;
import org.ooo.backend.model.dto.LeccionDto;

public class LeccionMapper {

    public static Leccion toLeccion(LeccionDto leccionDTO) {
        Leccion leccion = new Leccion();
        leccion.setNombre(leccionDTO.getNombre());
        leccion.setAutor(leccionDTO.getAutor());
        leccion.setPuntuacionPositiva(leccionDTO.getPuntuacionPositiva());
        leccion.setPuntuacionNegativa(leccionDTO.getPuntuacionNegativa());

        // Crear y setear ContenidoLeccion
        ContenidoLeccion contenidoLeccion = new ContenidoLeccion();
        contenidoLeccion.setContenido(leccionDTO.getContenido());
        leccion.setContenidoLeccion(contenidoLeccion);

        return leccion;
    }

    public static LeccionDto fromLeccion(Leccion leccion) {
        LeccionDto leccionDTO = new LeccionDto();
        leccionDTO.setNombre(leccion.getNombre());
        leccionDTO.setAutor(leccion.getAutor());
        leccionDTO.setPuntuacionPositiva(leccion.getPuntuacionPositiva());
        leccionDTO.setPuntuacionNegativa(leccion.getPuntuacionNegativa());
        leccionDTO.setIdCurso(leccion.getCurso().getId());
        leccionDTO.setContenido(leccion.getContenidoLeccion().getContenido());

        return leccionDTO;
    }
}
