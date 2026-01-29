package dev.onepiece.Dojo.controllers;

import dev.onepiece.Dojo.dto.PirataCreateDTO;
import dev.onepiece.Dojo.dto.PirataResponseDTO;
import dev.onepiece.Dojo.entities.Pirata;
import dev.onepiece.Dojo.service.PirataService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/piratas")
@RestController
public class PirataController {

    private final PirataService pirataService;

    @PostMapping
    public ResponseEntity<PirataCreateDTO> criarPirata(@RequestBody @Valid PirataCreateDTO pirataCreateDTO){
        PirataCreateDTO criar = pirataService.criarPirata(pirataCreateDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(criar);
    }

    @GetMapping
    public ResponseEntity<List<PirataResponseDTO>> buscarPiratas(){
        var piratas = pirataService.buscarPiratas();
        return ResponseEntity.ok(piratas);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<PirataResponseDTO> buscarPiratasPorId(@PathVariable Long id){
        var pirata = pirataService.buscarPirataPorId(id);
        return ResponseEntity.ok(pirata);
    }

    @GetMapping("/raca/{raca}")
    public ResponseEntity<List<PirataResponseDTO>> buscarPirataPorRaca(@PathVariable Pirata.Raca raca){
        var pirata = pirataService.buscarPirataPorRaca(raca);
        return ResponseEntity.ok(pirata);
    }

    @DeleteMapping("/id/{id}")
    public ResponseEntity<List<PirataResponseDTO>> deletarPirata(@PathVariable Long id){
        pirataService.deletarPirata(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<PirataResponseDTO> atualizarPirata(@PathVariable Long id, @RequestBody @Valid PirataCreateDTO pirataCreateDTO){
        PirataResponseDTO atualizar = pirataService.atualizarPirata(id,pirataCreateDTO);
        return ResponseEntity.ok(atualizar);
    }
}
