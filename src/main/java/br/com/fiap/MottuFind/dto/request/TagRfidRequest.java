package br.com.fiap.MottuFind.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TagRfidRequest {

    @NotBlank
    private String codigoIdentificacao;

    @NotNull
    private Boolean ativa;

}
