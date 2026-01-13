package dev.onepiece.Dojo.service;


import dev.onepiece.Dojo.dto.MissaoCreateDTO;
import dev.onepiece.Dojo.dto.MissaoResponseDTO;
import dev.onepiece.Dojo.entities.Missao;
import dev.onepiece.Dojo.entities.Pirata;
import dev.onepiece.Dojo.repositories.MissaoRepository;
import dev.onepiece.Dojo.repositories.PirataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MissaoService {
    private final MissaoRepository missaoRepository;
    private final PirataRepository pirataRepository;


    public MissaoResponseDTO criarMissao(MissaoCreateDTO missaoCreateDTO){
        Pirata pirata = pirataRepository.findById(missaoCreateDTO.pirataId())
                .orElseThrow(() ->
                        new RuntimeException("Pirata não encontrado"));

        Missao missao  = new Missao();
        missao.setClassificacao(missaoCreateDTO.classificacao());
        missao.setTipoMissao(missaoCreateDTO.tipoMissao());
        missao.setStatusMissao(missaoCreateDTO.statusMissao());

        missao.setPirata(pirata);
        Missao salvarMissao = missaoRepository.save(missao);

        return new MissaoResponseDTO(
                salvarMissao.getId(),
                salvarMissao.getClassificacao(),
                salvarMissao.getTipoMissao(),
                salvarMissao.getStatusMissao(),
                pirata.getId()
        );
    }
}
