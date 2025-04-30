package br.com.fiap.sprint1.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatioRequest {
    @NotBlank
    private String nome;

    @NotNull
    private Double largura;

    @NotNull
    private Double comprimento;

    @NotNull
    private Long filialId;
}
