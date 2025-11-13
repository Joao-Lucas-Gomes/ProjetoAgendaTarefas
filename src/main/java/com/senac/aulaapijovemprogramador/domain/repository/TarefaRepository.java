package com.senac.aulaapijovemprogramador.domain.repository;

import com.senac.aulaapijovemprogramador.domain.entities.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TarefaRepository extends JpaRepository<Tarefa,Long> {
}
