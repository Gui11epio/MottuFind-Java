package br.com.fiap.MottuFind.controller.api;

import br.com.fiap.MottuFind.dto.request.PatioRequest;
import br.com.fiap.MottuFind.dto.response.PatioResponse;
import br.com.fiap.MottuFind.model.Patio;
import br.com.fiap.MottuFind.service.PatioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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

    @Operation(summary = "Cadastrar Pátio")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Pátio cadastrado com sucesso",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Patio.class))}),
            @ApiResponse(responseCode = "400", description = "Atributos informados são inválidos",
                    content = @Content(schema = @Schema()))
    })
    @PostMapping
    public ResponseEntity<PatioResponse> criar(@Valid @RequestBody PatioRequest dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(patioService.criar(dto));
    }

    @Operation(summary = "Listar pátios por meio de páginas")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "404", description = "Nenhum pátio encontrado",
                    content = @Content(schema = @Schema())),
            @ApiResponse(responseCode = "200", description = "Pátio encontrado com sucesso",
                    content = @Content(schema = @Schema()))
    })
    @GetMapping
    public ResponseEntity<Page<PatioResponse>> listar(Pageable pageable) {
        return ResponseEntity.ok(patioService.listar(pageable));
    }

    @Operation(summary = "Retorna um pátio pelo Id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Pátio encontrado com sucesso",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = PatioResponse.class))}),
            @ApiResponse(responseCode = "404", description = "Nenhum pátio encontrado",
                    content = @Content(schema = @Schema()))
    })
    @GetMapping("/{id}")
    public ResponseEntity<PatioResponse> buscarPorId(@PathVariable("id") Long id) {
        return ResponseEntity.ok(patioService.buscarPorId(id));
    }

    @Operation(summary = "Atualiza um pátio pelo Id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Pátio encontrado e atualizado com sucesso",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Patio.class))}),
            @ApiResponse(responseCode = "400", description = "Nenhum pátio encontrado para atualizar",
                    content = @Content(schema = @Schema()))
    })
    @PutMapping("/{id}")
    public ResponseEntity<PatioResponse> atualizar(@PathVariable Long id,
                                                      @Valid @RequestBody PatioRequest dto) {
        return ResponseEntity.ok(patioService.atualizar(id, dto));
    }

    @Operation(summary = "Exclui um pátio pelo Id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "400", description = "Nenhum pátio encontrado para excluir",
                    content = @Content(schema = @Schema())),
            @ApiResponse(responseCode = "204", description = "Pátio excluido com sucesso",
                    content = @Content(schema = @Schema()))
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        patioService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
