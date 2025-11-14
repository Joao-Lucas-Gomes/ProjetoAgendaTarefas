package com.senac.aulaapijovemprogramador.presentation;

import com.senac.aulaapijovemprogramador.application.dto.tarefas.TarefaRequestDto;
import com.senac.aulaapijovemprogramador.application.dto.tarefas.TarefaResponseDto;
import com.senac.aulaapijovemprogramador.application.services.TarefaService;
import com.senac.aulaapijovemprogramador.domain.entities.Tarefa;
import com.senac.aulaapijovemprogramador.domain.repository.TarefaRepository;
import com.senac.aulaapijovemprogramador.domain.valueobjects.StatusProjeto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

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

    @PutMapping("/{id}/iniciarTarefa")
    public ResponseEntity<TarefaResponseDto> iniciarTarefa(@PathVariable Long id){
        TarefaResponseDto tarefaResponseDto = tarefaService.iniciarTarefa(id);
        return ResponseEntity.ok(tarefaResponseDto);
    }
    @PutMapping("/{id}/concluirTarefa")
    public ResponseEntity<TarefaResponseDto> concluirTarefa(@PathVariable Long id){
        TarefaResponseDto tarefaResponseDto = tarefaService.concluirTarefa(id);
        return ResponseEntity.ok(tarefaResponseDto);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarTarefa(@PathVariable Long id){
        tarefaService.deletarTarefa(id);
        return ResponseEntity.noContent().build();
    }
    @GetMapping
    public ResponseEntity<List<TarefaResponseDto>> listarTarefa(){
        List<TarefaResponseDto> tarefaResponseDto = tarefaService.listarTarefa();
        return ResponseEntity.ok(tarefaResponseDto);
    }
    @GetMapping("/{id}")
    public ResponseEntity<TarefaResponseDto> buscarPorId(@PathVariable Long id){
        TarefaResponseDto tarefaResponseDto = tarefaService.buscarPorId(id);
        return ResponseEntity.ok(tarefaResponseDto);
    }
}
