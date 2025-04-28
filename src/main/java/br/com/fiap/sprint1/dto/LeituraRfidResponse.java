package br.com.fiap.sprint1.dto;

import java.time.LocalDateTime;

public record LeituraRfidResponse(
        Long id,
        LocalDateTime dataHora,
        Long leitorId,
        Long tagId

) {
}
