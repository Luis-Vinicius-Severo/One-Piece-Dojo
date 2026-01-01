package dev.onepiece.Dojo.dto;

import dev.onepiece.Dojo.entities.Missao;

import java.util.UUID;

public record MissaoResponseDTO (
        UUID id,
        Missao.Classificacao classificacao,
        Missao.TipoMissao tipoMissao,
        Missao.StatusMissao statusMissao
){}
