package br.com.fiap.sprint1.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.antlr.v4.runtime.misc.NotNull;

@Data
@AllArgsConstructor
public class MotoRequest {
    @NotBlank
    private String placa;

    @NotBlank
    private String modelo;

    @NotBlank
    private String marca;

    @NotBlank
    private String status;

    @NotNull
    private Long patioId;

    @NotNull
    private Long tagId;

}
