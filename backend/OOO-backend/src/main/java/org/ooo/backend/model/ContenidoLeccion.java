package org.ooo.backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "contenido_leccion")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ContenidoLeccion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    @JoinColumn(name = "id_leccion", nullable = false)
    private Leccion leccion;

    @Column(columnDefinition = "TEXT")
    private String contenido;
}
