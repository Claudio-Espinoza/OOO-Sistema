package org.ooo.backend.controller;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.ooo.backend.model.Desafio;
import org.ooo.backend.model.dto.DesafioDto;
import org.ooo.backend.service.DesafioService;
import org.springframework.http.HttpStatus;
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

    @GetMapping()
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

    @PostMapping("agregar-desafio")
    public ResponseEntity<String> agregarDesafio(@RequestParam("file") MultipartFile file, @RequestBody DesafioDto desafioDto) {
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
}
