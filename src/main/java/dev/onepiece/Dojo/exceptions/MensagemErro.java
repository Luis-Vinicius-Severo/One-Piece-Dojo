package dev.onepiece.Dojo.exceptions;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.servlet.http.HttpServletRequest;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.List;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class MensagemErro {

    private String path;
    private int status;
    private String error;
    private List<String> detalhes;

    public MensagemErro(HttpServletRequest request, HttpStatus status, String message) {
        this.path = request.getRequestURI();
        this.status = status.value();
        this.error = message;
    }

    public MensagemErro(HttpServletRequest request, HttpStatus status, String message, BindingResult result) {
        this.path = request.getRequestURI();
        this.status = status.value();
        this.error = message;
        this.detalhes = result.getFieldErrors()
                .stream()
                .map(FieldError::getDefaultMessage)
                .toList();
    }

    public String getPath() {
        return path;
    }

    public int getStatus() {
        return status;
    }

    public String getError() {
        return error;
    }

    public List<String> getDetalhes() {
        return detalhes;
    }
}
