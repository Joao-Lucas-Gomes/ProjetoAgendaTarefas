package com.senac.aulaapijovemprogramador.domain.excecptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class TarefaNaoEncontradaException extends EntidadeNaoEncontradaException {

    public TarefaNaoEncontradaException(String message) {
        super(message);
    }
    public TarefaNaoEncontradaException(Long id) {
        this(String.format("Não existe tarefa com este ID %d", id));
    }
}
