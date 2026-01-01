package dev.onepiece.Dojo.dto;

import dev.onepiece.Dojo.entities.Pirata;

public record PirataResponseDTO(
    Long id,
    String nome,
    String tripulacao,
    Pirata.Raca raca,
    Pirata.StatusPirata statusPirata
) {}

