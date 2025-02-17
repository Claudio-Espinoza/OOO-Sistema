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

    @Column(name = "type")
    private String type;

    @Column(name = "descripcion", columnDefinition = "TEXT")
    private String descripcion;

    @Column(name = "curso")
    private String nombreCurso;

    @Column(nullable = false)
    private String autor;

    @Column(nullable = false)
    private double puntuacionPositiva;

    @Column(nullable = false)
    private double puntuacionNegativa;

    //Para efectos de prueba va a quedae en true, pero deberia ser False
    @Column(nullable = true)
    private String direccionPdfContenido;

}
