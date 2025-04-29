package br.com.fiap.sprint1.controller;

import br.com.fiap.sprint1.dto.FilialRequest;
import br.com.fiap.sprint1.dto.FilialResponse;
import br.com.fiap.sprint1.service.FilialService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/filiais")
@RequiredArgsConstructor
public class FilialController {

    private final FilialService filialService;

    @PostMapping
    public ResponseEntity<FilialResponse> criar(@Valid @RequestBody FilialRequest dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(filialService.criar(dto));
    }

    @GetMapping
    public ResponseEntity<Page<FilialResponse>> listar(Pageable pageable) {
        return ResponseEntity.ok(filialService.listar(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<FilialResponse> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(filialService.buscarPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<FilialResponse> atualizar(@PathVariable Long id,
                                                       @Valid @RequestBody FilialRequest dto) {
        return ResponseEntity.ok(filialService.atualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        filialService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
