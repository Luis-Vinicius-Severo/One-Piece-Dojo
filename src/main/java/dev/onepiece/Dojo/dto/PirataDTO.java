package dev.onepiece.Dojo.dto;


import dev.onepiece.Dojo.entities.Pirata;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


public record PirataDTO(
            @NotBlank(message = "O nome é obrigatório")
            String nome,

            @NotBlank(message = "A tripulação é obrigatória")
            String tripulacao,

            @NotBlank(message = "A raça é obrigatória")
            Pirata.Raca raca,

            @NotNull
            Pirata.StatusPirata status
    ) {}
