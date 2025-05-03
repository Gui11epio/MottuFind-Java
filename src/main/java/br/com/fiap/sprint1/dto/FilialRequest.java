package br.com.fiap.sprint1.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FilialRequest {

    @NotBlank(message = "O nome da filial é obrigatório.")
    @Size(max = 60, message = "O nome deve ter no máximo 60 caracteres.")
    @Pattern(
            regexp = "^[A-Za-zÀ-ÿ0-9\\s\\-]+$",
            message = "O nome da filial deve conter apenas letras, números, espaços e traços."
    )
    @Schema(example = "Unidade Rio de Janeiro", description = "Nome da filial")
    private String nome;

    @NotBlank(message = "a cidade da filial é obrigatório")
    @Pattern(
            regexp = "^[A-Za-zÀ-ÿ\\s]+$",
            message = "A cidade deve conter apenas letras e espaços."
    )
    @Schema(example = "Rio de Janeiro", description = "Cidade da filial")
    private String cidade;

    @NotBlank(message = "O país da filial é obrigatório")
    @Pattern(
            regexp = "^[A-Za-zÀ-ÿ\\s]+$",
            message = "O país deve conter apenas letras e espaços."
    )
    @Schema(example = "Brasil", description = "País da filial")
    private String pais;
}
