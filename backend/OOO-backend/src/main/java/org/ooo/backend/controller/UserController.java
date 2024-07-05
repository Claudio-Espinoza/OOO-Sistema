package org.ooo.backend.controller;

import lombok.RequiredArgsConstructor;
import org.ooo.backend.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.NoSuchElementException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @GetMapping("obtener-rol")
    public ResponseEntity<String> obtenerRol(@RequestParam String nombreUsuario){
        try {
            return ResponseEntity.ok(userService.obtenerRolUsuario(nombreUsuario));
        } catch (NoSuchElementException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(), e);
        }

    }


}
