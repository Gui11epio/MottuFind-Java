package br.com.fiap.sprint1.dto;

public record LeitorRfidResponse(

        String localizacao,
        String ipDispositivo,
        Long patioId
) {
}
