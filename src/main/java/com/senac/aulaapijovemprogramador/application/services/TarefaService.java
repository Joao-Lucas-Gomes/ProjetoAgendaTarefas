package com.senac.aulaapijovemprogramador.application.services;


import com.senac.aulaapijovemprogramador.application.dto.tarefas.TarefaRequestDto;
import com.senac.aulaapijovemprogramador.application.dto.tarefas.TarefaResponseDto;
import com.senac.aulaapijovemprogramador.domain.entities.Tarefa;
import com.senac.aulaapijovemprogramador.domain.repository.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class TarefaService {
    @Autowired
    private TarefaRepository tarefaRepository;

    public TarefaResponseDto save(TarefaRequestDto tarefaRequestDto) {
        Tarefa tarefa = new Tarefa(tarefaRequestDto);
        TarefaResponseDto tarefaResponseDto = new TarefaResponseDto(tarefaRepository.save(tarefa));
        return tarefaResponseDto;
    }
}
