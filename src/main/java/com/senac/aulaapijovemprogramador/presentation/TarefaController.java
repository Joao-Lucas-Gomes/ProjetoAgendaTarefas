package com.senac.aulaapijovemprogramador.presentation;

import com.senac.aulaapijovemprogramador.application.dto.tarefas.TarefaRequestDto;
import com.senac.aulaapijovemprogramador.application.dto.tarefas.TarefaResponseDto;
import com.senac.aulaapijovemprogramador.application.services.TarefaService;
import com.senac.aulaapijovemprogramador.domain.entities.Tarefa;
import com.senac.aulaapijovemprogramador.domain.repository.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {

    @Autowired
    private TarefaService tarefaService;

    @PostMapping
    public ResponseEntity<TarefaResponseDto> criarTarefa(TarefaRequestDto tarefaRequestDto){
        TarefaResponseDto tarefaResponseDto = tarefaService.save(tarefaRequestDto);
        return ResponseEntity.ok(tarefaResponseDto);
    }
}
