package dev.onepiece.Dojo.dto;

import dev.onepiece.Dojo.entities.Pirata;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record PirataCreateDTO(
        @NotBlank(message = "O nome é obrigatório.")
        String nome,

        @NotBlank(message = "A tripulação é obrigatória.")
        String tripulacao,

        @NotNull(message = "A raça precisa ser preenchida.")
        Pirata.Raca raca,

        @NotNull(message = "O status precisa ser preenchido ")
        Pirata.StatusPirata status
) {}
