package dev.onepiece.Dojo.controllers;

import dev.onepiece.Dojo.dto.MissaoCreateDTO;
import dev.onepiece.Dojo.dto.MissaoResponseDTO;
import dev.onepiece.Dojo.entities.Missao;
import dev.onepiece.Dojo.service.MissaoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/missao")
@RestController
public class MissaoController {

    private final MissaoService missaoServices;

    @PostMapping
    public ResponseEntity<MissaoResponseDTO> criarMissao(@RequestBody @Valid MissaoCreateDTO missaoCreateDTO) {
        MissaoResponseDTO response = missaoServices.criarMissao(missaoCreateDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(response);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<MissaoResponseDTO> buscarMissaoPorId(@PathVariable Long id) {
        MissaoResponseDTO missao = missaoServices.buscarMissaoPorId(id);
        return ResponseEntity.ok(missao);

    }

    @GetMapping
    public ResponseEntity<List<MissaoResponseDTO>> buscarTodasMissoes() {
        List<MissaoResponseDTO> response = missaoServices.buscarTodasMissoes();
        return ResponseEntity.ok(response);
    }
}

