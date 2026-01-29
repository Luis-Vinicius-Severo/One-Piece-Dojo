package dev.onepiece.Dojo.exceptions;

public class PirataNaoEncontradoHandle extends RuntimeException {

    public PirataNaoEncontradoHandle(Long id) {
        super("Pirata com id " + id + " não encontrado");
    }
}
