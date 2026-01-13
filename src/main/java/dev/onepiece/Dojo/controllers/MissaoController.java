package dev.onepiece.Dojo.controllers;

import dev.onepiece.Dojo.dto.MissaoCreateDTO;
import dev.onepiece.Dojo.dto.MissaoResponseDTO;
import dev.onepiece.Dojo.service.MissaoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/missao")
@RestController
public class MissaoController {

    private final MissaoService missaoServices;

    @PostMapping
    public ResponseEntity<MissaoResponseDTO> criarMissao (
            @RequestBody @Valid MissaoCreateDTO missaoCreateDTO){

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(missaoServices.criarMissao(missaoCreateDTO));
    }
}
