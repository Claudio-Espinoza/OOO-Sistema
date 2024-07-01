package org.ooo.backend.repository;

import org.ooo.backend.model.Desafio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DesafioRespository extends JpaRepository<Desafio,Integer> {
    List<Desafio> findAllByCursoId (int cursoId);
}
