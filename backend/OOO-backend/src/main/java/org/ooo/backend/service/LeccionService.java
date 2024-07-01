package org.ooo.backend.service;

import lombok.RequiredArgsConstructor;
import org.ooo.backend.model.Leccion;
import org.ooo.backend.repository.LeccionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LeccionService {

    private final LeccionRepository leccionRepository;

    public List<Leccion> obtenerTodasLasLeccionesByCurso(int idCurso){

        List<Leccion> lecciones = leccionRepository.findAllByCursoId(idCurso);

        if(!lecciones.isEmpty()){
            return lecciones;
        } else {
            throw new NoSuchElementException("No se encontraron lecciones");
        }
    }


    public void añadirPuntuacionLeccion(int idLeccion, boolean positiva){

        Optional<Leccion> leccion = leccionRepository.findById(idLeccion);

        if(leccion.isPresent() ){

            Leccion leccionTemporal = leccion.get();

            if (positiva){
                leccionTemporal.setPuntuacionPositiva(leccionTemporal.getPuntuacionPositiva() + 1);
            }else {
                leccionTemporal.setPuntuacionNegativa(leccionTemporal.getPuntuacionNegativa() + 1);
            }

            leccionRepository.save(leccionTemporal);
        } else {
            throw new NoSuchElementException("No se encontro la leccion");
        }


    }

}
