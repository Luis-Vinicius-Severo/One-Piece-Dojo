package dev.onepiece.Dojo.service;

import dev.onepiece.Dojo.repositories.MissaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MissaoService {
    private final MissaoRepository missaoRepository;

}
