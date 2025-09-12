package controller;

import dto.request.FilialRequest;
import dto.response.FilialResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import model.Filial;
import service.FilialService;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(name = "ENDPOINT DA FILIAL")
public class FilialController {

    private final FilialService filialService;


    @Operation(summary = "Cadastrar filial")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Filial cadastrada com sucesso",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Filial.class))}),
            @ApiResponse(responseCode = "400", description = "Atributos informados são inválidos",
                    content = @Content(schema = @Schema()))
    })


    @PostMapping
    public ResponseEntity<FilialResponse> criar(@Valid @RequestBody FilialRequest dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(filialService.criar(dto));
    }


    @Operation(summary = "Listar filiais por meio de páginas")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "404", description = "Nenhuma filial encontrada",
                    content = @Content(schema = @Schema())),
            @ApiResponse(responseCode = "200", description = "Filial encontrada com sucesso",
                    content = @Content(schema = @Schema()))
    })


    @GetMapping
    public ResponseEntity<Page<FilialResponse>> listar(Pageable pageable) {
        return ResponseEntity.ok(filialService.listar(pageable));
    }


    @Operation(summary = "Retorna uma filial pelo Id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Filial encontrada com sucesso",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = FilialResponse.class))}),
            @ApiResponse(responseCode = "404", description = "Nenhuma filial encontrada",
                    content = @Content(schema = @Schema()))
    })


    @GetMapping("/{id}")
    public ResponseEntity<FilialResponse> buscarPorId(@PathVariable("id") Long id) {
        return ResponseEntity.ok(filialService.buscarPorId(id));
    }


    @Operation(summary = "Atualiza uma filial pelo Id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Filial encontrada e atualizada com sucesso",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Filial.class))}),
            @ApiResponse(responseCode = "400", description = "Nenhuma filial encontrada para atualizar",
                    content = @Content(schema = @Schema()))
    })


    @PutMapping("/{id}")
    public ResponseEntity<FilialResponse> atualizar(@PathVariable Long id,
                                                       @Valid @RequestBody FilialRequest dto) {
        return ResponseEntity.ok(filialService.atualizar(id, dto));
    }


    @Operation(summary = "Exclui uma filial pelo Id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "400", description = "Nenhuma filial encontrada para excluir",
                    content = @Content(schema = @Schema())),
            @ApiResponse(responseCode = "204", description = "Filail excluida com sucesso",
                    content = @Content(schema = @Schema()))
    })


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        filialService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
