package org.ooo.backend.repository;

import jakarta.annotation.Nonnull;
import org.ooo.backend.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CursoRepository extends JpaRepository<Curso,Integer> {

    @Override
    @Nonnull
    List<Curso> findAll();
}
