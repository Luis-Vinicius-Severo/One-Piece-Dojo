package dev.onepiece.Dojo.exceptions;

import dev.onepiece.Dojo.entities.Pirata;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.Arrays;

@RestControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<MensagemErro> methodArgumentNotValid(
            HttpServletRequest request,
            MethodArgumentNotValidException ex) {

        var erroMensagem = new MensagemErro(
                request,
                HttpStatus.UNPROCESSABLE_ENTITY,
                "Campos inválidos!",
                ex.getBindingResult()
        );

        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY)
                .contentType(MediaType.APPLICATION_JSON)
                .body(erroMensagem);
    }

    @ExceptionHandler(PirataNaoEncontradoHandle.class)
    public ResponseEntity<MensagemErro> pirataNotFound(
            HttpServletRequest request,
            PirataNaoEncontradoHandle ex) {

        var erroMensagem = new MensagemErro(
                request,
                HttpStatus.NOT_FOUND,
                ex.getMessage()
        );

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .contentType(MediaType.APPLICATION_JSON)
                .body(erroMensagem);
    }

    @ExceptionHandler(MissaoNaoEncontradaException.class)
    public ResponseEntity<MensagemErro> missaoNotFound(
            HttpServletRequest request,
            MissaoNaoEncontradaException ex) {

        var erroMensagem = new MensagemErro(
                request,
                HttpStatus.NOT_FOUND,
                ex.getMessage()
        );

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .contentType(MediaType.APPLICATION_JSON)
                .body(erroMensagem);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<MensagemErro> tipoInvalido(
            HttpServletRequest request,
            MethodArgumentTypeMismatchException ex) {

        String mensagem = "O valor informado para o parâmetro '" + ex.getName() + "' é inválido.";


        var erro = new MensagemErro(
                request,
                HttpStatus.BAD_REQUEST,
                mensagem
        );

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);
    }
}
