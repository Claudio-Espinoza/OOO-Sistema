package org.ooo.backend.controller;


import lombok.RequiredArgsConstructor;
import org.ooo.backend.service.LeccionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/leccion")
public class LeccionController {

    private final LeccionService leccionService;

    @PostMapping("/{idLeccion}/reaccion")
    public ResponseEntity<Void> actualizarPuntuacionLeccion(@PathVariable int idLeccion, @RequestParam boolean positiva){
        try {
            leccionService.añadirPuntuacionLeccion(idLeccion,positiva);
            return ResponseEntity.ok().build();
        } catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }


}
