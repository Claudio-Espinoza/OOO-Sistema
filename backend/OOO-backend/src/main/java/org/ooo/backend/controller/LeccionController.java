package org.ooo.backend.controller;


import lombok.RequiredArgsConstructor;
import org.ooo.backend.model.Leccion;
import org.ooo.backend.model.dto.LeccionDto;
import org.ooo.backend.service.LeccionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/leccion")
public class LeccionController {

    private final LeccionService leccionService;

    @PostMapping("/agregar-leccion")
    public ResponseEntity<Void> agregaLeccion(@RequestBody LeccionDto leccionDto) {
        try {
            leccionService.agregaLeccion(leccionDto);
            return ResponseEntity.ok().build();
        } catch (NoSuchElementException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/curso/{idCurso}")
    protected ResponseEntity<List<Leccion>> obtenerLeccionesPorCurso(@PathVariable int idCurso) {
        try {
            List<Leccion> leccionList = leccionService.obtenerTodasLasLeccionesPorCurso(idCurso);
            return ResponseEntity.ok(leccionList);
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PatchMapping("/{idLeccion}/puntuacion")
    public ResponseEntity<Void> actualizarPuntuacionLeccion(@PathVariable int idLeccion, @RequestParam boolean positiva) {
        try {
            leccionService.agregaPuntuacionLeccion(idLeccion, positiva);
            return ResponseEntity.ok().build();
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }
    }

}
