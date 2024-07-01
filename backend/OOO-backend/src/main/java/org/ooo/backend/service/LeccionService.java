package org.ooo.backend.service;

import lombok.RequiredArgsConstructor;
import org.ooo.backend.model.Leccion;
import org.ooo.backend.model.dto.LeccionDto;
import org.ooo.backend.repository.CursoRepository;
import org.ooo.backend.repository.LeccionRepository;
import org.ooo.backend.service.mapper.LeccionMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LeccionService {

    private final LeccionRepository leccionRepository;
    private final CursoRepository cursoRepository;

    public List<Leccion> obtenerTodasLasLeccionesPorCurso(int idCurso) {

        List<Leccion> lecciones = leccionRepository.findAllByCursoId(idCurso);

        if (!lecciones.isEmpty()) {
            return lecciones;
        } else {
            throw new NoSuchElementException("No se encontraron lecciones");
        }
    }

    public void agregaPuntuacionLeccion(int idLeccion, boolean positiva) {
        Optional<Leccion> leccion = leccionRepository.findById(idLeccion);

        if (leccion.isPresent()) {
            Leccion leccionTemporal = leccion.get();
            if (positiva) {
                leccionTemporal.setPuntuacionPositiva(leccionTemporal.getPuntuacionPositiva() + 1);
            } else {
                leccionTemporal.setPuntuacionNegativa(leccionTemporal.getPuntuacionNegativa() + 1);
            }
            leccionRepository.save(leccionTemporal);
        } else {
            throw new NoSuchElementException("No se encontro la leccion");
        }
    }

    public void agregaLeccion(LeccionDto leccionDto) {
        Leccion leccion = LeccionMapper.toLeccion(leccionDto);

        leccion.setCurso(cursoRepository.findById(leccionDto.getIdCurso())
                .orElseThrow(() -> new NoSuchElementException("Curso no encontrado con ID: " + leccionDto.getIdCurso())));

        leccionRepository.save(leccion);
    }

}
