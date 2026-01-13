package dev.onepiece.Dojo.dto;

import dev.onepiece.Dojo.entities.Missao;

public record MissaoResponseDTO (
        Long id,
        Missao.Classificacao classificacao,
        Missao.TipoMissao tipoMissao,
        Missao.StatusMissao statusMissao,
        Long pirataId
){}
