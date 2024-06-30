package org.ooo.backend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "desafios")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Desafio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_curso", nullable = false)
    @JsonIgnore
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
