package org.ooo.backend.controller;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.ooo.backend.model.Desafio;
import org.ooo.backend.model.dto.DesafioDto;
import org.ooo.backend.service.DesafioService;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/desafio")
public class DesafioController {

    private final DesafioService desafioService;

    @GetMapping("/todos")
    public ResponseEntity<List<Desafio>> obtenerTodosLosDesafios(){
        try {
            return ResponseEntity.ok(desafioService.obtenerTodosLosDesafios());
        } catch (NoSuchElementException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(), e);
        }
    }

    @GetMapping("/curso/{idCurso}")
    public ResponseEntity<List<Desafio>> obtenerDesafiosPorCurso(@PathVariable int idCurso) {
        try {
            return ResponseEntity.ok(desafioService.obtenerTodosLosDesafioPorCurso(idCurso));
        } catch (NoSuchElementException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(), e);
        }
    }

    @PostMapping(value = "/agregar-desafio", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<String> agregarDesafio(@RequestPart("file") MultipartFile file, @RequestPart("desafioDto") DesafioDto desafioDto) {
        try {
            desafioService.agregarDesafio(desafioDto, file);
            return ResponseEntity.ok("Desafio agregado correctamente con PDF.");
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error al agregar el desafio", e);
        }
    }

    @PatchMapping("/{idDesafio}/puntuacion")
    public ResponseEntity<String> actualizarPuntuacion(@PathVariable int idDesafio, @RequestParam boolean positiva) {
        try {
            desafioService.agregaPuntuacionDesafio(idDesafio, positiva);
            return ResponseEntity.ok("Puntuación actualizada correctamente.");
        } catch (NoSuchElementException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Desafio no encontrado", e);
        }
    }

    @GetMapping("/descargar-pdf/{idDesafio}")
    public ResponseEntity<Resource> descargarPDF(@PathVariable int idDesafio) {
        try {
            Resource fileResource = desafioService.cargarPdfComoRecurso(idDesafio);
            return ResponseEntity.ok()
                    .contentType(MediaType.APPLICATION_PDF)
                    .body(fileResource);
        } catch (RuntimeException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(), e);
        }
    }

    @DeleteMapping("/{idDesafio}")
    public ResponseEntity<Void> eliminarDesafio(@PathVariable int idDesafio) {
        try {
            desafioService.eliminarDesafio(idDesafio);
            return ResponseEntity.noContent().build();
        } catch (NoSuchElementException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(), e);
        }
    }

}
