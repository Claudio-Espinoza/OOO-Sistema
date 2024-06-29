package org.ooo.backend.repository;

import org.ooo.backend.model.ContenidoLeccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContenidoLeccionRepository extends JpaRepository<ContenidoLeccion,Integer> {
}
