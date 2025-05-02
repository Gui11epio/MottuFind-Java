package br.com.fiap.sprint1.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatioRequest {
    @NotBlank(message = "O nome do pátio é obrigatório.")
    @Size(min = 3, max = 40, message = "O nome deve ter entre 3 e 40 caracteres.")
    @Pattern(
            regexp = "^[A-Za-zÀ-ÿ0-9\\s\\-]+$",
            message = "O nome do pátio deve conter apenas letras, números, espaços e traços."
    )
    private String nome;

    @NotNull(message = "A largura é obrigatória.")
    @DecimalMin(value = "5.0", inclusive = true, message = "A largura mínima do pátio deve ser 5 metros.")
    @DecimalMax(value = "500.0", message = "A largura máxima do pátio é 500 metros.")
    private Double largura;

    @NotNull(message = "O comprimento é obrigatório.")
    @DecimalMin(value = "5.0", message = "O comprimento mínimo do pátio deve ser 5 metros.")
    @DecimalMax(value = "1000.0", message = "O comprimento máximo do pátio é 1000 metros.")
    private Double comprimento;

    @NotNull(message = "O ID da filial é obrigatório.")
    @Positive(message = "O ID da filial deve ser positivo.")
    private Long filialId;
}
