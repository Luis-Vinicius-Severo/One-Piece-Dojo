package dev.onepiece.Dojo.controllers;

import dev.onepiece.Dojo.dto.PirataDTO;
import dev.onepiece.Dojo.service.PirataService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/piratas")
@RestController
public class PirataController {

    private final PirataService pirataService;

    @PostMapping
    public ResponseEntity<PirataDTO> criarPirata(@RequestBody @Valid PirataDTO pirataDTO){
        PirataDTO criar = pirataService.criarPirata(pirataDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(criar);
    }
}
