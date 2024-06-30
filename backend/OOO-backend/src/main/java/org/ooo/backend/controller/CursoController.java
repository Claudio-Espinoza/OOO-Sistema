package org.ooo.backend.controller;

import lombok.RequiredArgsConstructor;
import org.ooo.backend.model.dto.CursoDto;
import org.ooo.backend.service.CursoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/curso")
public class CursoController {

    private final CursoService service;

    @GetMapping("/temas")
    protected ResponseEntity<List<CursoDto>> retornarTodosLosCursos() {
        List<CursoDto> cursoDtos = service.retornarTodosLosCursos();

        if (!cursoDtos.isEmpty()) {
            return ResponseEntity.ok().body(cursoDtos);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
