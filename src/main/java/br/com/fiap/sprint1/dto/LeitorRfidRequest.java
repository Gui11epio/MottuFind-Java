package br.com.fiap.sprint1.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LeitorRfidRequest {
    @NotBlank
    private String localizacao;

    @NotBlank
    private String ipDispositivo;

    @NotNull
    private Long patioId;
}
