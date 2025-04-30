package br.com.fiap.sprint1.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FilialRequest {

    @NotBlank
    private String nome;

    @NotBlank
    private String cidade;

    @NotBlank
    private String pais;
}
