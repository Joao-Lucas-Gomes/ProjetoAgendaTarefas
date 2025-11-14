package com.senac.aulaapijovemprogramador.application.services;


import com.senac.aulaapijovemprogramador.application.dto.tarefas.TarefaRequestDto;
import com.senac.aulaapijovemprogramador.application.dto.tarefas.TarefaResponseDto;
import com.senac.aulaapijovemprogramador.domain.entities.Tarefa;
import com.senac.aulaapijovemprogramador.domain.repository.TarefaRepository;
import com.senac.aulaapijovemprogramador.domain.valueobjects.StatusProjeto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service

public class TarefaService {
    @Autowired
    private TarefaRepository tarefaRepository;

    public TarefaResponseDto save(TarefaRequestDto tarefaRequestDto) {
        Tarefa tarefa = new Tarefa(tarefaRequestDto);
        TarefaResponseDto tarefaResponseDto = new TarefaResponseDto(tarefaRepository.save(tarefa));
        return tarefaResponseDto;
    }
    public TarefaResponseDto iniciarTarefa(Long id){
        Tarefa tarefa = tarefaRepository.findById(id).orElseThrow(()-> new RuntimeException("Tarefa não encontrada!"));
        tarefa.setStatusProjeto(StatusProjeto.EM_ANDAMENTO);
        tarefa =  tarefaRepository.save(tarefa);
        TarefaResponseDto tarefaResponseDto = new TarefaResponseDto(tarefa);
        return tarefaResponseDto;
    }
    public TarefaResponseDto concluirTarefa(Long id){
        Tarefa tarefa = tarefaRepository.findById(id).orElseThrow(()-> new RuntimeException("Tarefa não encontrada!"));
        if(tarefa.getStatusProjeto() !=  StatusProjeto.EM_ANDAMENTO ){
            throw  new RuntimeException("Tarefa não iniciada!");
        }
        tarefa.setStatusProjeto(StatusProjeto.CONCLUIDA);
        tarefa =  tarefaRepository.save(tarefa);
        TarefaResponseDto tarefaResponseDto = new TarefaResponseDto(tarefa);
        return tarefaResponseDto;
    }
    public void deletarTarefa(Long id){
        Tarefa tarefa = tarefaRepository.findById(id).orElseThrow(()-> new RuntimeException("Tarefa não encontrada!"));
        if(tarefa.getStatusProjeto() != StatusProjeto.CONCLUIDA){
            throw new RuntimeException("Tarefa não concluida!");
        }
        tarefaRepository.deleteById(tarefa.getId());
    }
    public List<TarefaResponseDto> listarTarefa(){
        List<Tarefa>tarefas = tarefaRepository.findAll();
        List<TarefaResponseDto> tarefaResponseDtos = tarefas.stream().map(tarefa -> new TarefaResponseDto(tarefa)).collect(Collectors.toList());
        return tarefaResponseDtos;
    }
    public TarefaResponseDto buscarPorId(Long id){
        Tarefa tarefa = tarefaRepository.findById(id).orElseThrow(()-> new RuntimeException("Tarefa não encontrada!"));
        return new TarefaResponseDto(tarefa);
    }
}
