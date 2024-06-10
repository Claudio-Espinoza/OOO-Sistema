package org.ooo.backend.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.ooo.backend.model.utils.TipoUsuario;

@Entity
@Table(name = "Usuarios")
@Getter
@Setter
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_usuario", nullable = false)
    private TipoUsuario tipoUsuario;
}
