package org.ooo.backend.configuration.security.basic;

import org.ooo.backend.model.Usuario;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class UserSecurity implements UserDetails {

    private final Usuario usuario;

    public UserSecurity(Usuario usuario) {
        this.usuario = usuario;
    }

    private static final Logger logger = LoggerFactory.getLogger(UserSecurity.class);


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(usuario.getTipoUsuario().toString()));

        return authorities;
    }

    @Override
    public String getPassword() {
        if (usuario != null) {
            return usuario.getPassword();
        } else {
            logger.error("Usuario es null");
            return null;
        }
    }

    @Override
    public String getUsername() {
        try {
            return usuario.getNombre();
        } catch (NullPointerException e) {
            logger.error("Error al obtener la nombre del usuario: ", e);
            logger.info(e.getMessage());
            return null;
        }

    }

    //Modificalo a tu conveniencia
    @Override
    public boolean isAccountNonExpired() {
        return UserDetails.super.isAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return UserDetails.super.isAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return UserDetails.super.isCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled() {
        return UserDetails.super.isEnabled();
    }
}
