package br.com.fiap.sprint1.dto;

public record FilialResponse(
        Long id,
        String nome,
        String cidade,
        String pais
) {
}
