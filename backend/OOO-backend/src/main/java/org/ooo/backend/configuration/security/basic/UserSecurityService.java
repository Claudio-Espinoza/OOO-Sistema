package org.ooo.backend.configuration.security.basic;

import lombok.RequiredArgsConstructor;
import org.ooo.backend.configuration.security.controller.dto.AuthCreateUserRequest;
import org.ooo.backend.configuration.security.controller.dto.AuthLoginRequest;
import org.ooo.backend.configuration.security.controller.dto.AuthResponse;
import org.ooo.backend.configuration.security.jwt.JwtUtil;
import org.ooo.backend.model.Usuario;
import org.ooo.backend.model.utils.TipoUsuario;
import org.ooo.backend.repository.UsuarioRepository;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserSecurityService implements UserDetailsService {

    private final JwtUtil jwtUtils;
    private final UsuarioRepository repository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repository.findByNombre(username)
                .map(UserSecurity::new)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado"));
    }

    public AuthResponse createUser(AuthCreateUserRequest createRoleRequest) {

        String username = createRoleRequest.username();
        String password = createRoleRequest.password();
        String rolesRequest = createRoleRequest.roleRequest();
        String correo = createRoleRequest.email();

        Usuario userEntity = Usuario.builder().nombre(username).email(correo).password(passwordEncoder.encode(password)).tipoUsuario(TipoUsuario.valueOf(rolesRequest.toUpperCase())).build();
        Usuario userSaved = repository.save(userEntity);

        ArrayList<SimpleGrantedAuthority> authorities = new ArrayList<>();

        Authentication authentication = new UsernamePasswordAuthenticationToken(userSaved, null, authorities);

        String accessToken = jwtUtils.createToken(authentication);

        return new AuthResponse(username, "User created successfully", accessToken, true);
    }



    public AuthResponse loginUser(AuthLoginRequest authLoginRequest) {

        String username = authLoginRequest.username();
        String password = authLoginRequest.password();

        Authentication authentication = this.authenticate(username, password);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        String accessToken = jwtUtils.createToken(authentication);
        return new AuthResponse(username, "User loged succexo", accessToken, true);
    }


    public Authentication authenticate(String username, String password) {
        UserDetails userDetails = this.loadUserByUsername(username);

        if (userDetails == null) {
            throw new BadCredentialsException("Invalid username or password");
        }

        if (passwordEncoder.matches(password, userDetails.getPassword())) {
            throw new BadCredentialsException("Incorrect Password");
        }

        return new UsernamePasswordAuthenticationToken(username, password, userDetails.getAuthorities());
    }

}
