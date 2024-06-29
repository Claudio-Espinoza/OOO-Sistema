package org.ooo.backend.configuration.security.placeholder;

import org.ooo.backend.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserSecurityService  implements UserDetailsService {

    // Aqui va el repositorio para poder usar usuario

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Aqui va el servicio apra consultar si un usaurio esta en la base de de datos

        return null;
    }
}
