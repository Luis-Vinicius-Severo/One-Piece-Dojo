package dev.onepiece.Dojo.controllers;

import dev.onepiece.Dojo.dto.PirataDTO;
import dev.onepiece.Dojo.service.PirataService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

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

    @GetMapping
    public ResponseEntity<List<PirataDTO>> buscarPiratas(){
        var piratas = pirataService.buscarPiratas();
        return ResponseEntity.ok(piratas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<PirataDTO>> buscarPiratasPorId(@PathVariable UUID id){
        var pirata = pirataService.buscarPiratasPorId(id);
        return ResponseEntity.ok(pirata);
    }
}
