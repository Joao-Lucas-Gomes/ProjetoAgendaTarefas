package com.senac.aulaapijovemprogramador.application.dto.tarefas;

import com.senac.aulaapijovemprogramador.domain.valueobjects.StatusProjeto;

import java.time.LocalDate;

public record TarefaRequestDto(String descricao, LocalDate dataCriacao) {
}
