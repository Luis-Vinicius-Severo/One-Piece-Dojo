package dev.onepiece.Dojo.service;

import dev.onepiece.Dojo.dto.PirataCreateDTO;
import dev.onepiece.Dojo.dto.PirataResponseDTO;
import dev.onepiece.Dojo.entities.Pirata;
import dev.onepiece.Dojo.exceptions.PirataNaoEncontradoHandle;
import dev.onepiece.Dojo.repositories.PirataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PirataService {

    private final PirataRepository pirataRepository;

    public PirataCreateDTO criarPirata(PirataCreateDTO pirataCreateDTO){
        Pirata pirata = new Pirata();
        pirata.setNome(pirataCreateDTO.nome());
        pirata.setTripulacao(pirataCreateDTO.tripulacao());
        pirata.setRaca(pirataCreateDTO.raca());
        pirata.setStatus(pirataCreateDTO.status());

        Pirata salvarPirata = pirataRepository.save(pirata);

        return new PirataCreateDTO(
                salvarPirata.getNome(),
                salvarPirata.getTripulacao(),
                salvarPirata.getRaca(),
                salvarPirata.getStatus()
        );

    }

    public List<PirataResponseDTO> buscarPiratas(){
        return pirataRepository.findAll()
                .stream()
                .map(pirata -> new PirataResponseDTO(
                        pirata.getId(),
                        pirata.getNome(),
                        pirata.getTripulacao(),
                        pirata.getRaca(),
                        pirata.getStatus()
                ))
                .collect(Collectors.toList());

    }

    public PirataResponseDTO buscarPirataPorId(Long id){
        Pirata pirata = pirataRepository.findById(id)
                .orElseThrow(() -> new PirataNaoEncontradoHandle(id));
        return new PirataResponseDTO(
                pirata.getId(),
                pirata.getNome(),
                pirata.getTripulacao(),
                pirata.getRaca(),
                pirata.getStatus()
        );
    }

    public List<PirataResponseDTO> buscarPirataPorRaca(Pirata.Raca raca){
        return pirataRepository.findByRaca(raca)
                .stream()
                .map(pirata -> new PirataResponseDTO(
                        pirata.getId(),
                        pirata.getNome(),
                        pirata.getTripulacao(),
                        pirata.getRaca(),
                        pirata.getStatus()
                ))
                .collect(Collectors.toList());
    }

    public void deletarPirata(Long id){
        Pirata pirata = pirataRepository.findById(id)
                .orElseThrow(() -> new PirataNaoEncontradoHandle(id));
        pirataRepository.delete(pirata);
    }

    public PirataResponseDTO atualizarPirata(Long id, PirataCreateDTO pirataCreateDTO){
        Pirata pirata = pirataRepository.findById(id)
                    .orElseThrow(() -> new PirataNaoEncontradoHandle(id));

        pirata.setNome(pirataCreateDTO.nome());
        pirata.setTripulacao(pirataCreateDTO.tripulacao());
        pirata.setRaca(pirataCreateDTO.raca());
        pirata.setStatus(pirataCreateDTO.status());

        Pirata atualizar = pirataRepository.save(pirata);

        return new PirataResponseDTO(
                atualizar.getId(),
                atualizar.getNome(),
                atualizar.getTripulacao(),
                atualizar.getRaca(),
                atualizar.getStatus()
        );

    }

}
