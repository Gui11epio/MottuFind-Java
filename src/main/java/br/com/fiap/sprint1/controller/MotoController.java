package br.com.fiap.sprint1.controller;

import br.com.fiap.sprint1.dto.MotoRequest;
import br.com.fiap.sprint1.dto.MotoResponse;
import br.com.fiap.sprint1.model.Moto;
import br.com.fiap.sprint1.service.MotoService;
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

import java.util.List;

@RestController
@RequestMapping("/api/motos")
@RequiredArgsConstructor
@Tag(name = "ENDPOINT DA MOTO")
public class MotoController {

    private final MotoService motoService;

    @Operation(summary = "Cadastrar moto")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Moto cadastrado com sucesso",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Moto.class))}),
            @ApiResponse(responseCode = "400", description = "Atributos informados são inválidos",
                    content = @Content(schema = @Schema()))
    })
    @PostMapping
    public ResponseEntity<MotoResponse> criar(@Valid @RequestBody MotoRequest dto) {
        MotoResponse response = motoService.criarMoto(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @Operation(summary = "Listar motos por meio de páginas")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "404", description = "Nenhuma moto encontrada",
                    content = @Content(schema = @Schema())),
            @ApiResponse(responseCode = "200", description = "Moto encontrada com sucesso",
                    content = @Content(schema = @Schema()))
    })
    @GetMapping
    public ResponseEntity<Page<MotoResponse>> listar(Pageable pageable) {
        return ResponseEntity.ok(motoService.listarMotos(pageable));
    }

    @Operation(summary = "Retorna uma moto pela Placa")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Moto encontrada com sucesso",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = MotoResponse.class))}),
            @ApiResponse(responseCode = "404", description = "Nenhuma moto encontrada",
                    content = @Content(schema = @Schema()))
    })
    @GetMapping("/{placa}")
    public ResponseEntity<MotoResponse> buscarPorPlaca(@PathVariable("placa") String placa) {
        return ResponseEntity.ok(motoService.buscarPorPlaca(placa));
    }

    @Operation(summary = "Atualiza uma moto pela Placa")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Moto encontrada e atualizada com sucesso",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Moto.class))}),
            @ApiResponse(responseCode = "400", description = "Nenhuma moto encontrada para atualizar",
                    content = @Content(schema = @Schema()))
    })
    @PutMapping("/{placa}")
    public ResponseEntity<MotoResponse> atualizar(@PathVariable String placa,
                                                     @Valid @RequestBody MotoRequest dto) {
        return ResponseEntity.ok(motoService.atualizarMoto(placa, dto));
    }

    @Operation(summary = "Exclui uma moto pela Placa")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "400", description = "Nenhuma moto encontrada para excluir",
                    content = @Content(schema = @Schema())),
            @ApiResponse(responseCode = "204", description = "Moto excluida com sucesso",
                    content = @Content(schema = @Schema()))
    })
    @DeleteMapping("/{placa}")
    public ResponseEntity<Void> deletar(@PathVariable String placa) {
        motoService.deletarMoto(placa);
        return ResponseEntity.noContent().build();
    }
}
