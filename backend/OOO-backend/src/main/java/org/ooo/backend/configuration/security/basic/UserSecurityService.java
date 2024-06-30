package org.ooo.backend.configuration.security;

import lombok.RequiredArgsConstructor;
import org.ooo.backend.repository.UsuarioRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserSecurityService  implements UserDetailsService {

   private final UsuarioRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repository.findByNombre(username)
                .map(UserSecurity::new)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado"));
    }

}
