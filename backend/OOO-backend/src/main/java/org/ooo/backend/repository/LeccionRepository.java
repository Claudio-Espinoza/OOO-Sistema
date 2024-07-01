package org.ooo.backend.repository;

import org.ooo.backend.model.Leccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LeccionRepository extends JpaRepository<Leccion,Integer> {
    List<Leccion> findAllByCursoId (int cursoId);
}
