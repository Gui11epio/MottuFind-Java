package br.com.fiap.sprint1.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class LeituraRfidRequest {
    @NotNull
    private LocalDateTime dataHora;

    @NotNull
    private Long leitorId;

    @NotNull
    private Long tagId;
}
