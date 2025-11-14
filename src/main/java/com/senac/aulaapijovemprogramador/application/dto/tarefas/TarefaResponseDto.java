package com.senac.aulaapijovemprogramador.application.dto.tarefas;

import com.senac.aulaapijovemprogramador.domain.entities.Tarefa;
import com.senac.aulaapijovemprogramador.domain.valueobjects.StatusProjeto;

import java.time.LocalDate;

public record TarefaResponseDto(Long id, String descricao, LocalDate dataCriacao, StatusProjeto  statusProjeto) {
    public TarefaResponseDto(Tarefa tarefa){
        this(tarefa.getId(),tarefa.getDescricao(),tarefa.getDataCriacao(),tarefa.getStatusProjeto());
    }
}
