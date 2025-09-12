package dto.request;

import model.MotoModelo;
import model.MotoStatus;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MotoRequest {
    @NotBlank
    @Pattern(regexp = "^[A-Z]{3}[0-9][A-Z0-9][0-9]{2}$", message = "Placa inválida. Use o formato ABC1D23.")
    @Schema(example = "ABC1D23", description = "Segue o padrão MercoSul")
    private String placa;

    @NotNull(message = "O modelo é obrigatório")
    @Schema(example = "SPORT", description = "Modelos da moto(SPORT,POP,ELETRICA)")
    private MotoModelo modelo;

    @NotBlank(message = "A marca é obrigatória.")
    @Pattern(
            regexp = "^[A-Za-zÀ-ÿ\\s]+$",
            message = "A marca deve conter apenas letras e espaços."
    )
    @Schema(example = "Honda")
    private String marca;

    @NotNull(message = "O status da moto é obrigatório")
    @Schema(example = "MANUTENCAO", description = "Modelos da moto(LIGADO,DESLIGADO,MANUTENCAO,DISPONIVEL)")
    private MotoStatus status;

    @NotNull(message = "O Id do pátio é obrigatório")
    @Positive(message = "O ID do pátio deve ser positivo.")
    @Schema(example = "1", description = "ID do pátio em que a moto está cadastrada")
    private Long patioId;

    @NotNull(message = "O Id do pátio é obrigatório")
    @Positive(message = "O ID do pátio deve ser positivo.")
    @Schema(example = "1", description = "ID da Tag em que a moto está cadastrada")
    private Long tagId;

}
