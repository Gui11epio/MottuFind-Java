package br.com.fiap.MottuFind.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatioResponse{
    private Long id;
    private String nome;
    private Double largura;
    private Double comprimento;
    private Long filialId;
}
