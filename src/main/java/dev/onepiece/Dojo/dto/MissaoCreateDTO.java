package dev.onepiece.Dojo.dto;

import dev.onepiece.Dojo.entities.Missao;
import jakarta.validation.constraints.NotNull;

public record MissaoCreateDTO(
    @NotNull
    Missao.Classificacao classificacao,

    @NotNull
    Missao.TipoMissao tipoMissao,

    @NotNull
    Missao.StatusMissao missao
){}
