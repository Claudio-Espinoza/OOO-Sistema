package org.ooo.backend.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "lecciones")
@Getter
@Setter
public class Leccion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "id_curso", nullable = false)
    private Curso curso;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private int puntuacion;

    @OneToOne(mappedBy = "leccion", cascade = CascadeType.ALL)
    private ContenidoLeccion contenidoLeccion;

    @OneToMany(mappedBy = "leccion")
    private List<Comentario> comentarios;

}
