package br.com.fiap.sprint1.controller;

import br.com.fiap.sprint1.dto.PatioRequest;
import br.com.fiap.sprint1.dto.PatioResponse;
import br.com.fiap.sprint1.service.PatioService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/patios")
@RequiredArgsConstructor
@Tag(name = "ENDPOINT DO PÁTIO")
public class PatioController {

    private final PatioService patioService;

    @PostMapping
    public ResponseEntity<PatioResponse> criar(@Valid @RequestBody PatioRequest dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(patioService.criar(dto));
    }

    @GetMapping
    public ResponseEntity<Page<PatioResponse>> listar(Pageable pageable) {
        return ResponseEntity.ok(patioService.listar(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PatioResponse> buscarPorId(@PathVariable("id") Long id) {
        return ResponseEntity.ok(patioService.buscarPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PatioResponse> atualizar(@PathVariable Long id,
                                                      @Valid @RequestBody PatioRequest dto) {
        return ResponseEntity.ok(patioService.atualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        patioService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
