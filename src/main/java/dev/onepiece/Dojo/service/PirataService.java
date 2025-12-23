package dev.onepiece.Dojo.service;

import dev.onepiece.Dojo.dto.PirataDTO;
import dev.onepiece.Dojo.entities.Pirata;
import dev.onepiece.Dojo.repositories.PirataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PirataService {

    private final PirataRepository pirataRepository;

    public PirataDTO criarPirata(PirataDTO pirataDTO){
        Pirata pirata = new Pirata();
        pirata.setNome(pirataDTO.nome());
        pirata.setTripulacao(pirataDTO.tripulacao());
        pirata.setRaca(pirataDTO.raca());
        pirata.setStatus(pirataDTO.status());

        Pirata salvarPirata = pirataRepository.save(pirata);

        return new PirataDTO(
                salvarPirata.getNome(),
                salvarPirata.getTripulacao(),
                salvarPirata.getRaca(),
                salvarPirata.getStatus()
        );

    }
}
