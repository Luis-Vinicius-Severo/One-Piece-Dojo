package dev.onepiece.Dojo.dto;


import dev.onepiece.Dojo.entities.StatusMissao;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record MissaoDTO(
     @NotBlank(message = "A classificacao é obrigatória")
     String classificacao,

     @NotBlank(message = "O tipoMissao é obrigatorio")
     String tipoMissao,

     @NotNull
     StatusMissao missao
){}
