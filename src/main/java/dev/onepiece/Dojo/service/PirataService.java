package dev.onepiece.Dojo.service;

import dev.onepiece.Dojo.dto.PirataDTO;
import dev.onepiece.Dojo.entities.Pirata;
import dev.onepiece.Dojo.repositories.PirataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

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

    public List<PirataDTO> buscarPiratas(){
        return pirataRepository.findAll()
                .stream()
                .map(pirata -> new PirataDTO(
                        pirata.getNome(),
                        pirata.getTripulacao(),
                        pirata.getRaca(),
                        pirata.getStatus()
                ))
                .collect(Collectors.toList());

    }

    public List<PirataDTO> buscarPiratasPorId(UUID id){
        return pirataRepository.findById(id)
                .stream()
                .map(pirata -> new PirataDTO(
                        pirata.getNome(),
                        pirata.getTripulacao(),
                        pirata.getRaca(),
                        pirata.getStatus()
                ))
                .collect(Collectors.toList());
    }

    public List<PirataDTO> buscarPirataPorRaca(String raca){
        return pirataRepository.findByRacaIgnoreCase(raca)
                .stream()
                .map(pirata -> new PirataDTO(
                        pirata.getNome(),
                        pirata.getTripulacao(),
                        pirata.getRaca(),
                        pirata.getStatus()
                ))
                .collect(Collectors.toList());
    }

    public void deletarPirata(UUID id){
        Pirata pirata = pirataRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pirata com ID " + id + " não encontrado"));
        pirataRepository.delete(pirata);
    }

}
