package br.com.fiap.sprint1.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TagRfidRequest {

    @NotBlank
    private String codigoIdentificacao;

    @NotNull
    private Boolean ativa;

}
