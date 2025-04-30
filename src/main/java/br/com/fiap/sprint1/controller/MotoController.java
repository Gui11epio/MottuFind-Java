package br.com.fiap.sprint1.controller;

import br.com.fiap.sprint1.dto.MotoRequest;
import br.com.fiap.sprint1.dto.MotoResponse;
import br.com.fiap.sprint1.service.MotoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/motos")
@RequiredArgsConstructor
public class MotoController {

    private final MotoService motoService;

    @PostMapping
    public ResponseEntity<MotoResponse> criar(@Valid @RequestBody MotoRequest dto) {
        MotoResponse response = motoService.criarMoto(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<Page<MotoResponse>> listar(Pageable pageable) {
        return ResponseEntity.ok(motoService.listarMotos(pageable));
    }

    @GetMapping("/{placa}")
    public ResponseEntity<MotoResponse> buscarPorPlaca(@PathVariable("placa") String placa) {
        return ResponseEntity.ok(motoService.buscarPorPlaca(placa));
    }

    @PutMapping("/{placa}")
    public ResponseEntity<MotoResponse> atualizar(@PathVariable String placa,
                                                     @Valid @RequestBody MotoRequest dto) {
        return ResponseEntity.ok(motoService.atualizarMoto(placa, dto));
    }

    @DeleteMapping("/{placa}")
    public ResponseEntity<Void> deletar(@PathVariable String placa) {
        motoService.deletarMoto(placa);
        return ResponseEntity.noContent().build();
    }
}
