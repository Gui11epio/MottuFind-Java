package br.com.fiap.sprint1.dto;

public record TagRfidResponse(
        Long id,
        String codigoIdentificacao,
        boolean ativa
) {
}
