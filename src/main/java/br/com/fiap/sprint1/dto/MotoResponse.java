package br.com.fiap.sprint1.dto;

public record MotoResponse(
        String placa,
        String modelo,
        String cor,
        String status,
        Long patioId,
        Long tagId
) {

}
