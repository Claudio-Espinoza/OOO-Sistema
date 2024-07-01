package org.ooo.backend.controller;


import lombok.RequiredArgsConstructor;
import org.ooo.backend.model.dto.LeccionDto;
import org.ooo.backend.service.LeccionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/leccion")
public class LeccionController {

    private final LeccionService leccionService;

    @PostMapping
    public ResponseEntity<?> añadirLeccion(@RequestBody LeccionDto leccionDto) {
        try {
            leccionService.añadirLeccion(leccionDto);
            return ResponseEntity.ok("Lección añadida exitosamente");
        } catch (NoSuchElementException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/curso/{idCurso}")
    public ResponseEntity<?> obtenerLeccionesPorCurso(@PathVariable int idCurso) {
        try {
            return ResponseEntity.ok(leccionService.obtenerTodasLasLeccionesPorCurso(idCurso));
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PatchMapping("/{idLeccion}/puntuacion")
    public ResponseEntity<?> actualizarPuntuacionLeccion(@PathVariable int idLeccion, @RequestParam boolean positiva) {
        try {
            leccionService.añadirPuntuacionLeccion(idLeccion, positiva);
            return ResponseEntity.ok("Puntuación actualizada correctamente");
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }
    }

}
