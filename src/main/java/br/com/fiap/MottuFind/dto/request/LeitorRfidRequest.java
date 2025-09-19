package br.com.fiap.MottuFind.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LeitorRfidRequest {
    @NotBlank
    private String localizacao;

    @NotBlank
    private String ipDispositivo;

    @NotNull
    private Long patioId;
}
