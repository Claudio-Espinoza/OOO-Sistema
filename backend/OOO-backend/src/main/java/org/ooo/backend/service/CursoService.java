package org.ooo.backend.service;

import lombok.RequiredArgsConstructor;
import org.ooo.backend.model.Curso;
import org.ooo.backend.model.dto.CursoDto;
import org.ooo.backend.repository.CursoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;


@Service
@RequiredArgsConstructor
public class CursoService {

    private final CursoRepository repository;

    public List<CursoDto> retornarTodosLosCursos() {
        List<Curso> cursos = repository.findAll();

        if (!cursos.isEmpty()) {
            return cursos.stream()
                    .map(this::convertToDto)
                    .toList();
        } else {
            throw new NoSuchElementException("No se encontraron cursos");
        }
    }

    private CursoDto convertToDto(Curso curso) {
        return new CursoDto(
                curso.getId(),
                curso.getNombre(),
                curso.getDescripcion(),
                curso.getLenguaje().name(),
                curso.getLecciones()
        );
    }

}
