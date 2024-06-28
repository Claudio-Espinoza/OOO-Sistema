package org.ooo.backend.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "desfios")
@Getter
@Setter
public class Desafio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_curso", nullable = false)
    private Curso curso;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String autor;

    @Column(nullable = false)
    private double puntuacionPositiva;

    @Column(nullable = false)
    private double puntuacionNegativa;

    @Column(nullable = false)
    private String direccionPdfContenido;

}
