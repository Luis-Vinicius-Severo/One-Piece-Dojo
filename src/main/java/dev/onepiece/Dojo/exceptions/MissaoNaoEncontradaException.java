package dev.onepiece.Dojo.exceptions;

import org.springframework.web.bind.annotation.RestControllerAdvice;


public class MissaoNaoEncontradaException extends RuntimeException {
    public MissaoNaoEncontradaException(Long id) {
        super("Missão com ID " + id + " não encontrada");
    }
}
