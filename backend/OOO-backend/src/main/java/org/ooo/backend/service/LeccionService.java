package org.ooo.backend.service;

import lombok.RequiredArgsConstructor;
import org.ooo.backend.model.Leccion;
import org.ooo.backend.repository.LeccionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class LeccionService {

    private final LeccionRepository leccionRepository;

    public List<Leccion> getAllLeccionByCurso(int idCurso){

        List<Leccion> lecciones = leccionRepository.findAllByCursoId(idCurso);

        if(!lecciones.isEmpty()){
            return lecciones;
        } else {
            throw new NoSuchElementException("No se encontraron cursos");
        }
    }

}
