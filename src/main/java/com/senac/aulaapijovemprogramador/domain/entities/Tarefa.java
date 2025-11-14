package com.senac.aulaapijovemprogramador.domain.entities;

import com.senac.aulaapijovemprogramador.application.dto.tarefas.TarefaRequestDto;
import com.senac.aulaapijovemprogramador.domain.valueobjects.StatusProjeto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Tarefa {
//    primary key
    @Id
//    auto increment
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descricao;
    private LocalDate dataCriacao;
    private StatusProjeto statusProjeto = StatusProjeto.PENDENTE;

    public Tarefa(TarefaRequestDto tarefaRequestDto) {
        this.descricao = tarefaRequestDto.descricao();
        this.dataCriacao = tarefaRequestDto.dataCriacao();
    }
}
