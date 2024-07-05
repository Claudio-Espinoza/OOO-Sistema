package org.ooo.backend.service;

import lombok.RequiredArgsConstructor;
import org.ooo.backend.model.Usuario;
import org.ooo.backend.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UsuarioRepository usuarioRepository;


    public String obtenerRolUsuario(String nombreUsuario){
        Optional<Usuario> usuario = usuarioRepository.findByNombre(nombreUsuario);

        if(usuario.isPresent()){
            return usuario.get().getTipoUsuario().toString();
        } else {
            throw new NoSuchElementException(" Usuario no encontrado con Nombre: " + nombreUsuario);
        }
    }


}
