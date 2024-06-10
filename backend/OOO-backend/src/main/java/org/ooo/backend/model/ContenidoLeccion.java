package org.ooo.backend.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "contenido_leccion")
@Getter
@Setter
public class ContenidoLeccion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne
    @JoinColumn(name = "id_leccion", nullable = false)
    private Leccion leccion;

    @Column(columnDefinition = "TEXT")
    private String contenido;
}
