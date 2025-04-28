package br.com.fiap.sprint1.dto;

public record PatioResponse(
        String nome,
        Double largura,
        Double comprimento,
        Long filialId
){
}
