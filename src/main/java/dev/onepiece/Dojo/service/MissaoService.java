package dev.onepiece.Dojo.service;

import dev.onepiece.Dojo.dto.MissaoDTO;
import dev.onepiece.Dojo.entities.Missao;
import dev.onepiece.Dojo.repositories.MissaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MissaoService {
    private final MissaoRepository missaoRepository;

}
